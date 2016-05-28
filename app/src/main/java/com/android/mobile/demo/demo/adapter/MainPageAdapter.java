package com.android.mobile.demo.demo.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.mobile.demo.R;
import com.android.mobile.demo.commonservice.ImageLoader;
import com.android.mobile.demo.commonservice.cache.DiskCacheImpl;
import com.android.mobile.demo.demo.model.Data;

import java.util.List;

/**
 * Created by xinming.xxm on 2016/5/27.
 */
public class MainPageAdapter extends RecyclerView.Adapter<MainPageAdapter.MainPageViewHolder>{

    private Context mContext;
    private List<Data> mDatas;
    private ImageLoader mImageLoader;

    public MainPageAdapter(Context context) {
        this.mContext = context;
        this.mImageLoader = new ImageLoader();
    }

    public void setDatas(List<Data> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public MainPageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MainPageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.view_main_page_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final MainPageViewHolder holder, int i) {
        if(null != mDatas){
            Data data = mDatas.get(i);
            if(null != data){
                String topText = data.top;
                String middleText = data.middle;
                final String imageUrl = data.ImageUrl;

                if(!TextUtils.isEmpty(topText)){
                    holder.tvTop.setText(topText);
                }

                if(!TextUtils.isEmpty(middleText)){
                    holder.tvMiddle.setText(middleText);
                }

                //fix itemview复用时图片显示错误的问题
                if(!TextUtils.equals(imageUrl, (null == holder.iv.getTag()) ? "" : holder.iv.getTag().toString())){
                    holder.iv.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.default_image));
                }

                holder.tvDownLoad.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!TextUtils.isEmpty(imageUrl)){
                            //可配置缓存类型，支持内存缓存，磁盘缓存以及内存磁盘双缓存，这里使用SD卡缓存,
                            mImageLoader.setImageCache(new DiskCacheImpl());
                            //使用图片渲染工具为ImageView渲染图片
                            mImageLoader.displayImage(imageUrl, holder.iv);
                        }
                    }
                });
            }

        }
    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    protected class MainPageViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tvTop, tvMiddle, tvDownLoad;
        public MainPageViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv_scenery);
            tvTop = (TextView)itemView.findViewById(R.id.tv_top);
            tvMiddle = (TextView)itemView.findViewById(R.id.tv_middle);
            tvDownLoad = (TextView)itemView.findViewById(R.id.btn_download);
        }
    }
}
