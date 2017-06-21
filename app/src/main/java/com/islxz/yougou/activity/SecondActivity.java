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
import com.islxz.yougou.fragment.CouponFragment;
import com.islxz.yougou.fragment.DaiFukuanFragment;
import com.islxz.yougou.fragment.DaiShouhuoFragment;
import com.islxz.yougou.fragment.ExpressFragment;
import com.islxz.yougou.fragment.NewsFragment;
import com.islxz.yougou.fragment.PersonalFragment;
import com.islxz.yougou.fragment.QuanBudingdanFragment;
import com.islxz.yougou.fragment.RefundFragment;
import com.islxz.yougou.fragment.SettingFragment;

public class SecondActivity extends AppCompatActivity {

    private View mInclude;
    private ImageButton mBackIB;
    private TextView mTitleTV;
    private ImageButton mSearchIB;
    private FrameLayout mFrameLayout;

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

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private int avert;
    private int item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bindID();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        Intent intent = getIntent();
        avert = intent.getIntExtra("avert", 0);
        item = intent.getIntExtra("item", 0);
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
        }
        mFragmentTransaction.commit();
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
        mSearchIB.setVisibility(View.GONE);

        mFrameLayout = (FrameLayout) findViewById(R.id.main_se_fl);
    }
}
