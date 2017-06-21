package com.islxz.yougou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.islxz.yougou.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Qingsu on 2017/6/21.
 */

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout mImgRL;
    private CircleImageView mAvertImg;
    private RelativeLayout mNameRL;
    private TextView mAvertName;
    private RelativeLayout mGenderRL;
    private TextView mAvertGender;
    private RelativeLayout mDateRL;
    private TextView mAvertDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {
        mImgRL = view.findViewById(R.id.fg_per_rl_img);
        mImgRL.setOnClickListener(this);
        mAvertImg = view.findViewById(R.id.fg_per_avert_img);
        mNameRL = view.findViewById(R.id.fg_per_rl_name);
        mNameRL.setOnClickListener(this);
        mAvertName = view.findViewById(R.id.fg_per_avert_name);
        mGenderRL = view.findViewById(R.id.fg_per_rl_gender);
        mGenderRL.setOnClickListener(this);
        mAvertGender = view.findViewById(R.id.fg_per_avert_gender);
        mDateRL = view.findViewById(R.id.fg_per_rl_date);
        mDateRL.setOnClickListener(this);
        mAvertDate = view.findViewById(R.id.fg_per_avert_date);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fg_per_rl_img:
                Toast.makeText(getActivity(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fg_per_rl_name:
                Toast.makeText(getActivity(), "昵称", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fg_per_rl_gender:
                Toast.makeText(getActivity(), "性别", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fg_per_rl_date:
                Toast.makeText(getActivity(), "年龄", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
