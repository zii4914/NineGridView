package com.zii.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.NineGridViewAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zii on 2019/7/8.
 */
public class SampleActivity extends Activity {

  private final ArrayList<String> mUrls = new ArrayList<>();
  private NineGridView mNineGridView;
  private ArrayList<ImageInfo> mImageInfo;

  {
    mUrls.add("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
    mUrls.add("http://10wallpaper.com/wallpaper/1440x900/1206/Maldives_beach_scenery_wallpaper_16_1440x900.jpg");
    mUrls.add("http://img.zcool.cn/community/019b7e5bbe34c9a801213dea292f6e.png@2o.png");
    mUrls.add("http://b-ssl.duitang.com/uploads/item/201802/24/20180224222659_3fFjV.jpeg");
    mUrls.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1307/09/c1/23113144_1373337486835.jpg");
    mUrls.add("http://pic1.win4000.com/wallpaper/e/56e8fb1debdad.jpg");
    mUrls.add(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562589361628&di=554b3cd04f17bf516c0908aeff7fbbcf&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8250fc21a8dbe327ecaa0c8d7db49b6b039a12166e8f0-tEd0As_fw236");
    mUrls.add(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562589361628&di=554b3cd04f17bf516c0908aeff7fbbcf&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8250fc21a8dbe327ecaa0c8d7db49b6b039a12166e8f0-tEd0As_fw236");
    mUrls.add(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562589361628&di=554b3cd04f17bf516c0908aeff7fbbcf&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8250fc21a8dbe327ecaa0c8d7db49b6b039a12166e8f0-tEd0As_fw236");
    mUrls.add("http://pic1.win4000.com/wallpaper/e/58a170314b4d0.jpg?down");
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample);
    mNineGridView = findViewById(R.id.ngv);

    NineGridView.setImageLoader(new NineGridView.ImageLoader() {
      @Override
      public void onDisplayImage(Context context, ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
      }

      @Override
      public Bitmap getCacheImage(String url) {
        return null;
      }
    });

    initImageInfo();

    int spacing = 18;
    int maxSize = 9;

    mNineGridView.setGridSpacing(spacing);
    mNineGridView.setMaxSize(maxSize);

    mNineGridView.setAdapter(new NineGridViewAdapter(this, mImageInfo) {
      @Override
      protected void onImageItemClick(Context context, NineGridView nineGridView, int index,
          List<ImageInfo> imageInfo) {
        super.onImageItemClick(context, nineGridView, index, imageInfo);
        Log.d("zii-", "onImageItemClick: " + index + "   " + imageInfo.get(index));
      }

      @Override
      protected ImageView generateImageView(Context context) {
        return super.generateImageView(context);
      }

      @Override
      public List<ImageInfo> getImageInfo() {
        return super.getImageInfo();
      }
    });
  }

  private void initImageInfo() {
    mImageInfo = new ArrayList<>();
    for (String url : mUrls) {
      ImageInfo info = new ImageInfo();
      info.setThumbnailUrl(url);
      mImageInfo.add(info);
    }
  }

}
