package com.gf.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.gf.kjlibary.nineImage.groupimage.CombineBitmap;
import com.gf.kjlibary.nineImage.groupimage.layout.DingLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     * https://demo.chuntaoyisheng.com:10002/user/api/v2/public/download?downType=Head&secId=ZWIyM2U3MGNiNGJkZWZkYWY4MzQyYTJmZjVmZWMzYmU=&userId=f2450f297b7b11e8859b000c29bf158c&layer=00&deType=HD
     * 08-31 10:43:31.604 28954-29239/com.phone.gfyl.gfylphone E/BitmapLoader: load from disk:https://demo.chuntaoyisheng.com:10002/user/api/v2/public/download?downType=Head&secId=ZWIyM2U3MGNiNGJkZWZkYWY4MzQyYTJmZjVmZWMzYmU=&userId=749c4fbb7da811e8859b000c29bf158c&layer=00&deType=HD
     * 08-31 10:43:31.606 28954-29238/com.phone.gfyl.gfylphone E/BitmapLoader: load from memory:https://demo.chuntaoyisheng.com:10002/user/api/v2/public/download?downType=Head&secId=ZWIyM2U3MGNiNGJkZWZkYWY4MzQyYTJmZjVmZWMzYmU=&userId=f2450f297b7b11e8859b000c29bf158c&layer=00&deType=HD
     * 08-31 10:43:31.609 28954-29241/com.phone.gfyl.gfylphone E/BitmapLoader: load from disk:https://demo.chuntaoyisheng.com:10002/user/api/v2/public/download?downType=Head&secId=ZWIyM2U3MGNiNGJkZWZkYWY4MzQyYTJmZjVmZWMzYmU=&userId=ae1fa0257b7c11e8859b000c29bf158c&layer=00&deType=HD
     * 08-31 10:43:31.609 28954-29240/com.phone.gfyl.gfylphone E/BitmapLoader: load from disk:https://demo.chuntaoyisheng.com:10002/user/api/v2/public/download?downType=Head&secId=ZWIyM2U3MGNiNGJkZWZkYWY4MzQyYTJmZjVmZWMzYmU=&userId=fa6d799e7e9511e8859b000c29bf158c&layer=00&deType=HD
     */
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11;
    String[] URL_IMAGES = new String[]{
            "http://img.hb.aicdn.com/eca438704a81dd1fa83347cb8ec1a49ec16d2802c846-laesx2_fw658",
            "http://img.hb.aicdn.com/729970b85e6f56b0d029dcc30be04b484e6cf82d18df2-XwtPUZ_fw658",
            "http://img.hb.aicdn.com/85579fa12b182a3abee62bd3fceae0047767857fe6d4-99Wtzp_fw658",
            "http://img.hb.aicdn.com/2814e43d98ed41e8b3393b0ff8f08f98398d1f6e28a9b-xfGDIC_fw658",
            "http://img.hb.aicdn.com/a1f189d4a420ef1927317ebfacc2ae055ff9f212148fb-iEyFWS_fw658",
            "http://img.hb.aicdn.com/69b52afdca0ae780ee44c6f14a371eee68ece4ec8a8ce-4vaO0k_fw658",
            "http://img.hb.aicdn.com/9925b5f679964d769c91ad407e46a4ae9d47be8155e9a-seH7yY_fw658",
            "http://img.hb.aicdn.com/e22ee5730f152c236c69e2242b9d9114852be2bd8629-EKEnFD_fw658",
            "http://img.hb.aicdn.com/73f2fbeb01cd3fcb2b4dccbbb7973aa1a82c420b21079-5yj6fx_fw658",
            "http://img.hb.aicdn.com/73f2fbeb01cd3fcb2b4dccbbb7973aa1a82c420b21079-5yj6fx_fw658",
            "http://img.hb.aicdn.com/73f2fbeb01cd3fcb2b4dccbbb7973aa1a82c420b21079-5yj6fx_fw658"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1 = (ImageView) findViewById(R.id.image1);
        i2 = (ImageView) findViewById(R.id.image2);
        i3 = (ImageView) findViewById(R.id.image3);
        i4 = (ImageView) findViewById(R.id.image4);
        i5 = (ImageView) findViewById(R.id.image5);
        i6 = (ImageView) findViewById(R.id.image6);
        i7 = (ImageView) findViewById(R.id.image7);
        i8 = (ImageView) findViewById(R.id.image8);
        i9 = (ImageView) findViewById(R.id.image9);
        i10 = (ImageView) findViewById(R.id.image10);
        i11 = (ImageView) findViewById(R.id.image11);

        List<String> list = new ArrayList<>();
        for (String url_image : URL_IMAGES) {
            list.add(url_image);
        }

        loadPic(i1, getUrls(1));
        loadPic(i2, getUrls(2));
        loadPic(i3, getUrls(3));
        loadPic(i4, getUrls(4));//4及以下
        loadPic(i5, getUrls(5));
        loadPic(i6, getUrls(6));
        loadPic(i7, getUrls(7));
        loadPic(i8, getUrls(8));
        loadPic(i9, getUrls(9));//9及以上
        loadPic(i10, getUrls(10));//

        loadPicList(i11, list);


    }

    private String[] getUrls(int count) {
        String[] urls = new String[count];
        System.arraycopy(URL_IMAGES, 0, urls, 0, count);
        return urls;
    }

    public void loadPic(ImageView imageView, String[] urls) {
        CombineBitmap.init(this)
                .setLayoutManager(new DingLayoutManager()) // 必选， 设置图片的组合形式，支持WechatLayoutManager、DingLayoutManager
                .setSize(80) // 必选，组合后Bitmap的尺寸，单位dp
                .setGap(1)
                .setPlaceholder(R.mipmap.ic_launcher) // 单个Bitmap加载失败的默认显示图片
                .setUrls(urls) // 要加载的图片url数组
                .setImageView(imageView)
                .build();
    }

    public void loadPicList(ImageView imageView, List<String> list) {
        CombineBitmap.init(this)
                .setLayoutManager(new DingLayoutManager(Bitmap.Config.RGB_565)) // 必选， 设置图片的组合形式，支持WechatLayoutManager、DingLayoutManager
                .setSize(80) // 必选，组合后Bitmap的尺寸，单位dp
                .setGap(1)
                .setPlaceholder(R.mipmap.ic_launcher) // 单个Bitmap加载失败的默认显示图片
                .setUrlList(list) // 要加载的图片url数组
                .setImageView(imageView)
                .build();
    }
}
