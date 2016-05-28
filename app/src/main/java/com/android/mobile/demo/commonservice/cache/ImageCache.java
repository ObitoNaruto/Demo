package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;

/**
 * Í¼Æ¬»º´æ½Ó¿Ú
 * Created by xinming.xxm on 2016/5/27.
 */
public interface ImageCache {
    /**
     * »ñÈ¡Í¼Æ¬»º´æ
     * @param url
     * @return
     */
    Bitmap get(String url);

    /**
     * »º´æÍ¼Æ¬
     * @param url
     * @param bitmap
     */
    void put(String url, Bitmap bitmap);
}
