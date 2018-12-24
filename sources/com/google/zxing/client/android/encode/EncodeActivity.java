package com.google.zxing.client.android.encode;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.Contents.Type;
import com.google.zxing.client.android.FinishListener;
import com.google.zxing.client.android.Intents.Encode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public final class EncodeActivity extends Activity {
    private static final int MAX_BARCODE_FILENAME_LENGTH = 24;
    private static final Pattern NOT_ALPHANUMERIC = Pattern.compile("[^A-Za-z0-9]");
    private static final String TAG = EncodeActivity.class.getSimpleName();
    private static final String USE_VCARD_KEY = "USE_VCARD";
    private QRCodeEncoder qrCodeEncoder;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String action = intent.getAction();
        if (Encode.ACTION.equals(action) || "android.intent.action.SEND".equals(action)) {
            setContentView(C0306R.layout.encode);
        } else {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0306R.menu.encode, menu);
        Object obj = (this.qrCodeEncoder == null || !this.qrCodeEncoder.isUseVCard()) ? null : 1;
        int i = obj != null ? C0306R.string.menu_encode_mecard : C0306R.string.menu_encode_vcard;
        MenuItem findItem = menu.findItem(C0306R.id.menu_encode);
        findItem.setTitle(i);
        Intent intent = getIntent();
        if (intent != null) {
            findItem.setVisible(Type.CONTACT.equals(intent.getStringExtra(Encode.TYPE)));
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z = false;
        int itemId = menuItem.getItemId();
        if (itemId == C0306R.id.menu_share) {
            share();
            return true;
        } else if (itemId != C0306R.id.menu_encode) {
            return false;
        } else {
            Intent intent = getIntent();
            if (intent == null) {
                return false;
            }
            String str = USE_VCARD_KEY;
            if (!this.qrCodeEncoder.isUseVCard()) {
                z = true;
            }
            intent.putExtra(str, z);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
            return true;
        }
    }

    private void share() {
        FileOutputStream fileOutputStream;
        Object e;
        Throwable th;
        QRCodeEncoder qRCodeEncoder = this.qrCodeEncoder;
        if (qRCodeEncoder == null) {
            Log.w(TAG, "No existing barcode to send?");
            return;
        }
        Object contents = qRCodeEncoder.getContents();
        if (contents == null) {
            Log.w(TAG, "No existing barcode to send?");
            return;
        }
        try {
            Bitmap encodeAsBitmap = qRCodeEncoder.encodeAsBitmap();
            if (encodeAsBitmap != null) {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "BarcodeScanner"), "Barcodes");
                if (file.exists() || file.mkdirs()) {
                    File file2 = new File(file, makeBarcodeFileName(contents) + ".png");
                    if (!file2.delete()) {
                        Log.w(TAG, "Could not delete " + file2);
                    }
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            encodeAsBitmap.compress(CompressFormat.PNG, 0, fileOutputStream);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
                            intent.putExtra("android.intent.extra.SUBJECT", getString(C0306R.string.app_name) + " - " + qRCodeEncoder.getTitle());
                            intent.putExtra("android.intent.extra.TEXT", contents);
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + file2.getAbsolutePath()));
                            intent.setType("image/png");
                            intent.addFlags(524288);
                            startActivity(Intent.createChooser(intent, null));
                            return;
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            try {
                                Log.w(TAG, "Couldn't access file " + file2 + " due to " + e);
                                showErrorMessage(C0306R.string.msg_unmount_usb);
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                        return;
                                    } catch (IOException e4) {
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        fileOutputStream = null;
                        Log.w(TAG, "Couldn't access file " + file2 + " due to " + e);
                        showErrorMessage(C0306R.string.msg_unmount_usb);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                }
                Log.w(TAG, "Couldn't make dir " + file);
                showErrorMessage(C0306R.string.msg_unmount_usb);
            }
        } catch (Throwable th4) {
            Log.w(TAG, th4);
        }
    }

    private static CharSequence makeBarcodeFileName(CharSequence charSequence) {
        CharSequence replaceAll = NOT_ALPHANUMERIC.matcher(charSequence).replaceAll("_");
        if (replaceAll.length() > MAX_BARCODE_FILENAME_LENGTH) {
            return replaceAll.substring(0, MAX_BARCODE_FILENAME_LENGTH);
        }
        return replaceAll;
    }

    protected void onResume() {
        super.onResume();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.x;
        int i2 = point.y;
        if (i >= i2) {
            i = i2;
        }
        i = (i * 7) / 8;
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.qrCodeEncoder = new QRCodeEncoder(this, intent, i, intent.getBooleanExtra(USE_VCARD_KEY, false));
                Bitmap encodeAsBitmap = this.qrCodeEncoder.encodeAsBitmap();
                if (encodeAsBitmap == null) {
                    Log.w(TAG, "Could not encode barcode");
                    showErrorMessage(C0306R.string.msg_encode_contents_failed);
                    this.qrCodeEncoder = null;
                    return;
                }
                ((ImageView) findViewById(C0306R.id.image_view)).setImageBitmap(encodeAsBitmap);
                TextView textView = (TextView) findViewById(C0306R.id.contents_text_view);
                if (intent.getBooleanExtra(Encode.SHOW_CONTENTS, true)) {
                    textView.setText(this.qrCodeEncoder.getDisplayContents());
                    setTitle(this.qrCodeEncoder.getTitle());
                    return;
                }
                textView.setText("");
                setTitle("");
            } catch (Throwable e) {
                Log.w(TAG, "Could not encode barcode", e);
                showErrorMessage(C0306R.string.msg_encode_contents_failed);
                this.qrCodeEncoder = null;
            }
        }
    }

    private void showErrorMessage(int i) {
        Builder builder = new Builder(this);
        builder.setMessage(i);
        builder.setPositiveButton(C0306R.string.button_ok, new FinishListener(this));
        builder.setOnCancelListener(new FinishListener(this));
        builder.show();
    }
}
