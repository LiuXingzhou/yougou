package com.islxz.yougou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islxz.yougou.R;

/**
 * Created by Qingsu on 2017/6/20.
 */

public class HomeFragment extends Fragment {

    private ImageButton mBackIB;
    private TextView mTitleTV;
    private ImageButton mSearchIB;
    private ViewPager mViewPager;
    private LinearLayout mLinearLayout1;
    private LinearLayout mLinearLayout2;
    private LinearLayout mLinearLayout3;
    private FloatingActionButton mShoppingCar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private View mHeaderView;
    private LinearLayout mDaiFKLL;
    private LinearLayout mDaiSHLL;
    private LinearLayout mQuanBDDLL;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {

    }
}
