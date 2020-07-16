package com.bytedance.tiktok.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.base.BaseRvAdapter;
import com.bytedance.tiktok.base.BaseRvViewHolder;
import com.bytedance.tiktok.bean.VideoBean;
import com.bytedance.tiktok.view.ControllerView;
import com.bytedance.tiktok.view.LikeView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
        视频Adapter
 */
public class VideoAdapter extends BaseRvAdapter<VideoBean, VideoAdapter.VideoViewHolder> {

    public VideoAdapter(Context context, List<VideoBean> datas) {
        super(context, datas);
    }

    @Override
    protected void onBindData(VideoViewHolder vholder, VideoBean videoBean, int position) {
        vholder.controllerView.setVideoData(videoBean);

        vholder.ivCover.setImageResource(videoBean.getCoverRes());

        vholder.likeView.setOnLikeListener(() -> {
            if (!videoBean.isLiked()) {  //未点赞，会有点赞效果，否则无
                vholder.controllerView.like();
            }

        });
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    public class VideoViewHolder extends BaseRvViewHolder {
        @BindView(R.id.likeview)
        LikeView likeView;
        @BindView(R.id.controller)
        ControllerView controllerView;
        @BindView(R.id.iv_cover)
        ImageView ivCover;

        public VideoViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
