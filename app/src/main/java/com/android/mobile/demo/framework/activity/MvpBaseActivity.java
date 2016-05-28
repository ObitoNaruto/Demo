package com.android.mobile.demo.framework.activity;

import android.app.Activity;
import android.os.Bundle;

import com.android.mobile.demo.framework.presenter.BasePresenter;
import com.android.mobile.demo.framework.view.MvpView;

/**
 * ���׵�MVP�ܹ�activity����
 * ʵ�ֹ��ܣ����Ŵ���presenter����ӿڣ�
 * ʵ��presenter���󴴽��߼���
 * ʵ��view��presenter�ĸ��źͷ�����
 * Created by xinming.xxm on 2016/5/27.
 */
public abstract class MvpBaseActivity<V extends MvpView, P extends BasePresenter<V>>
        extends Activity{
    //presenter����
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        //View ��Presenter��������
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * ����Presenter����
     * @return
     */
    protected abstract P createPresenter();
}
