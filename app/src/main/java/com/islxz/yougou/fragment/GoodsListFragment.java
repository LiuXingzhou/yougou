package com.islxz.yougou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.islxz.yougou.R;
import com.islxz.yougou.activity.SecondActivity;
import com.islxz.yougou.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qingsu on 2017/6/21.
 */

public class GoodsListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private List<Goods> mGoodsList;
    private MasonryAdapter mMasonryAdapter;
    private RecyclerView.ItemDecoration mItemDecoration;

    private int goods;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goods_list, null);
        Bundle bundle = getArguments();
        goods = bundle.getInt("goods");
        bindID(view);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager
                .VERTICAL));
        initData(goods);
        mMasonryAdapter = new MasonryAdapter();
        mRecyclerView.setAdapter(mMasonryAdapter);
        return view;
    }

    private void initData(int goods) {
        mGoodsList = new ArrayList<>();
        Goods goods1 = new Goods();
        Goods goods2 = new Goods();
        Goods goods3 = new Goods();
        switch (goods) {
            case 1:
                goods1.setImg(R.drawable.img1);
                goods2.setImg(R.drawable.img1);
                goods3.setImg(R.drawable.img1);
                goods1.setName("时尚白色连衣裙 长袖小白裙 婚礼裙 显瘦公主裙");
                goods2.setName("时尚白色连衣裙 长袖小白裙 婚礼裙 显瘦公主裙时尚白色连衣裙 长袖小白裙 婚礼裙 显瘦公主裙");
                goods3.setName("时尚白色连裙");
                break;
            case 2:
                goods1.setImg(R.drawable.img2);
                goods2.setImg(R.drawable.img2);
                goods3.setImg(R.drawable.img2);
                goods1.setName("夹克男春季青年外套男士 休闲上衣");
                goods2.setName("夹克男春季青年外套男士 休闲上衣潮流大码 立领男装夹克衫");
                goods3.setName("夹克男春季青年外套男士 休闲上衣潮流大码 立领男装夹克衫 立领男装夹克衫");
                break;
            case 3:
                goods1.setImg(R.drawable.img3);
                goods2.setImg(R.drawable.img3);
                goods3.setImg(R.drawable.img3);
                goods1.setName("时尚白色连衣裙 长袖小白裙 婚礼裙 显瘦公主裙");
                goods2.setName("夹克男春季青年外套男士 休闲上衣潮流大码 立领男装夹克衫");
                goods3.setName("粗罗纹开衫 套头衫开衫");
                break;
        }
        goods1.setPrice("159");
        goods2.setPrice("189");
        goods3.setPrice("96");
        goods1.setNum("99");
        goods2.setNum("547");
        goods3.setNum("3924");
        mGoodsList.add(goods1);
        mGoodsList.add(goods2);
        mGoodsList.add(goods3);
        mGoodsList.add(goods1);
        mGoodsList.add(goods2);
        mGoodsList.add(goods3);
        mGoodsList.add(goods1);
        mGoodsList.add(goods2);
        mGoodsList.add(goods3);
        mGoodsList.add(goods1);
        mGoodsList.add(goods2);
        mGoodsList.add(goods3);
    }

    private void bindID(View view) {
        mRecyclerView = view.findViewById(R.id.fg_goods_list_rv);
    }

    public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

        Intent mIntent = new Intent(getActivity(), SecondActivity.class);

        @Override
        public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods_list,
                    parent, false);
            return new MasonryView(view);
        }

        @Override
        public void onBindViewHolder(MasonryView holder, int position) {
            holder.mImageView.setImageResource(mGoodsList.get(position).getImg());
            holder.mGoodsName.setText(mGoodsList.get(position).getName());
            holder.mGoodsPrice.setText("¥" + mGoodsList.get(position).getPrice());
            holder.mGoodsNum.setText("已售出" + mGoodsList.get(position).getNum() + "件");
            holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIntent.putExtra("goods", goods);
                    mIntent.putExtra("goodsid", 1);
                    getActivity().startActivity(mIntent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mGoodsList.size();
        }

        public class MasonryView extends RecyclerView.ViewHolder {

            LinearLayout mLinearLayout;
            ImageView mImageView;
            TextView mGoodsName;
            TextView mGoodsPrice;
            TextView mGoodsNum;

            public MasonryView(View itemView) {
                super(itemView);
                mLinearLayout = itemView.findViewById(R.id.itgl_ll);
                mImageView = itemView.findViewById(R.id.itgl_img);
                mGoodsName = itemView.findViewById(R.id.itgl_name);
                mGoodsPrice = itemView.findViewById(R.id.itgl_price);
                mGoodsNum = itemView.findViewById(R.id.itgl_num);
            }
        }
    }

}
