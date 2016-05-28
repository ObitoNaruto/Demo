package com.android.mobile.demo.demo.presenter;

import com.android.mobile.demo.demo.asyncloader.MainPageAsyncLoader;
import com.android.mobile.demo.demo.model.Data;
import com.android.mobile.demo.demo.viewinterface.MainViewInterface;
import com.android.mobile.demo.framework.presenter.BasePresenter;

import java.util.List;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public class MainPresenter extends BasePresenter<MainViewInterface>{

    //asyncTask工具类对象
    private MainPageAsyncLoader mLoader;

    public void loadMainPageData(){
        if(null != mLoader && !mLoader.isCancelled()){
            mLoader.cancel(true);
        }

        mLoader = new MainPageAsyncLoader(new MainPageAsyncLoader.MainPageLoaderListener() {
            @Override
            public void onSuccess(List<Data> datas) {
                if(isViewAttached()){

                    getView().setData(datas);

                    getView().showContent();
                }

            }

            @Override
            public void onFail(String text) {
                if(isViewAttached()){
                    getView().showError(text);
                }
            }
        });
        mLoader.execute();
    }

    @Override
    public void detachView() {
        super.detachView();

        if(null != mLoader){
            mLoader.cancel(true);
        }

    }

    @Override
    public void attachView(MainViewInterface view) {
        super.attachView(view);
    }
}
