package com.islxz.yougou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.islxz.yougou.R;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class SearchFragment extends Fragment implements View.OnClickListener {

    private View mInclude;
    private ImageButton mBackBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        bindID(view);
        return view;
    }

    private void bindID(View view) {
        mInclude = view.findViewById(R.id.fg_search_include);
        mBackBtn = mInclude.findViewById(R.id.abar_back);
        mBackBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.abar_back:
                getActivity().finish();
                break;
        }
    }
}
