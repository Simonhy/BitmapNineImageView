package com.gf.kjlibary.nineImage.groupimage.layout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

public class DingLayoutManager implements ILayoutManager {
    private Bitmap.Config config = Bitmap.Config.ARGB_8888;

    @Override
    public Bitmap combineBitmap(int size, int subSize, int gap, int gapColor, Bitmap[] bitmaps) {
        Bitmap result = Bitmap.createBitmap(size, size, config);
        Canvas canvas = new Canvas(result);
        if (gapColor == 0) {
            gapColor = Color.WHITE;
        }
        canvas.drawColor(gapColor);

        int count = bitmaps.length;
        Bitmap subBitmap;


        for (int i = 0; i < count; i++) {
            if (bitmaps[i] == null) {
                continue;
            }
            subBitmap = Bitmap.createScaledBitmap(bitmaps[i], size, size, true);
            if (count == 1) {
                canvas.drawBitmap(subBitmap, 0, 0, null);
                break;
            }
            if (count == 2 || (count == 3 && i == 0)) {
                int[][] dxy = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
                subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, 0, (size - gap) / 2, size);
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                Log.d("坐标4", "dx==" + dx + ",dy==" + dy);
                canvas.drawBitmap(subBitmap, dx * (size + gap) / 2.0f, dy * (size + gap) / 2.0f, null);
            } else if ((count == 3 && (i == 1 || i == 2)) || count == 4) {
                int[][] dxy = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
                subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, (size + gap) / 4, (size - gap) / 2, (size - gap) / 2);
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                Log.d("坐标4", "dx==" + dx + ",dy==" + dy);
                canvas.drawBitmap(subBitmap, dx * (size + gap) / 2.0f, dy * (size + gap) / 2.0f, null);
            } else if (count == 5) {
                int[][] dxy = {{0, 0}, {1, 0}, {0, 1}, {1, 1}, {1, 2}};
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                if (i == 0 || i == 2) {
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, (size + gap) / 4, (size - gap) / 2, (size - gap) / 2);
                    Log.d("坐标5--0", "dx==" + dx + ",dy==" + dy);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 2.0f, dy * (size + gap) / 2.0f, null);
                } else {
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, (size + gap) / 4, (size - gap) / 2, (size - gap) / 3);
                    Log.d("坐标5---1", "dx==" + dx + ",dy==" + dy);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 2.0f, dy * (size + gap) / 3.0f, null);
                }
            } else if (count == 6) {
                int[][] dxy = {{0, 0}, {1, 0}, {0, 1}, {1, 1}, {0, 2}, {1, 2}};
                subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, (size + gap) / 4, (size - gap) / 2, (size - gap) / 3);
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                Log.d("坐标6", "dx==" + dx + ",dy==" + dy);
                canvas.drawBitmap(subBitmap, dx * (size + gap) / 2.0f, dy * (size + gap) / 3.0f, null);
            } else if (count == 7) {
                int[][] dxy = {{0, 0}, {1, 0}, {2, 0}, {1, 1}, {2, 1}, {1, 2}, {2, 2}};
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                if (i == 0) {
                    Log.d("坐标7----》0", "dx==" + dx + ",dy==" + dy);
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 4, 0, (size - gap) / 3, size);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 3.0f, dy * (size + gap) / 3.0f, null);
                } else {
                    Log.d("坐标7---》1", "dx==" + dx + ",dy==" + dy);
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 9, (size + gap) / 9, (size - gap) / 3, (size - gap) / 3);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 3.0f, dy * (size + gap) / 3.0f, null);
                }
            } else if (count == 8) {//8张图片
                int[][] dxy = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {1, 2}, {2, 2}};
                int dx = dxy[i][0];
                int dy = dxy[i][1];
                Log.d("坐标8", "dx==" + dx + ",dy==" + dy);
                if (i == 0 || i == 3) {
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 9, (size + gap) / 9, (size - gap) / 3, (size - gap) / 2);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 3.0f, dy * (size + gap) / 2.0f, null);
                } else {
                    subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 9, (size + gap) / 9, (size - gap) / 3, (size - gap) / 3);
                    canvas.drawBitmap(subBitmap, dx * (size + gap) / 3.0f, dy * (size + gap) / 3.0f, null);
                }
            } else if (count >= 9) {
                int[][] dxy = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2}};
                int dx;
                int dy;
                if (i >= 9) {
                    dx = dxy[8][0];
                    dy = dxy[8][1];
                } else {
                    dx = dxy[i][0];
                    dy = dxy[i][1];
                }
                subBitmap = Bitmap.createBitmap(subBitmap, (size + gap) / 9, (size + gap) / 9, (size - gap) / 3, (size - gap) / 3);
                Log.d("坐标9", "dx==" + dx + ",dy==" + dy);
                canvas.drawBitmap(subBitmap, dx * (size + gap) / 3.0f, dy * (size + gap) / 3.0f, null);
            }
        }
        return result;
    }

    public DingLayoutManager() {
    }

    public DingLayoutManager(Bitmap.Config config) {
        this.config = config;
    }
}
