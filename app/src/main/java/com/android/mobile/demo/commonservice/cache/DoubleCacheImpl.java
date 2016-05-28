package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public class DoubleCacheImpl implements ImageCache{

    private ImageCache mMemoryCache = new MemoryCacheImpl();
    private ImageCache mDiskCache = new DiskCacheImpl();

    /**
     * ���ȴ��ڴ滺���л�ȡͼƬ����ȡ�������ٵ����̻����л�ȡͼƬ
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
     * ��ͼƬ���浽�ڴ�ʹ��̻�����
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
