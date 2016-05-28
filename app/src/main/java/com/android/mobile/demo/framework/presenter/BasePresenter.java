package com.android.mobile.demo.framework.presenter;

import com.android.mobile.demo.framework.view.MvpView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public abstract class BasePresenter<V extends MvpView> {

    protected Reference<V> mViewRef;

    public void attachView(V view){
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView(){
        return mViewRef.get();
    }

    public boolean isViewAttached(){
        return null != mViewRef && null != mViewRef.get();
    }

    public void detachView(){
        if(null != mViewRef){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
