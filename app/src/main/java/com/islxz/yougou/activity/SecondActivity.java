package com.islxz.yougou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.islxz.yougou.R;
import com.islxz.yougou.fragment.AddressFragment;
import com.islxz.yougou.fragment.CollectionFragment;
import com.islxz.yougou.fragment.ConfirmFragment;
import com.islxz.yougou.fragment.CouponFragment;
import com.islxz.yougou.fragment.DaiFukuanFragment;
import com.islxz.yougou.fragment.DaiShouhuoFragment;
import com.islxz.yougou.fragment.ExpressFragment;
import com.islxz.yougou.fragment.GoodsFragment;
import com.islxz.yougou.fragment.GoodsListFragment;
import com.islxz.yougou.fragment.NewsFragment;
import com.islxz.yougou.fragment.PersonalFragment;
import com.islxz.yougou.fragment.QuanBudingdanFragment;
import com.islxz.yougou.fragment.RefundFragment;
import com.islxz.yougou.fragment.SearchFragment;
import com.islxz.yougou.fragment.SettingFragment;
import com.islxz.yougou.fragment.ShoppingCarFragment;

public class SecondActivity extends AppCompatActivity {

    private View mInclude;
    private ImageButton mBackIB;
    private TextView mTitleTV;
    private ImageButton mSearchIB;
    private FrameLayout mFrameLayout;

    private ShoppingCarFragment mShoppingCarFragment;
    private ConfirmFragment mConfirmFragment;
    private SearchFragment mSearchFragment;

