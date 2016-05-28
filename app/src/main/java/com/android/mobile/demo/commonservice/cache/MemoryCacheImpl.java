package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * 内存缓存实现类
 * Created by xinming.xxm on 2016/5/27.
 */
public class MemoryCacheImpl implements ImageCache{
    //图片LRU缓存
    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCacheImpl(){
        initCache();
    }

    /**
     * /初始化LRU缓存
     */
    private void initCache(){
        //获取最大内存
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory() / 1024);
        //一般取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mMemeryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    /**
     * 从内存缓存中获取图片
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        return (null != mMemeryCache) ? mMemeryCache.get(url) : null;
    }

    /**
     * 向内存缓存中缓存图片
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        if(null != mMemeryCache){
            mMemeryCache.put(url, bitmap);
        }
    }
}
