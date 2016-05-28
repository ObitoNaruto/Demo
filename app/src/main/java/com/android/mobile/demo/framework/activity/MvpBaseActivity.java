package com.android.mobile.demo.framework.activity;

import android.app.Activity;
import android.os.Bundle;

import com.android.mobile.demo.framework.presenter.BasePresenter;
import com.android.mobile.demo.framework.view.MvpView;

/**
 * 简易的MVP架构activity基类
 * 实现功能：开放创建presenter对象接口，
 * 实现presenter对象创建逻辑，
 * 实现view与presenter的附着和反附着
 * Created by xinming.xxm on 2016/5/27.
 */
public abstract class MvpBaseActivity<V extends MvpView, P extends BasePresenter<V>>
        extends Activity{
    //presenter对象
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        //View 与Presenter建立关联
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * 创建Presenter对象
     * @return
     */
    protected abstract P createPresenter();
}
