package com.gf.kjlibary.nineImage.groupimage.helper;

import android.graphics.Bitmap;

public interface OnProgressListener {
    void onStart();

    void onComplete(Bitmap bitmap);
}
