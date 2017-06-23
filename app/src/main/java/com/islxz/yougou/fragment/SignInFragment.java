package com.islxz.yougou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.islxz.yougou.R;
import com.islxz.yougou.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class SignInFragment extends Fragment implements View.OnClickListener {

    private TextView mSignInTV;
    private TextView mSignOnTV;
    private ViewPager mViewPager;

    private PagerAdapter mPagerAdapter;
    private List<View> mViewList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, null);
        bindID(view);
        initView(inflater);
        return view;
    }

    private void initView(LayoutInflater inflater) {
        mViewList = new ArrayList<>();
        mViewList.add(inflater.inflate(R.layout.item_sign_in, null));
        mViewList.add(inflater.inflate(R.layout.item_sign_in, null));
        mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return mViewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Button button = (Button) mViewList.get(position).findViewById(R.id.it_sign_in_btn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                        getActivity().finish();
                    }
                });
                container.addView(mViewList.get(position));
                return mViewList.get(position);
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void bindID(View view) {
        mSignInTV = view.findViewById(R.id.fg_sign_in_tv1);
        mSignInTV.setOnClickListener(this);
        mSignOnTV = view.findViewById(R.id.fg_sign_in_tv2);
        mSignOnTV.setOnClickListener(this);
        mViewPager = view.findViewById(R.id.fg_sign_in_vp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_sign_in_tv1:
                break;
            case R.id.fg_sign_in_tv2:
                break;
        }
    }

    private void checkView(int arg0) {
        switch (arg0) {
            case 1:
                mViewPager.setCurrentItem(0);
                break;
            case 2:
                mViewPager.setCurrentItem(1);
                break;
        }
    }
}
