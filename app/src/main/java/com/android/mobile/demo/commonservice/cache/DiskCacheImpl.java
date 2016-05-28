package com.android.mobile.demo.commonservice.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ¥≈≈Ãª∫¥Ê µœ÷¿‡
 * Created by xinming.xxm on 2016/5/27.
 */
public class DiskCacheImpl implements ImageCache{

    //¥≈≈ÃÕº∆¨¥Ê∑≈µÿ÷∑
    static String cacheDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache/";

    /**
     * ¥”¥≈≈Ãª∫¥Ê÷–ªÒ»°Õº∆¨
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        String newUrl = Base64.encodeToString(url.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeFile(cacheDir + newUrl);
    }

    /**
     * œÚ¥≈≈Ãª∫¥Ê÷–ª∫¥ÊÕº∆¨
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            String newUrl = Base64.encodeToString(url.getBytes(), Base64.DEFAULT);
            File file= new File(cacheDir, newUrl);
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(cacheDir + newUrl);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
