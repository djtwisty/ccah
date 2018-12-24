package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

public final class AztecReader implements Reader {
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) {
        AztecDetectorResult detect;
        DecoderResult decode;
        ResultPoint[] resultPointArr;
        FormatException formatException;
        NotFoundException notFoundException;
        NotFoundException e;
        DecoderResult decoderResult;
        FormatException e2;
        ResultPointCallback resultPointCallback;
        Result result;
        List byteSegments;
        String eCLevel;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        ResultPoint[] points;
        try {
            detect = detector.detect(false);
            points = detect.getPoints();
            try {
                decode = new Decoder().decode(detect);
                resultPointArr = points;
                formatException = null;
                notFoundException = null;
            } catch (NotFoundException e3) {
                e = e3;
                decode = null;
                resultPointArr = points;
                formatException = null;
                notFoundException = e;
                if (decode == null) {
                    decoderResult = decode;
                } else {
                    try {
                        detect = detector.detect(true);
                        resultPointArr = detect.getPoints();
                        decoderResult = new Decoder().decode(detect);
                    } catch (NotFoundException e4) {
                        e2 = e4;
                        if (notFoundException != null) {
                            throw notFoundException;
                        } else if (formatException == null) {
                            throw formatException;
                        } else {
                            throw e2;
                        }
                    } catch (FormatException e5) {
                        e2 = e5;
                        if (notFoundException != null) {
                            throw notFoundException;
                        } else if (formatException == null) {
                            throw e2;
                        } else {
                            throw formatException;
                        }
                    }
                }
                if (map != null) {
                    resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    if (resultPointCallback != null) {
                        for (ResultPoint foundPossibleResultPoint : resultPointArr) {
                            resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                        }
                    }
                }
                result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                return result;
            } catch (FormatException e6) {
                e2 = e6;
                decode = null;
                resultPointArr = points;
                formatException = e2;
                notFoundException = null;
                if (decode == null) {
                    detect = detector.detect(true);
                    resultPointArr = detect.getPoints();
                    decoderResult = new Decoder().decode(detect);
                } else {
                    decoderResult = decode;
                }
                if (map != null) {
                    resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    if (resultPointCallback != null) {
                        while (r1 < r2) {
                            resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                        }
                    }
                }
                result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                return result;
            }
        } catch (NotFoundException e7) {
            e = e7;
            points = null;
            decode = null;
            resultPointArr = points;
            formatException = null;
            notFoundException = e;
            if (decode == null) {
                decoderResult = decode;
            } else {
                detect = detector.detect(true);
                resultPointArr = detect.getPoints();
                decoderResult = new Decoder().decode(detect);
            }
            if (map != null) {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    while (r1 < r2) {
                        resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                    }
                }
            }
            result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result;
        } catch (FormatException e8) {
            e2 = e8;
            points = null;
            decode = null;
            resultPointArr = points;
            formatException = e2;
            notFoundException = null;
            if (decode == null) {
                detect = detector.detect(true);
                resultPointArr = detect.getPoints();
                decoderResult = new Decoder().decode(detect);
            } else {
                decoderResult = decode;
            }
            if (map != null) {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    while (r1 < r2) {
                        resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                    }
                }
            }
            result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result;
        }
        if (decode == null) {
            detect = detector.detect(true);
            resultPointArr = detect.getPoints();
            decoderResult = new Decoder().decode(detect);
        } else {
            decoderResult = decode;
        }
        if (map != null) {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                while (r1 < r2) {
                    resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                }
            }
        }
        result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), decoderResult.getNumBits(), resultPointArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }

    public void reset() {
    }
}
