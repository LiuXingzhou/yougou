package com.islxz.yougou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.islxz.yougou.R;
import com.islxz.yougou.entity.ExpressInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qingsu on 2017/6/21.
 */

public class ExpressFragment extends Fragment {

    private ImageView mGoodsImg;
    private TextView mOrderId;
    private TextView mExpressName;
    private ListView mListView;

    private BaseAdapter mBaseAdapter;
    private List<ExpressInfo> mExpressInfoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_express, null);
        bindID(view);
        initData();
        mBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mExpressInfoList.get(0).getExpressInfo().size();
            }

            @Override
            public Object getItem(int i) {
                return mExpressInfoList.get(0);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_express_info, null);
                ImageView img = v.findViewById(R.id.itexi_iv);
                TextView info = v.findViewById(R.id.itexi_tv_info);
                TextView date = v.findViewById(R.id.itexi_tv_date);
                if (i == 0) {
                    img.setImageResource(R.drawable.circular_select);
                }
                info.setText(mExpressInfoList.get(0).getExpressInfo().get(i));
                date.setText(mExpressInfoList.get(0).getDateInfo().get(i));
                return v;
            }
        };
        mListView.setAdapter(mBaseAdapter);
        return view;
    }

    private void initData() {
        mExpressInfoList = new ArrayList<>();

        ExpressInfo expressInfo = new ExpressInfo();
        expressInfo.setStatus("运输中");
        expressInfo.setOrderId("1556641313");
        expressInfo.setExpressName("顺丰快递");
        List<String> temp1 = new ArrayList<>();
        temp1.add("[深圳]派件员电话：13025464654");
        temp1.add("第二条快递信息第二条快递信息第二条快递信息第二条快递信息第二条快递信息");
        temp1.add("第三条快递信息");
        temp1.add("第四条快递信息");
        temp1.add("快递收件");
        List<String> temp2 = new ArrayList<>();
        temp2.add("2017-04-22 22:54");
        temp2.add("2017-04-22 10:54");
        temp2.add("2017-04-21 22:00");
        temp2.add("2017-04-21 20:04");
        temp2.add("2017-04-21 16:00");
        expressInfo.setExpressInfo(temp1);
        expressInfo.setDateInfo(temp2);

        mExpressInfoList.add(expressInfo);
    }

    private void bindID(View view) {
        mGoodsImg = view.findViewById(R.id.fg_express_img);
        mOrderId = view.findViewById(R.id.fg_express_tv_num);
        mExpressName = view.findViewById(R.id.fg_express_tv_name);
        mListView = view.findViewById(R.id.fg_express_lv);
    }
}
