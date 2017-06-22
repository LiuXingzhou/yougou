package com.islxz.yougou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.islxz.yougou.R;
import com.islxz.yougou.activity.SecondActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Qingsu on 2017/6/20.
 */

public class HomeFragment extends Fragment implements View.OnClickListener, NavigationView
        .OnNavigationItemSelectedListener {

    private View mBarInclude;
    private ImageButton mBackIB;
    private TextView mTitleTV;
    private ImageButton mSearchIB;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout1;
    private LinearLayout mLinearLayout2;
    private LinearLayout mLinearLayout3;
    private View mShoppingCarInclude;
    private FloatingActionButton mShoppingCar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private View mHeaderView;
    private CircleImageView mAvertImg;
    private TextView mAvertTV1;
    private TextView mAvertTV2;
    private LinearLayout mDaiFKLL;
    private LinearLayout mDaiSHLL;
    private LinearLayout mQuanBDDLL;
    private LinearLayout mLinearLayout4;
    private LinearLayout mLinearLayout5;

    private int[] mInts = new int[]{R.color.main_color, R.color.title_class_1, R.color
            .title_class_2};
    private List<View> mViewList;
    private PagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        bindID(view);
        initialViewPager(inflater);
        return view;
    }

    private void initialViewPager(LayoutInflater inflater) {
        mViewList = new ArrayList<>();
        for (int i = 0; i < mInts.length; i++) {
            View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
            view.setBackgroundResource(mInts[i]);
            mViewList.add(view);
        }
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
                container.addView(mViewList.get(position));
                return mViewList.get(position);
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
    }

    private void bindID(View view) {
        mBarInclude = view.findViewById(R.id.fg_home_include1);
        mBackIB = mBarInclude.findViewById(R.id.abar_back);
        mBackIB.setOnClickListener(this);
        mTitleTV = mBarInclude.findViewById(R.id.abar_title);
        mSearchIB = mBarInclude.findViewById(R.id.abar_search);
        mSearchIB.setOnClickListener(this);

        mViewPager = view.findViewById(R.id.fg_home_vp);
        mLinearLayout1 = view.findViewById(R.id.fg_home_ll1);
        mLinearLayout1.setOnClickListener(this);
        mLinearLayout2 = view.findViewById(R.id.fg_home_ll2);
        mLinearLayout2.setOnClickListener(this);
        mLinearLayout3 = view.findViewById(R.id.fg_home_ll3);
        mLinearLayout3.setOnClickListener(this);

        mShoppingCarInclude = view.findViewById(R.id.fg_home_include2);
        mShoppingCar = mShoppingCarInclude.findViewById(R.id.float_btn);
        mShoppingCar.setOnClickListener(this);

        mDrawerLayout = view.findViewById(R.id.fg_home_dl);
        mNavigationView = view.findViewById(R.id.fg_home_nav);
        mNavigationView.setNavigationItemSelectedListener(this);
        mHeaderView = mNavigationView.getHeaderView(0);
        mAvertImg = mHeaderView.findViewById(R.id.nav_avert_img);
        mAvertImg.setOnClickListener(this);
        mAvertTV1 = mHeaderView.findViewById(R.id.nav_avert_tv1);
        mAvertTV2 = mHeaderView.findViewById(R.id.nav_avert_tv2);
        mDaiFKLL = mHeaderView.findViewById(R.id.nav_dai_f_k);
        mDaiFKLL.setOnClickListener(this);
        mDaiSHLL = mHeaderView.findViewById(R.id.nav_dai_s_h);
        mDaiSHLL.setOnClickListener(this);
        mQuanBDDLL = mHeaderView.findViewById(R.id.nav_quan_b_d_d);
        mQuanBDDLL.setOnClickListener(this);
        mLinearLayout4 = mHeaderView.findViewById(R.id.nav_ll1);
        mLinearLayout4.setOnClickListener(this);
        mLinearLayout5 = mHeaderView.findViewById(R.id.nav_ll2);
        mLinearLayout5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        switch (view.getId()) {
            case R.id.abar_back://菜单
                mDrawerLayout.openDrawer(Gravity.START);
                return;
            case R.id.abar_search://搜索
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
                return;
            case R.id.fg_home_ll1://女装
                intent.putExtra("goods", 1);
                break;
            case R.id.fg_home_ll2://男装
                intent.putExtra("goods", 2);
                break;
            case R.id.fg_home_ll3://童装
                intent.putExtra("goods", 3);
                break;
            case R.id.float_btn://购物车
                Toast.makeText(getActivity(), "购物车", Toast.LENGTH_SHORT).show();
                return;
            case R.id.nav_avert_img://个人信息
                intent.putExtra("avert", 1);
                break;
            case R.id.nav_dai_f_k://待付款
                intent.putExtra("avert", 2);
                break;
            case R.id.nav_dai_s_h://待收货
                intent.putExtra("avert", 3);
                break;
            case R.id.nav_quan_b_d_d://全部订单
                intent.putExtra("avert", 4);
                break;
            case R.id.nav_ll1://快递1
                Toast.makeText(getActivity(), "快递1", Toast.LENGTH_SHORT).show();
                return;
            case R.id.nav_ll2://快递2
                Toast.makeText(getActivity(), "快递2", Toast.LENGTH_SHORT).show();
                return;
        }
        mDrawerLayout.closeDrawer(Gravity.START);
        getActivity().startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(getActivity(), SecondActivity.class);
        switch (item.getItemId()) {
            case R.id.nav_menu_home_collection://我的收藏
                intent.putExtra("item", 1);
                break;
            case R.id.nav_menu_home_news://我的消息
                intent.putExtra("item", 2);
                break;
            case R.id.nav_menu_home_coupon://我的优惠券
                intent.putExtra("item", 3);
                break;
            case R.id.nav_menu_home_refund://退款/售后
                intent.putExtra("item", 4);
                break;
            case R.id.nav_menu_home_address://收货地址
                intent.putExtra("item", 5);
                break;
            case R.id.nav_menu_home_setting://设置
                intent.putExtra("item", 6);
                break;
            case R.id.nav_menu_home_exit://退出登录
                getActivity().finish();
                return true;
        }
        mDrawerLayout.closeDrawer(Gravity.START);
        getActivity().startActivity(intent);
        return true;
    }
}
