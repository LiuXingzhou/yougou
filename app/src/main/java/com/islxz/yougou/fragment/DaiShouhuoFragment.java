package com.islxz.yougou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.islxz.yougou.R;
import com.islxz.yougou.activity.SecondActivity;

/**
 * Created by Qingsu on 2017/6/21.
 */

public class DaiShouhuoFragment extends Fragment implements View.OnClickListener {

    private View mInclude1;
    private View mInclude2;
    private View mInclude3;
    private View mInclude4;
    private View mInclude5;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dai_shou_huo, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {
        mInclude1 = view.findViewById(R.id.fg_dsh_include1);
        mInclude2 = view.findViewById(R.id.fg_dsh_include2);
        mInclude3 = view.findViewById(R.id.fg_dsh_include3);
        mInclude4 = view.findViewById(R.id.fg_dsh_include4);
        mInclude5 = view.findViewById(R.id.fg_dsh_include5);
        mButton1 = mInclude1.findViewById(R.id.itdsh_rl3_see);
        mButton2 = mInclude2.findViewById(R.id.itdsh_rl3_see);
        mButton3 = mInclude3.findViewById(R.id.itdsh_rl3_see);
        mButton4 = mInclude4.findViewById(R.id.itdsh_rl3_see);
        mButton5 = mInclude5.findViewById(R.id.itdsh_rl3_see);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        getActivity().startActivity(new Intent(getActivity(), SecondActivity.class).putExtra
                ("express", 1));
    }
}