    private PersonalFragment mPersonalFragment;
    private DaiFukuanFragment mDaiFukuanFragment;
    private DaiShouhuoFragment mDaiShouhuoFragment;
    private QuanBudingdanFragment mQuanBudingdanFragment;
    private ExpressFragment mExpressFragment;
    private CollectionFragment mCollectionFragment;
    private NewsFragment mNewsFragment;
    private CouponFragment mCouponFragment;
    private RefundFragment mRefundFragment;
    private AddressFragment mAddressFragment;
    private SettingFragment mSettingFragment;
    private GoodsListFragment mGoodsListFragment;
    private GoodsFragment mGoodsFragment;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private int avert;
    private int express;
    private int item;
    private int shoppingcar;
    private int confirm;
    private int search;
    private int goods;
    private int goodsid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bindID();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        Intent intent = getIntent();
        avert = intent.getIntExtra("avert", 0);
        express = intent.getIntExtra("express", 0);
        item = intent.getIntExtra("item", 0);
        shoppingcar = intent.getIntExtra("shoppingcar", 0);
        confirm = intent.getIntExtra("confirm", 0);
        search = intent.getIntExtra("search", 0);
        goods = intent.getIntExtra("goods", 0);
        goodsid = intent.getIntExtra("goodsid", 0);
        changeFragment();
    }

    private void changeFragment() {
        if (avert != 0) {
            switch (avert) {
                case 1:
                    mTitleTV.setText("个人信息");
                    if (mPersonalFragment == null)
                        mPersonalFragment = new PersonalFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mPersonalFragment);
                    break;
                case 2:
                    mTitleTV.setText("待付款订单");
                    if (mDaiFukuanFragment == null)
                        mDaiFukuanFragment = new DaiFukuanFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mDaiFukuanFragment);
                    break;
                case 3:
                    mTitleTV.setText("待收货");
                    if (mDaiShouhuoFragment == null)
                        mDaiShouhuoFragment = new DaiShouhuoFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mDaiShouhuoFragment);
                    break;
                case 4:
                    mTitleTV.setText("全部订单");
                    if (mQuanBudingdanFragment == null)
                        mQuanBudingdanFragment = new QuanBudingdanFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mQuanBudingdanFragment);
                    break;
            }
            mFragmentTransaction.commit();
        } else if (express != 0) {
            mTitleTV.setText("物流详情");
            if (mExpressFragment == null)
                mExpressFragment = new ExpressFragment();
            mFragmentTransaction.replace(R.id.main_se_fl, mExpressFragment);
            mFragmentTransaction.commit();
        } else if (item != 0) {
            switch (item) {
                case 1:
                    mTitleTV.setText("我的收藏");
                    if (mCollectionFragment == null)
                        mCollectionFragment = new CollectionFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mCollectionFragment);
                    break;
                case 2:
                    mTitleTV.setText("我的消息");
                    if (mNewsFragment == null)
                        mNewsFragment = new NewsFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mNewsFragment);
                    break;
                case 3:
                    mTitleTV.setText("优惠券");
                    if (mCouponFragment == null)
                        mCouponFragment = new CouponFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mCouponFragment);
                    break;
                case 4:
                    mTitleTV.setText("退款/售后");
                    if (mRefundFragment == null)
                        mRefundFragment = new RefundFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mRefundFragment);
                    break;
                case 5:
                    mTitleTV.setText("收货地址");
                    if (mAddressFragment == null)
                        mAddressFragment = new AddressFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mAddressFragment);
                    break;
                case 6:
                    mTitleTV.setText("设置");
                    if (mSettingFragment == null)
                        mSettingFragment = new SettingFragment();
                    mFragmentTransaction.replace(R.id.main_se_fl, mSettingFragment);
                    break;
            }
            mFragmentTransaction.commit();
        } else if (shoppingcar != 0) {
            mInclude.setVisibility(View.GONE);
            if (mShoppingCarFragment == null)
                mShoppingCarFragment = new ShoppingCarFragment();
            mFragmentTransaction.replace(R.id.main_se_fl, mShoppingCarFragment);
            mFragmentTransaction.commit();
        } else if (confirm != 0) {
            mTitleTV.setText("确认订单");
            if (mConfirmFragment == null)
                mConfirmFragment = new ConfirmFragment();
            mFragmentTransaction.replace(R.id.main_se_fl, mConfirmFragment);
            mFragmentTransaction.commit();
        } else if (search != 0) {
            mInclude.setVisibility(View.GONE);
            if (mSearchFragment == null)
                mSearchFragment = new SearchFragment();
            mFragmentTransaction.replace(R.id.main_se_fl, mSearchFragment);
            mFragmentTransaction.commit();
        } else if (goods != 0) {
            mSearchIB.setVisibility(View.VISIBLE);
            switch (goods) {
                case 1:
                    mTitleTV.setText("女装");
                    break;
                case 2:
                    mTitleTV.setText("男装");
                    break;
                case 3:
                    mTitleTV.setText("童装");
                    break;
            }
            Bundle bundle = new Bundle();
            if (goodsid != 0) {
                mSearchIB.setImageResource(R.drawable.share);
                if (mGoodsFragment == null)
                    mGoodsFragment = new GoodsFragment();
                bundle.putInt("goodsid", goodsid);
                mGoodsFragment.setArguments(bundle);
                mFragmentTransaction.replace(R.id.main_se_fl, mGoodsFragment);
            } else {
                if (mGoodsListFragment == null)
                    mGoodsListFragment = new GoodsListFragment();
                bundle.putInt("goods", goods);
                bundle.putInt("goodsid", goods);
                mGoodsListFragment.setArguments(bundle);
                mFragmentTransaction.replace(R.id.main_se_fl, mGoodsListFragment);
            }
            mFragmentTransaction.commit();
        }
    }

    private void bindID() {
        mInclude = findViewById(R.id.main_se_include);
        mBackIB = mInclude.findViewById(R.id.abar_back);
        mBackIB.setImageResource(R.drawable.back);
        mBackIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitleTV = mInclude.findViewById(R.id.abar_title);
        mSearchIB = mInclude.findViewById(R.id.abar_search);
        mSearchIB.setVisibility(View.INVISIBLE);
        mSearchIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, SecondActivity.class).putExtra("search",
                        1));
            }
        });
        mFrameLayout = (FrameLayout) findViewById(R.id.main_se_fl);
    }
}
