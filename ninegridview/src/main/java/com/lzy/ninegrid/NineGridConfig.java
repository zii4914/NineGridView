package com.lzy.ninegrid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * Created by zii on 2019/7/8.
 */
public class NineGridConfig {

  private static volatile NineGridConfig sInstance;

  private NineGridConfig() {
    mImageRemoveSize = 16;
  }

  public static NineGridConfig getInstance() {
    if (sInstance == null) {
      synchronized (NineGridConfig.class) {
        if (sInstance == null)
          sInstance = new NineGridConfig();
      }
    }
    return sInstance;
  }

  /** 全局的图片加载器(必须设置,否者不显示图片) **/
  private NineGridConfig.ImageLoader mImageLoader;
  /** 右上角移除按钮的大小单位dp **/
  private int mImageRemoveSize;
  /** 绘制的添加按钮的stroke 背景 **/
  private GradientDrawable mDrawableAddStroke;
  /** 右上角删除按钮的图片资源id **/
  @DrawableRes
  private int mDrawableRemoveRes;
  /** 添加按钮的图片资源 **/
  @DrawableRes
  private int mDrawableAddRes;

  public NineGridConfig setImageLoader(ImageLoader imageLoader) {
    mImageLoader = imageLoader;
    return this;
  }

  public NineGridConfig setImageRemoveSize(int imageRemoveSize) {
    mImageRemoveSize = imageRemoveSize;
    return this;
  }

  public NineGridConfig setDrawableAddStroke(GradientDrawable drawableAddStroke) {
    mDrawableAddStroke = drawableAddStroke;
    return this;
  }

  public NineGridConfig setDrawableRemoveRes(int drawableRemoveRes) {
    mDrawableRemoveRes = drawableRemoveRes;
    return this;
  }

  public interface ImageLoader {

    /**
     * 需要子类实现该方法，以确定如何加载和显示图片
     *
     * @param context 上下文
     * @param imageView 需要展示图片的ImageView
     * @param url 图片地址
     */
    void onDisplayImage(Context context, ImageView imageView, String url);

    /**
     * @param url 图片的地址
     * @return 当前框架的本地缓存图片
     */
    Bitmap getCacheImage(String url);

  }

}
