package com.bytedance.tiktok.base;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/*
        tip多套布局T传Object类型，其他直接传具体类型
 */
public abstract class BaseRvAdapter<T,VH extends BaseRvViewHolder> extends RecyclerView.Adapter<VH> {
    protected Context context;
    protected List<T> mDatas;
    protected OnItemClickListener onItemClickListener;

    public BaseRvAdapter(Context context, List<T> datas) {
        this.context = context;
        mDatas = datas;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        //item点击事件获取
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                onItemClickListener.onItemClick(v, position);
            });
        }
        onBindData(holder,mDatas.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    protected abstract void onBindData(VH holder, T data, int position);


    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

}
