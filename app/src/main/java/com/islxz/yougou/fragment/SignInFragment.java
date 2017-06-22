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
import com.islxz.yougou.activity.MainActivity;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class SignInFragment extends Fragment implements View.OnClickListener {

    private Button mSignInBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {
        mSignInBtn = view.findViewById(R.id.fg_sign_in_btn);
        mSignInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
    }
}
