package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @KeepForSdk
    public static final Creator<SafeParcelResponse> CREATOR = new zap();
    private final String mClassName;
    @VersionField(getter = "getVersionCode", id = 1)
    private final int zale;
    @Field(getter = "getFieldMappingDictionary", id = 3)
    private final zak zapy;
    @Field(getter = "getParcel", id = 2)
    private final Parcel zara;
    private final int zarb;
    private int zarc;
    private int zard;

    public SafeParcelResponse(zak zak, String str) {
        this.zale = 1;
        this.zara = Parcel.obtain();
        this.zarb = 0;
        this.zapy = (zak) Preconditions.checkNotNull(zak);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zarc = 0;
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zak zak, String str) {
        this.zale = 1;
        this.zara = Parcel.obtain();
        safeParcelable.writeToParcel(this.zara, 0);
        this.zarb = 1;
        this.zapy = (zak) Preconditions.checkNotNull(zak);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zarc = 2;
    }

    @KeepForSdk
    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        zak zak = new zak(t.getClass());
        zaa(zak, t);
        zak.zacs();
        zak.zacr();
        return new SafeParcelResponse((SafeParcelable) t, zak, canonicalName);
    }

    private static void zaa(zak zak, FastJsonResponse fastJsonResponse) {
        String str;
        Class cls = fastJsonResponse.getClass();
        if (!zak.zaa(cls)) {
            Map fieldMappings = fastJsonResponse.getFieldMappings();
            zak.zaa(cls, fieldMappings);
            for (String str2 : fieldMappings.keySet()) {
                String str22;
                FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.get(str22);
                Class cls2 = field.zapw;
                if (cls2 != null) {
                    try {
                        zaa(zak, (FastJsonResponse) cls2.newInstance());
                    } catch (Throwable e) {
                        str = "Could not instantiate an object of type ";
                        str22 = String.valueOf(field.zapw.getCanonicalName());
                        throw new IllegalStateException(str22.length() != 0 ? str.concat(str22) : new String(str), e);
                    } catch (Throwable e2) {
                        str = "Could not access object of type ";
                        str22 = String.valueOf(field.zapw.getCanonicalName());
                        throw new IllegalStateException(str22.length() != 0 ? str.concat(str22) : new String(str), e2);
                    }
                }
            }
        }
    }

    @Constructor
    SafeParcelResponse(@Param(id = 1) int i, @Param(id = 2) Parcel parcel, @Param(id = 3) zak zak) {
        this.zale = i;
        this.zara = (Parcel) Preconditions.checkNotNull(parcel);
        this.zarb = 2;
        this.zapy = zak;
        if (this.zapy == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zapy.zact();
        }
        this.zarc = 2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcelable parcelable;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zale);
        SafeParcelWriter.writeParcel(parcel, 2, zacu(), false);
        switch (this.zarb) {
            case 0:
                parcelable = null;
                break;
            case 1:
                parcelable = this.zapy;
                break;
            case 2:
                parcelable = this.zapy;
                break;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zarb);
        }
        SafeParcelWriter.writeParcelable(parcel, 3, parcelable, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final Parcel zacu() {
        switch (this.zarc) {
            case 0:
                this.zard = SafeParcelWriter.beginObjectHeader(this.zara);
                break;
            case 1:
                break;
        }
        SafeParcelWriter.finishObjectHeader(this.zara, this.zard);
        this.zarc = 2;
        return this.zara;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        if (this.zapy == null) {
            return null;
        }
        return this.zapy.zai(this.mClassName);
    }

    public Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    private final void zab(FastJsonResponse.Field<?, ?> field) {
        if ((field.zapv != -1 ? 1 : 0) == 0) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        } else if (this.zara == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        } else {
            switch (this.zarc) {
                case 0:
                    this.zard = SafeParcelWriter.beginObjectHeader(this.zara);
                    this.zarc = 1;
                    return;
                case 1:
                    return;
                case 2:
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                default:
                    throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
            }
        }
    }

    protected void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zab(field);
        SafeParcelWriter.writeInt(this.zara, field.getSafeParcelableFieldId(), i);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        zab(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zara, field.getSafeParcelableFieldId(), iArr, true);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        zab(field);
        SafeParcelWriter.writeBigInteger(this.zara, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    protected final void zab(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = (BigInteger) arrayList.get(i);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zara, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    protected void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zab(field);
        SafeParcelWriter.writeLong(this.zara, field.getSafeParcelableFieldId(), j);
    }

    protected final void zac(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        zab(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zara, field.getSafeParcelableFieldId(), jArr, true);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, float f) {
        zab(field);
        SafeParcelWriter.writeFloat(this.zara, field.getSafeParcelableFieldId(), f);
    }

    protected final void zad(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        zab(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zara, field.getSafeParcelableFieldId(), fArr, true);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, double d) {
        zab(field);
        SafeParcelWriter.writeDouble(this.zara, field.getSafeParcelableFieldId(), d);
    }

    protected final void zae(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        zab(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zara, field.getSafeParcelableFieldId(), dArr, true);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        zab(field);
        SafeParcelWriter.writeBigDecimal(this.zara, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    protected final void zaf(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        zab(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = (BigDecimal) arrayList.get(i);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zara, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    protected void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zab(field);
        SafeParcelWriter.writeBoolean(this.zara, field.getSafeParcelableFieldId(), z);
    }

    protected final void zag(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        zab(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = ((Boolean) arrayList.get(i)).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zara, field.getSafeParcelableFieldId(), zArr, true);
    }

    protected void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zab(field);
        SafeParcelWriter.writeString(this.zara, field.getSafeParcelableFieldId(), str2, true);
    }

    protected void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zab(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zara, field.getSafeParcelableFieldId(), strArr, true);
    }

    protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zab(field);
        SafeParcelWriter.writeByteArray(this.zara, field.getSafeParcelableFieldId(), bArr, true);
    }

    protected final void zaa(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zab(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, (String) map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zara, field.getSafeParcelableFieldId(), bundle, true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        zab(field);
        SafeParcelWriter.writeParcel(this.zara, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).zacu(), true);
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        zab(field);
        List arrayList2 = new ArrayList();
        arrayList.size();
        arrayList = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) obj)).zacu());
        }
        SafeParcelWriter.writeParcelList(this.zara, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    public String toString() {
        Preconditions.checkNotNull(this.zapy, "Cannot convert to JSON on client side.");
        Parcel zacu = zacu();
        zacu.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zaa(stringBuilder, this.zapy.zai(this.mClassName), zacu);
        return stringBuilder.toString();
    }

    private final void zaa(StringBuilder stringBuilder, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            Entry entry2;
            sparseArray.put(((FastJsonResponse.Field) entry2.getValue()).getSafeParcelableFieldId(), entry2);
        }
        stringBuilder.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            entry2 = (Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                stringBuilder.append("\"").append((String) entry2.getKey()).append("\":");
                if (field.zacn()) {
                    switch (field.zaps) {
                        case 0:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zab(stringBuilder, field, FastJsonResponse.zab(field, SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            HashMap hashMap = new HashMap();
                            for (String str : createBundle.keySet()) {
                                hashMap.put(str, createBundle.getString(str));
                            }
                            zab(stringBuilder, field, FastJsonResponse.zab(field, (Object) hashMap));
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + field.zaps);
                    }
                } else if (field.zapt) {
                    stringBuilder.append("[");
                    switch (field.zaps) {
                        case 0:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(stringBuilder, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(stringBuilder, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            readHeader = createParcelArray.length;
                            for (int i2 = 0; i2 < readHeader; i2++) {
                                if (i2 > 0) {
                                    stringBuilder.append(",");
                                }
                                createParcelArray[i2].setDataPosition(0);
                                zaa(stringBuilder, field.zacq(), createParcelArray[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    stringBuilder.append("]");
                } else {
                    switch (field.zaps) {
                        case 0:
                            stringBuilder.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            stringBuilder.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            stringBuilder.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            stringBuilder.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            stringBuilder.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            stringBuilder.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            stringBuilder.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            stringBuilder.append("\"").append(JsonUtils.escapeString(SafeParcelReader.createString(parcel, readHeader))).append("\"");
                            break;
                        case 8:
                            stringBuilder.append("\"").append(Base64Utils.encode(SafeParcelReader.createByteArray(parcel, readHeader))).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(Base64Utils.encodeUrlSafe(SafeParcelReader.createByteArray(parcel, readHeader)));
                            stringBuilder.append("\"");
                            break;
                        case 10:
                            Bundle createBundle2 = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle2.keySet();
                            keySet.size();
                            stringBuilder.append("{");
                            i = 1;
                            for (String str2 : keySet) {
                                if (i == 0) {
                                    stringBuilder.append(",");
                                }
                                stringBuilder.append("\"").append(str2).append("\"");
                                stringBuilder.append(":");
                                stringBuilder.append("\"").append(JsonUtils.escapeString(createBundle2.getString(str2))).append("\"");
                                i = 0;
                            }
                            stringBuilder.append("}");
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zaa(stringBuilder, field.zacq(), createParcel);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                i = 1;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            throw new ParseException("Overread allowed size end=" + validateObjectHeader, parcel);
        }
        stringBuilder.append('}');
    }

    private final void zab(StringBuilder stringBuilder, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zapr) {
            ArrayList arrayList = (ArrayList) obj;
            stringBuilder.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    stringBuilder.append(",");
                }
                zaa(stringBuilder, field.zapq, arrayList.get(i));
            }
            stringBuilder.append("]");
            return;
        }
        zaa(stringBuilder, field.zapq, obj);
    }

    private static void zaa(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(JsonUtils.escapeString(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(Base64Utils.encode((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(Base64Utils.encodeUrlSafe((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                MapUtils.writeStringMapToJson(stringBuilder, (HashMap) obj);
                return;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }
}
