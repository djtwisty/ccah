package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.HitBuilder;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public final class zzoy extends zzjq {
    private static final String ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final List<String> zzbhq = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, "checkout_option", "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static final Pattern zzbhr = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzbhs = Pattern.compile("metric(\\d+)");
    private static final Set<String> zzbng = CollectionUtils.setOf("", "0", "false");
    private static final Map<String, String> zzbnh = CollectionUtils.mapOf("transactionId", "&ti", "transactionAffiliation", "&ta", "transactionTax", "&tt", "transactionShipping", "&ts", "transactionTotal", "&tr", "transactionCurrency", "&cu");
    private static final Map<String, String> zzbni = CollectionUtils.mapOf("name", "&in", "sku", "&ic", "category", "&iv", Param.PRICE, "&ip", Param.QUANTITY, "&iq", Param.CURRENCY, "&cu");
    private final zzhy zzbkl;
    private final zzjj zzbnj;
    private Map<String, Object> zzbnk;

    public zzoy(Context context, zzhy zzhy) {
        this(new zzjj(context), zzhy);
    }

    @VisibleForTesting
    private zzoy(zzjj zzjj, zzhy zzhy) {
        this.zzbkl = zzhy;
        this.zzbnj = zzjj;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        String valueOf;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        this.zzbnk = zzrd.zzg(this.zzbkl.zzrh().zzqu());
        zzqp zzqp = zzqpArr[0];
        zzqp zzqs = zzqpArr.length > 1 ? zzqpArr[1] : new zzqs(Boolean.valueOf(true));
        zzqp zzqs2 = zzqpArr.length > 2 ? zzqpArr[2] : new zzqs(Boolean.valueOf(false));
        zzqp zzqp2 = zzqpArr.length > 3 ? zzqpArr[3] : zzqv.zzbpr;
        zzqp zzqp3 = zzqpArr.length > 4 ? zzqpArr[4] : zzqv.zzbpr;
        zzqp zzqs3 = zzqpArr.length > 5 ? zzqpArr[5] : new zzqs(Boolean.valueOf(false));
        zzqp zzqs4 = zzqpArr.length > 6 ? zzqpArr[6] : new zzqs(Boolean.valueOf(false));
        zzqp zzqp4 = zzqpArr.length > 7 ? zzqpArr[7] : zzqv.zzbpr;
        zzqp zzqs5 = zzqpArr.length > 8 ? zzqpArr[8] : new zzqs(Boolean.valueOf(false));
        Preconditions.checkArgument(zzqp instanceof zzqz);
        boolean z = zzqp2 == zzqv.zzbpr || (zzqp2 instanceof zzqz);
        Preconditions.checkArgument(z);
        z = zzqp3 == zzqv.zzbpr || (zzqp3 instanceof zzqz);
        Preconditions.checkArgument(z);
        z = zzqp4 == zzqv.zzbpr || (zzqp4 instanceof zzqz);
        Preconditions.checkArgument(z);
        Tracker zzec = this.zzbnj.zzec("_GTM_DEFAULT_TRACKER_");
        zzec.enableAdvertisingIdCollection(zzjp.zza(zzqs5));
        Map zzi;
        Object obj;
        List list;
        String str;
        if (zzjp.zza(zzqs3)) {
            Object obj2;
            HitBuilder screenViewBuilder = new ScreenViewBuilder();
            zzi = zzi(zzqp);
            screenViewBuilder.setAll(zzi);
            if (zzjp.zza(zzqs4)) {
                obj2 = this.zzbnk.get("ecommerce");
            } else {
                obj2 = zzrd.zzj(zzrd.zzk(zzqp4));
            }
            if (obj2 instanceof Map) {
                List<Map> list2;
                ProductAction productAction;
                ProductAction productAction2;
                Map map = (Map) obj2;
                String str2 = (String) zzi.get("&cu");
                if (str2 == null) {
                    str2 = (String) map.get("currencyCode");
                }
                if (str2 != null) {
                    screenViewBuilder.set("&cu", str2);
                }
                obj = map.get("impressions");
                if (obj instanceof List) {
                    for (Map zzi2 : (List) obj) {
                        try {
                            screenViewBuilder.addImpression(zzk(zzi2), (String) zzi2.get("list"));
                        } catch (RuntimeException e) {
                            r5 = "Failed to extract a product from event data. ";
                            str2 = String.valueOf(e.getMessage());
                            String str3;
                            if (str2.length() != 0) {
                                str2 = str3.concat(str2);
                            } else {
                                str2 = new String(str3);
                            }
                            zzhk.m1081e(str2);
                        } catch (Throwable th) {
                            this.zzbnk = null;
                        }
                    }
                }
                list = null;
                if (map.containsKey("promoClick")) {
                    list = (List) ((Map) map.get("promoClick")).get("promotions");
                } else if (map.containsKey("promoView")) {
                    list = (List) ((Map) map.get("promoView")).get("promotions");
                }
                if (r3 != null) {
                    for (Map zzi22 : r3) {
                        try {
                            Promotion promotion = new Promotion();
                            str = (String) zzi22.get("id");
                            if (str != null) {
                                promotion.setId(String.valueOf(str));
                            }
                            str = (String) zzi22.get("name");
                            if (str != null) {
                                promotion.setName(String.valueOf(str));
                            }
                            str = (String) zzi22.get("creative");
                            if (str != null) {
                                promotion.setCreative(String.valueOf(str));
                            }
                            str2 = (String) zzi22.get("position");
                            if (str2 != null) {
                                promotion.setPosition(String.valueOf(str2));
                            }
                            screenViewBuilder.addPromotion(promotion);
                        } catch (RuntimeException e2) {
                            str = "Failed to extract a promotion from event data. ";
                            str2 = String.valueOf(e2.getMessage());
                            if (str2.length() != 0) {
                                str2 = str.concat(str2);
                            } else {
                                str2 = new String(str);
                            }
                            zzhk.m1081e(str2);
                        }
                    }
                    if (map.containsKey("promoClick")) {
                        screenViewBuilder.set("&promoa", "click");
                        obj = null;
                        if (obj != null) {
                            for (String str22 : zzbhq) {
                                if (map.containsKey(str22)) {
                                    map = (Map) map.get(str22);
                                    list2 = (List) map.get("products");
                                    if (list2 != null) {
                                        for (Map zzk : list2) {
                                            try {
                                                screenViewBuilder.addProduct(zzk(zzk));
                                            } catch (RuntimeException e3) {
                                                String str4 = "Failed to extract a product from event data. ";
                                                str = String.valueOf(e3.getMessage());
                                                if (str.length() != 0) {
                                                    str = str4.concat(str);
                                                } else {
                                                    str = new String(str4);
                                                }
                                                zzhk.m1081e(str);
                                            }
                                        }
                                    }
                                    try {
                                        if (map.containsKey("actionField")) {
                                            productAction = new ProductAction(str22);
                                        } else {
                                            map = (Map) map.get("actionField");
                                            productAction2 = new ProductAction(str22);
                                            obj = map.get("id");
                                            if (obj != null) {
                                                productAction2.setTransactionId(String.valueOf(obj));
                                            }
                                            obj = map.get(Param.AFFILIATION);
                                            if (obj != null) {
                                                productAction2.setTransactionAffiliation(String.valueOf(obj));
                                            }
                                            obj = map.get(Param.COUPON);
                                            if (obj != null) {
                                                productAction2.setTransactionCouponCode(String.valueOf(obj));
                                            }
                                            obj = map.get("list");
                                            if (obj != null) {
                                                productAction2.setProductActionList(String.valueOf(obj));
                                            }
                                            obj = map.get("option");
                                            if (obj != null) {
                                                productAction2.setCheckoutOptions(String.valueOf(obj));
                                            }
                                            obj = map.get("revenue");
                                            if (obj != null) {
                                                productAction2.setTransactionRevenue(zzn(obj).doubleValue());
                                            }
                                            obj = map.get(Param.TAX);
                                            if (obj != null) {
                                                productAction2.setTransactionTax(zzn(obj).doubleValue());
                                            }
                                            obj = map.get(Param.SHIPPING);
                                            if (obj != null) {
                                                productAction2.setTransactionShipping(zzn(obj).doubleValue());
                                            }
                                            obj2 = map.get("step");
                                            if (obj2 != null) {
                                                productAction2.setCheckoutStep(zzo(obj2).intValue());
                                            }
                                            productAction = productAction2;
                                        }
                                        screenViewBuilder.setProductAction(productAction);
                                    } catch (RuntimeException e4) {
                                        str22 = "Failed to extract a product action from event data. ";
                                        valueOf = String.valueOf(e4.getMessage());
                                        zzhk.m1081e(valueOf.length() != 0 ? str22.concat(valueOf) : new String(str22));
                                    }
                                }
                            }
                        }
                    } else {
                        screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                    }
                }
                int i = 1;
                if (obj != null) {
                    for (String str222 : zzbhq) {
                        if (map.containsKey(str222)) {
                            map = (Map) map.get(str222);
                            list2 = (List) map.get("products");
                            if (list2 != null) {
                                while (r5.hasNext()) {
                                    screenViewBuilder.addProduct(zzk(zzk));
                                }
                            }
                            if (map.containsKey("actionField")) {
                                productAction = new ProductAction(str222);
                            } else {
                                map = (Map) map.get("actionField");
                                productAction2 = new ProductAction(str222);
                                obj = map.get("id");
                                if (obj != null) {
                                    productAction2.setTransactionId(String.valueOf(obj));
                                }
                                obj = map.get(Param.AFFILIATION);
                                if (obj != null) {
                                    productAction2.setTransactionAffiliation(String.valueOf(obj));
                                }
                                obj = map.get(Param.COUPON);
                                if (obj != null) {
                                    productAction2.setTransactionCouponCode(String.valueOf(obj));
                                }
                                obj = map.get("list");
                                if (obj != null) {
                                    productAction2.setProductActionList(String.valueOf(obj));
                                }
                                obj = map.get("option");
                                if (obj != null) {
                                    productAction2.setCheckoutOptions(String.valueOf(obj));
                                }
                                obj = map.get("revenue");
                                if (obj != null) {
                                    productAction2.setTransactionRevenue(zzn(obj).doubleValue());
                                }
                                obj = map.get(Param.TAX);
                                if (obj != null) {
                                    productAction2.setTransactionTax(zzn(obj).doubleValue());
                                }
                                obj = map.get(Param.SHIPPING);
                                if (obj != null) {
                                    productAction2.setTransactionShipping(zzn(obj).doubleValue());
                                }
                                obj2 = map.get("step");
                                if (obj2 != null) {
                                    productAction2.setCheckoutStep(zzo(obj2).intValue());
                                }
                                productAction = productAction2;
                            }
                            screenViewBuilder.setProductAction(productAction);
                        }
                    }
                }
            }
            zzec.send(screenViewBuilder.build());
        } else if (zzjp.zza(zzqs)) {
            zzec.send(zzi(zzqp));
        } else if (zzjp.zza(zzqs2)) {
            valueOf = (String) this.zzbnk.get("transactionId");
            if (valueOf == null) {
                zzhk.m1081e("Cannot find transactionId in data layer.");
            } else {
                List arrayList = new ArrayList();
                try {
                    Map zzi3 = zzi(zzqp);
                    zzi3.put("&t", "transaction");
                    if (zzqp2 == zzqv.zzbpr) {
                        zzi22 = zzbnh;
                    } else {
                        zzi22 = zzh(zzqp2);
                    }
                    for (Entry entry : r3.entrySet()) {
                        str = (String) this.zzbnk.get(entry.getKey());
                        if (str != null) {
                            zzi3.put((String) entry.getValue(), str);
                        }
                    }
                    arrayList.add(zzi3);
                    obj = this.zzbnk.get("transactionProducts");
                    if (obj == null) {
                        list = null;
                    } else if (obj instanceof List) {
                        List<Object> list3 = (List) obj;
                        for (Object obj3 : list3) {
                            if (!(obj3 instanceof Map)) {
                                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("transactionProducts should be of type List.");
                    }
                    if (r3 != null) {
                        for (Map zzk2 : r3) {
                            if (zzk2.get("name") == null) {
                                zzhk.m1081e("Unable to send transaction item hit due to missing 'name' field.");
                                break;
                            }
                            Map zzi4 = zzi(zzqp);
                            zzi4.put("&t", "item");
                            zzi4.put("&ti", valueOf);
                            if (zzqp3 == zzqv.zzbpr) {
                                zzi22 = zzbni;
                            } else {
                                zzi22 = zzh(zzqp3);
                            }
                            for (Entry entry2 : r3.entrySet()) {
                                Object obj4 = zzk2.get(entry2.getKey());
                                if (obj4 != null) {
                                    zzi4.put((String) entry2.getValue(), obj4.toString());
                                }
                            }
                            arrayList.add(zzi4);
                        }
                    }
                    ArrayList arrayList2 = (ArrayList) arrayList;
                    int size = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size) {
                        obj = arrayList2.get(i2);
                        i2++;
                        zzec.send((Map) obj);
                    }
                } catch (Throwable e5) {
                    zzhk.zza("Unable to send transaction", e5);
                }
            }
        } else {
            zzhk.zzab("Ignoring unknown tag.");
        }
        this.zzbnk = null;
        return zzqv.zzbpr;
    }

    private static Product zzk(Map<String, Object> map) {
        String valueOf;
        String str;
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get(Param.COUPON);
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(zzo(obj).intValue());
        }
        obj = map.get(Param.PRICE);
        if (obj != null) {
            product.setPrice(zzn(obj).doubleValue());
        }
        obj = map.get(Param.QUANTITY);
        if (obj != null) {
            product.setQuantity(zzo(obj).intValue());
        }
        for (String valueOf2 : map.keySet()) {
            Matcher matcher = zzbhr.matcher(valueOf2);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(valueOf2)));
                } catch (NumberFormatException e) {
                    str = "illegal number in custom dimension value: ";
                    valueOf2 = String.valueOf(valueOf2);
                    zzhk.zzab(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                }
            } else {
                matcher = zzbhs.matcher(valueOf2);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), zzo(map.get(valueOf2)).intValue());
                    } catch (NumberFormatException e2) {
                        str = "illegal number in custom metric value: ";
                        valueOf2 = String.valueOf(valueOf2);
                        zzhk.zzab(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> zzh(zzqp<?> zzqp) {
        Preconditions.checkNotNull(zzqp);
        Preconditions.checkArgument(zzqp instanceof zzqz);
        Map<String, String> linkedHashMap = new LinkedHashMap();
        Object zzj = zzrd.zzj(zzrd.zzk(zzqp));
        Preconditions.checkState(zzj instanceof Map);
        for (Entry entry : ((Map) zzj).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static Map<String, String> zzi(zzqp<?> zzqp) {
        Map<String, String> zzh = zzh(zzqp);
        String str = (String) zzh.get("&aip");
        if (str != null && zzbng.contains(str.toLowerCase())) {
            zzh.remove("&aip");
        }
        return zzh;
    }

    private static Double zzn(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Double: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            str = "Cannot convert the object to Double: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private static Integer zzo(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Integer: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            str = "Cannot convert the object to Integer: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
