package com.google.zxing;

import java.util.Map;

public interface Reader {
    Result decode(BinaryBitmap binaryBitmap);

    Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map);

    void reset();
}
