package com.islxz.yougou.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islxz.yougou.R;

/**
 * Created by Qingsu on 2017/6/22.
 */

public class AddSubView extends LinearLayout implements View.OnClickListener {

    private TextView mNumTV;
    private int mNum = 0;
    private View view;

    public AddSubView(Context context) {
        super(context);
    }

    public AddSubView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.custome_add_sub, null);
        mNumTV = view.findViewById(R.id.custom_as_tv_num);
        this.addView(view);
    }

    public boolean setNum(int arg0) {
        mNum = arg0;
        mNumTV.setText(mNum + "");
        return true;
    }

    public int getNum() {
        return mNum;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.custom_as_ib_add:
                mNum++;
                break;
            case R.id.custom_as_ib_sub:
                if (mNum > 0)
                    mNum--;
                break;
        }
        mNumTV.setText(mNum + "");
    }
}
