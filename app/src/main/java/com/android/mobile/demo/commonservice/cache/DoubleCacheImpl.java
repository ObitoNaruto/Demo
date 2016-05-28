package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public class DoubleCacheImpl implements ImageCache{

    private ImageCache mMemoryCache = new MemoryCacheImpl();
    private ImageCache mDiskCache = new DiskCacheImpl();

    /**
     * 优先从内存缓存中获取图片，获取不到，再到磁盘缓存中获取图片
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if(null == bitmap){
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    /**
     * 将图片缓存到内存和磁盘缓存中
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
