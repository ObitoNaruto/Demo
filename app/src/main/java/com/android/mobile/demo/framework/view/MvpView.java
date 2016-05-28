package com.android.mobile.demo.framework.view;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public interface MvpView<D>{
    /**
     * ����ҵ�����ݵ�UI
     */
    void showContent();

    /**
     * չʾ�ݴ����UI
     * @param text
     */
    void showError(String text);

    /**
     * ��ҵ��������UI��������
     * @param data
     */
    void setData(D data);

    /**
     * ��������
     */
    void loadData();

}
