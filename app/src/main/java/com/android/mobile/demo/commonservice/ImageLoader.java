package com.android.mobile.demo.commonservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.android.mobile.demo.commonservice.cache.ImageCache;
import com.android.mobile.demo.commonservice.cache.MemoryCacheImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 加载图片工具
 * Created by xinming.xxm on 2016/5/27.
 */
public class ImageLoader {
    private static final String TAG = ImageLoader.class.getSimpleName();
    //图片缓存
    private ImageCache mImageCache = new MemoryCacheImpl();
    //线程次，线程数量为CPU的数量
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 扩展接口：注入缓存实现
     * @param cache
     */
    public void setImageCache(ImageCache cache){
        mImageCache = cache;
    }

    /**
     * 渲染图片
     * @param url
     * @param iv
     */
    public void displayImage(String url, ImageView iv){
        Bitmap bitmap = mImageCache.get(url);
        if(null != bitmap){
            iv.setImageBitmap(bitmap);
            return;
        }
        //图片没有缓存，去网络下载图片
        loadImageRequest(url, iv);
    }

    /**
     * 网络下载图片
     * @param url
     * @param iv
     */
    private void loadImageRequest(final String url, final ImageView iv){
        iv.setTag(url);
        Future<String> result =  mExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final Bitmap bitmap = downLoadImage(url);
                if (null == bitmap) {
                    return "downLoadImage fail";
                }
                mImageCache.put(url, bitmap);
                if (TextUtils.equals(iv.getTag().toString(), url)) {
                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitmap);
                        }
                    });
                }
                return "downLoadImage success";
            }
        });
        try {
            Log.d(TAG, result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载
     * @param ImageUrl
     * @return
     */
    private Bitmap downLoadImage(String ImageUrl){
        Bitmap bitmap = null;
        try {
            URL url = new URL(ImageUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
