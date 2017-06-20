package com.islxz.yougou.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.islxz.yougou.R;
import com.islxz.yougou.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private FrameLayout mFrameLayout;

    private HomeFragment mHomeFragment;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mImageView.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        bindID();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mHandler.sendEmptyMessage(0);
            }
        }).start();
        if (mHomeFragment == null)
            mHomeFragment = new HomeFragment();
        mFragmentTransaction.replace(R.id.mact_fl, mHomeFragment);
        mFragmentTransaction.commit();
    }

    private void bindID() {
        mImageView = (ImageView) findViewById(R.id.mact_iv);
        mFrameLayout = (FrameLayout) findViewById(R.id.mact_fl);
    }
}
