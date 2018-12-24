package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader extends UPCEANReader {
    private final UPCEANReader ean13Reader = new EAN13Reader();

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, iArr, map));
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) {
        return maybeReturnResult(this.ean13Reader.decodeRow(i, bitArray, map));
    }

    public Result decode(BinaryBitmap binaryBitmap) {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap));
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        return maybeReturnResult(this.ean13Reader.decode(binaryBitmap, map));
    }

    BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_A;
    }

    protected int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder stringBuilder) {
        return this.ean13Reader.decodeMiddle(bitArray, iArr, stringBuilder);
    }

    private static Result maybeReturnResult(Result result) {
        String text = result.getText();
        if (text.charAt(0) == '0') {
            return new Result(text.substring(1), null, result.getResultPoints(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }
}
