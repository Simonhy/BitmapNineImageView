## libary
  微信和钉钉的九宫格，后期增加QQ的讨论组组合头像 
  修改 https://github.com/SheHuan/CombineBitmap
## 当前最新版本（版本号添加 V）V1.2
   新增微信的构造方法，传递参数，兼容前版本
 
 ## 第一种  钉钉

     CombineBitmap.init(this)
                .setLayoutManager(new DingLayoutManager()) // 必选， 设置图片的组合形式，支持WechatLayoutManager、DingLayoutManager
                .setSize(80) // 必选，组合后Bitmap的尺寸，单位dp
                .setGap(1)
                .setPlaceholder(R.mipmap.ic_launcher) // 单个Bitmap加载失败的默认显示图片
                .setUrls(urls) // 要加载的图片url数组
                .setImageView(imageView)
                .build();


##  第二种 设置图片质量
    CombineBitmap.init(this)
                .setLayoutManager(new DingLayoutManager(Bitmap.Config.RGB_565)) // 必选， 设置图片的组合形式，支持WechatLayoutManager、DingLayoutManager
                .setSize(80) // 必选，组合后Bitmap的尺寸，单位dp
                .setGap(1)
                .setPlaceholder(R.mipmap.ic_launcher) // 单个Bitmap加载失败的默认显示图片
                .setUrlList(list) // 要加载的图片url数组
                .setImageView(imageView)
                .build();
## 第三种  微信九宫格
    CombineBitmap.init(this)
                .setLayoutManager(new WechatLayoutManager()) // 必选， 设置图片的组合形式，支持WechatLayoutManager、DingLayoutManager
                .setSize(80) // 必选，组合后Bitmap的尺寸，单位dp
                .setGap(1)
                .setPlaceholder(R.mipmap.ic_launcher) // 单个Bitmap加载失败的默认显示图片
                .setUrlList(list) // 要加载的图片url数组
                .setImageView(imageView)
                .build();

## 注意：
   要使用钉钉的圆形背景，必须引入一个圆形的图片，我这使用的是 
  compile 'liji.library.dev:circleimageview:0.1.0' 
## 引入方式:
 Step 1
 Add it in your root build.gradle at the end of repositories:
## 
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 Step 2. Add the dependency
## 
	dependencies {
	        implementation 'com.github.Simonhy:libary:1.1'
	}

# 使用方式可查看 
  [wiki一](https://github.com/Simonhy/libary/wiki/%E4%BF%AE%E6%94%B9https:--github.com-SheHuan-CombineBitmaps)  
  [wiki二](https://github.com/Simonhy/libary/wiki/%E5%85%B7%E4%BD%93%E4%BD%BF%E7%94%A8%E6%96%B9%E5%BC%8F)
# 感谢
  https://github.com/SheHuan/CombineBitmap
