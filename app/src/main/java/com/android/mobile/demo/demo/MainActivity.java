package com.android.mobile.demo.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.mobile.demo.R;
import com.android.mobile.demo.demo.adapter.MainPageAdapter;
import com.android.mobile.demo.demo.model.Data;
import com.android.mobile.demo.demo.presenter.MainPresenter;
import com.android.mobile.demo.demo.viewinterface.MainViewInterface;
import com.android.mobile.demo.framework.activity.MvpBaseActivity;

import java.util.List;


public class MainActivity extends MvpBaseActivity<MainViewInterface, MainPresenter> implements MainViewInterface {

    private TextView mErrorView;
    private RecyclerView mRecyclerView;
    private MainPageAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    /**
     * ³õÊ¼»¯¿Ø¼þ
     */
    private void initView(){
        mErrorView = (TextView)findViewById(R.id.errorView);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new MainPageAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setData(List<Data> data) {
        mAdapter.setDatas(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData() {
        mPresenter.loadMainPageData();
    }

    @Override
    public void showContent() {
        mErrorView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String text) {
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(text);
        mRecyclerView.setVisibility(View.GONE);
    }
}
