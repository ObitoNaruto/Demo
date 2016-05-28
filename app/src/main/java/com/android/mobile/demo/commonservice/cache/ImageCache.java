package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;

/**
 * ͼƬ����ӿ�
 * Created by xinming.xxm on 2016/5/27.
 */
public interface ImageCache {
    /**
     * ��ȡͼƬ����
     * @param url
     * @return
     */
    Bitmap get(String url);

    /**
     * ����ͼƬ
     * @param url
     * @param bitmap
     */
    void put(String url, Bitmap bitmap);
}
