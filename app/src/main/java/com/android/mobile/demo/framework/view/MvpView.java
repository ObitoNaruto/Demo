package com.android.mobile.demo.framework.view;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public interface MvpView<D>{
    /**
     * 更新业务数据的UI
     */
    void showContent();

    /**
     * 展示容错界面UI
     * @param text
     */
    void showError(String text);

    /**
     * 将业务数据与UI建立关联
     * @param data
     */
    void setData(D data);

    /**
     * 加载数据
     */
    void loadData();

}
