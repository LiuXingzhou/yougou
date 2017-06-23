package com.islxz.yougou.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.islxz.yougou.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qingsu on 2017/6/21.
 */

public class GoodsFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private List<Integer> mViewList;

    private MasonryAdapter mMasonryAdapter;
    private RecyclerView.ItemDecoration mItemDecoration;

    private int goodid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods, null);
        Bundle bundle = getArguments();
        goodid = bundle.getInt("goodsid");
        bindID(view);
        initView();
        return view;
    }

    public void initView() {
        mViewList = new ArrayList<>();
        switch (goodid) {
            case 1:
                mViewList.add(R.drawable.img1);
                mViewList.add(R.drawable.img1);
                mViewList.add(R.drawable.img1);
                break;
            case 2:
                mViewList.add(R.drawable.img2);
                mViewList.add(R.drawable.img2);
                mViewList.add(R.drawable.img2);
                break;
            case 3:
                mViewList.add(R.drawable.img3);
                mViewList.add(R.drawable.img3);
                mViewList.add(R.drawable.img3);
                break;
        }
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager
                .HORIZONTAL));
        mMasonryAdapter = new MasonryAdapter();
        mRecyclerView.setAdapter(mMasonryAdapter);
    }

    private void bindID(View view) {
        mRecyclerView = view.findViewById(R.id.fg_goods_rv);
    }

    public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

        @Override
        public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_img,
                    parent, false);
            return new MasonryView(view);
        }

        @Override
        public void onBindViewHolder(MasonryView holder, int position) {
            holder.mImageView.setImageResource(mViewList.get(position));
        }

        @Override
        public int getItemCount() {
            return mViewList.size();
        }

        public class MasonryView extends RecyclerView.ViewHolder {

            ImageView mImageView;

            public MasonryView(View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.itgi_img);
            }
        }
    }

}
