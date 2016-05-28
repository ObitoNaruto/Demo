package com.android.mobile.demo.demo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据mock的测试api
 * Created by xinming.xxm on 2016/5/27.
 */
public class MockApi {

    public static List<Data> getDatas(){
        ArrayList<Data> datas = new ArrayList<>(10);

        Data data1 = new Data(
                "森林",
                "树好多，好大",
                "http://img1.imgtn.bdimg.com/it/u=2478363603,784178434&fm=15&gp=0.jpg"
        );
        datas.add(data1);

        Data data2 = new Data(
                "蓝天",
                "蓝天白云，心情很好",
                "http://img3.imgtn.bdimg.com/it/u=2727117026,3010024739&fm=15&gp=0.jpg"
        );
        datas.add(data2);

        Data data3 = new Data(
                "白雪",
                "千里冰封，万里雪飘",
                "http://img3.imgtn.bdimg.com/it/u=4125576094,1173573651&fm=15&gp=0.jpg"
        );
        datas.add(data3);

        Data data4 = new Data(
                "高山",
                "高山仰止",
                "http://img1.imgtn.bdimg.com/it/u=3103385851,654526104&fm=15&gp=0.jpg"
        );
        datas.add(data4);

        Data data5 = new Data(
                "迎客松",
                "青葱常在，屹立天地间",
                "http://img1.imgtn.bdimg.com/it/u=11510008,1813355991&fm=15&gp=0.jpg"
        );
        datas.add(data5);

        Data data6 = new Data(
                "瀑布",
                "气吞山河",
                "http://img0.imgtn.bdimg.com/it/u=2841856083,2769386539&fm=15&gp=0.jpg"
        );
        datas.add(data6);

        Data data7 = new Data(
                "断桥",
                "西湖断桥",
                "http://img2.imgtn.bdimg.com/it/u=2031297182,2119955100&fm=15&gp=0.jpg"
        );
        datas.add(data7);

        Data data8 = new Data(
                "荷花",
                "荷花，荷花，荷花",
                "http://img1.imgtn.bdimg.com/it/u=3384586933,2519592514&fm=15&gp=0.jpg"
        );
        datas.add(data8);

        Data data9 = new Data(
                "大海",
                "白浪滔天",
                "http://img4.imgtn.bdimg.com/it/u=3957206868,3495139442&fm=15&gp=0.jpg"
        );
        datas.add(data9);

        Data data10 = new Data(
                "晚霞",
                "夕阳无限好",
                "http://img0.imgtn.bdimg.com/it/u=3396200938,2856647034&fm=15&gp=0.jpg"
        );
        datas.add(data10);

        Collections.shuffle(datas);

        return datas;
    }
}
