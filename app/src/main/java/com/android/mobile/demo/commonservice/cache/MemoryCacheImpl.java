package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * �ڴ滺��ʵ����
 * Created by xinming.xxm on 2016/5/27.
 */
public class MemoryCacheImpl implements ImageCache{
    //ͼƬLRU����
    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCacheImpl(){
        initCache();
    }

    /**
     * /��ʼ��LRU����
     */
    private void initCache(){
        //��ȡ����ڴ�
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory() / 1024);
        //һ��ȡ�ķ�֮һ�Ŀ����ڴ���Ϊ����
        final int cacheSize = maxMemory / 4;
        mMemeryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    /**
     * ���ڴ滺���л�ȡͼƬ
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        return (null != mMemeryCache) ? mMemeryCache.get(url) : null;
    }

    /**
     * ���ڴ滺���л���ͼƬ
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
