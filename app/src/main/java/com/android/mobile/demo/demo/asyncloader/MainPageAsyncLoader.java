package com.android.mobile.demo.demo.asyncloader;

import android.os.AsyncTask;

import com.android.mobile.demo.demo.model.Data;
import com.android.mobile.demo.demo.model.MockApi;

import java.util.Collections;
import java.util.List;

/**
 * 业务定制的asynctask
 * Created by xinming.xxm on 2016/5/27.
 */
public class MainPageAsyncLoader extends AsyncTask<Void, Void, List<Data>>{

    public interface MainPageLoaderListener{
        void onSuccess(List<Data> datas);
        void onFail(String text);
    }

    private MainPageLoaderListener mListener;

    public MainPageAsyncLoader(MainPageLoaderListener listener) {
        super();
        this.mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Data> doInBackground(Void... params) {
        List<Data> datas = MockApi.getDatas();
        Collections.shuffle(datas);
        return datas;
    }

    @Override
    protected void onPostExecute(List<Data> datas) {
        if(isCancelled()){
            return;
        }

        if(null == datas){
            mListener.onFail("获取数据失败");
        }
        else{
            mListener.onSuccess(datas);
        }

    }

}
