package com.islxz.yougou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.islxz.yougou.R;
import com.islxz.yougou.activity.SecondActivity;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class ShoppingCarFragment extends Fragment implements View.OnClickListener {

    private View mInclude;
    private ImageButton mBackBtn;
    private TextView mTitleTV;
    private ImageButton mSearchBtn;
    private Button mDelBtn;

    private CheckBox mAllSelectCB;
    private TextView mAllPrivateTV;
    private Button mButton;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_car, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {
        mInclude = view.findViewById(R.id.fg_sc_include);
        mBackBtn = mInclude.findViewById(R.id.abar_back);
        mBackBtn.setImageResource(R.drawable.back);
        mBackBtn.setOnClickListener(this);
        mTitleTV = mInclude.findViewById(R.id.abar_title);
        mTitleTV.setText("购物车(5)");
        mSearchBtn = mInclude.findViewById(R.id.abar_search);
        mSearchBtn.setImageResource(R.drawable.del);
        mDelBtn = mInclude.findViewById(R.id.abar_cancel);

        mAllSelectCB = view.findViewById(R.id.fg_sc_cb_allselect);
        mAllSelectCB.setOnClickListener(this);
        mAllPrivateTV = view.findViewById(R.id.fg_sc_tv_allprice);
        mButton = view.findViewById(R.id.fg_sc_btn);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.abar_back:
                Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                break;
            case R.id.abar_search:
                Toast.makeText(getActivity(), "删除", Toast.LENGTH_SHORT).show();
                checkView(0, 3);
                break;
            case R.id.abar_cancel:
                Toast.makeText(getActivity(), "取消", Toast.LENGTH_SHORT).show();
                checkView(1, 3);
                break;
            case R.id.fg_sc_cb_allselect:
                Toast.makeText(getActivity(), "全选", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fg_sc_btn:
                getActivity().startActivity(new Intent(getActivity(), SecondActivity.class).putExtra
                        ("confirm", 1));
                break;
        }
    }

    private void checkView(int arg0, int arg1) {
        switch (arg0) {
            case 0:
                mSearchBtn.setVisibility(View.GONE);
                mDelBtn.setVisibility(View.VISIBLE);
                mButton.setText("删除(" + arg1 + ")");
                break;
            case 1:
                mSearchBtn.setVisibility(View.VISIBLE);
                mDelBtn.setVisibility(View.GONE);
                mButton.setText("结算(" + arg1 + ")");
                break;
        }
    }

}
