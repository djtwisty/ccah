package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzai;
import com.google.android.gms.internal.firebase_auth.zzak;
import com.google.android.gms.internal.firebase_auth.zzam;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.android.gms.internal.firebase_auth.zzbo;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzbs;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.internal.firebase_auth.zzcc;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import org.apache.http.HttpStatus;

public abstract class zzeb extends zzb implements zzea {
    public zzeb() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzdx zzdx = null;
        String readString;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        zzdr zzdr;
        IBinder readStrongBinder2;
        IInterface queryLocalInterface2;
        String readString2;
        IBinder readStrongBinder3;
        PhoneAuthCredential phoneAuthCredential;
        ActionCodeSettings actionCodeSettings;
        switch (i) {
            case 1:
                zzdx zzdx2;
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzdx2 = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx2 = (zzdx) queryLocalInterface;
                    } else {
                        zzdx2 = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, zzdx2);
                break;
            case 2:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzb(readString, zzdx);
                break;
            case 3:
                zzdr = (zzdr) zzc.zza(parcel, zzdr.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzdr, zzdx);
                break;
            case 4:
                readString = parcel.readString();
                UserProfileChangeRequest userProfileChangeRequest = (UserProfileChangeRequest) zzc.zza(parcel, UserProfileChangeRequest.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, userProfileChangeRequest, zzdx);
                break;
            case 5:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zza(readString, readString2, zzdx);
                break;
            case 6:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zzb(readString, readString2, zzdx);
                break;
            case 7:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zzc(readString, readString2, zzdx);
                break;
            case 8:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zzd(readString, readString2, zzdx);
                break;
            case 9:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzc(readString, zzdx);
                break;
            case 10:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzd(readString, zzdx);
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                readString = parcel.readString();
                readString2 = parcel.readString();
                String readString3 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    queryLocalInterface = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder4);
                    }
                }
                zza(readString, readString2, readString3, zzdx);
                break;
            case 12:
                readString = parcel.readString();
                zzdr = (zzdr) zzc.zza(parcel, zzdr.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, zzdr, zzdx);
                break;
            case 13:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zze(readString, zzdx);
                break;
            case 14:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zze(readString, readString2, zzdx);
                break;
            case 15:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzf(readString, zzdx);
                break;
            case 16:
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzdx);
                break;
            case 17:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzg(readString, zzdx);
                break;
            case 18:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzh(readString, zzdx);
                break;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzi(readString, zzdx);
                break;
            case 20:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzj(readString, zzdx);
                break;
            case 21:
                readString = parcel.readString();
                readString2 = parcel.readString();
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder3);
                    }
                }
                zzf(readString, readString2, zzdx);
                break;
            case 22:
                zzdj zzdj = (zzdj) zzc.zza(parcel, zzdj.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzdj, zzdx);
                break;
            case 23:
                phoneAuthCredential = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(phoneAuthCredential, zzdx);
                break;
            case 24:
                readString = parcel.readString();
                phoneAuthCredential = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, phoneAuthCredential, zzdx);
                break;
            case 25:
                readString = parcel.readString();
                actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zza(readString, actionCodeSettings, zzdx);
                break;
            case 26:
                readString = parcel.readString();
                actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzb(readString, actionCodeSettings, zzdx);
                break;
            case 27:
                readString = parcel.readString();
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzk(readString, zzdx);
                break;
            case 28:
                readString = parcel.readString();
                actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface2 = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder);
                    }
                }
                zzc(readString, actionCodeSettings, zzdx);
                break;
            case 29:
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zzc.zza(parcel, EmailAuthCredential.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(emailAuthCredential, zzdx);
                break;
            case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                zzau zzau = (zzau) zzc.zza(parcel, zzau.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzau, zzdx);
                break;
            case HttpStatus.SC_PROCESSING /*102*/:
                zzbs zzbs = (zzbs) zzc.zza(parcel, zzbs.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbs, zzdx);
                break;
            case 103:
                zzbq zzbq = (zzbq) zzc.zza(parcel, zzbq.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbq, zzdx);
                break;
            case 104:
                zzce zzce = (zzce) zzc.zza(parcel, zzce.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzce, zzdx);
                break;
            case 105:
                zzai zzai = (zzai) zzc.zza(parcel, zzai.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzai, zzdx);
                break;
            case 106:
                zzak zzak = (zzak) zzc.zza(parcel, zzak.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzak, zzdx);
                break;
            case 107:
                zzaq zzaq = (zzaq) zzc.zza(parcel, zzaq.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzaq, zzdx);
                break;
            case 108:
                zzbu zzbu = (zzbu) zzc.zza(parcel, zzbu.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbu, zzdx);
                break;
            case 109:
                zzaw zzaw = (zzaw) zzc.zza(parcel, zzaw.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzaw, zzdx);
                break;
            case 111:
                zzay zzay = (zzay) zzc.zza(parcel, zzay.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzay, zzdx);
                break;
            case 112:
                zzba zzba = (zzba) zzc.zza(parcel, zzba.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzba, zzdx);
                break;
            case 113:
                zzca zzca = (zzca) zzc.zza(parcel, zzca.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzca, zzdx);
                break;
            case 114:
                zzcc zzcc = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzcc, zzdx);
                break;
            case 115:
                zzbe zzbe = (zzbe) zzc.zza(parcel, zzbe.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbe, zzdx);
                break;
            case 116:
                zzbo zzbo = (zzbo) zzc.zza(parcel, zzbo.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbo, zzdx);
                break;
            case 117:
                zzas zzas = (zzas) zzc.zza(parcel, zzas.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzas, zzdx);
                break;
            case 119:
                zzam zzam = (zzam) zzc.zza(parcel, zzam.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzam, zzdx);
                break;
            case 120:
                zzag zzag = (zzag) zzc.zza(parcel, zzag.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzag, zzdx);
                break;
            case 121:
                zzao zzao = (zzao) zzc.zza(parcel, zzao.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzao, zzdx);
                break;
            case 122:
                zzbk zzbk = (zzbk) zzc.zza(parcel, zzbk.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbk, zzdx);
                break;
            case 123:
                zzby zzby = (zzby) zzc.zza(parcel, zzby.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzby, zzdx);
                break;
            case 124:
                zzbc zzbc = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbc, zzdx);
                break;
            case 126:
                zzbg zzbg = (zzbg) zzc.zza(parcel, zzbg.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbg, zzdx);
                break;
            case 127:
                zzbm zzbm = (zzbm) zzc.zza(parcel, zzbm.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbm, zzdx);
                break;
            case 128:
                zzbi zzbi = (zzbi) zzc.zza(parcel, zzbi.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdx = (zzdx) queryLocalInterface2;
                    } else {
                        zzdx = new zzdz(readStrongBinder2);
                    }
                }
                zza(zzbi, zzdx);
                break;
            case 129:
                zzbw zzbw = (zzbw) zzc.zza(parcel, zzbw.CREATOR);
                readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzdx = queryLocalInterface2 instanceof zzdx ? (zzdx) queryLocalInterface2 : new zzdz(readStrongBinder2);
                }
                zza(zzbw, zzdx);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
