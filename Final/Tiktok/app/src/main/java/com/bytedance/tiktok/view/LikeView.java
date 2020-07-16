package com.bytedance.tiktok.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/*
        点赞动画view
 */
public class LikeView extends RelativeLayout {
    private GestureDetector gestureDetector;
    private OnPlayPauseListener onPlayPauseListener;
    private OnLikeListener onLikeListener;

    public LikeView(Context context) {
        super(context);
        init();
    }

    public LikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                onLikeListener.onLikeListener();
                return true;
            }

            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                if (onPlayPauseListener != null) {
                    onPlayPauseListener.onPlayOrPause();
                }
                return true;
            }
        });

        setOnTouchListener((v, event) -> {
            gestureDetector.onTouchEvent(event);
            return true;
        });
    }



    public interface OnPlayPauseListener {
        void onPlayOrPause();
    }

    /**
     * 设置单机播放暂停事件
     * @param onPlayPauseListener
     */
    public void setOnPlayPauseListener(OnPlayPauseListener onPlayPauseListener) {
        this.onPlayPauseListener = onPlayPauseListener;
    }

    public interface OnLikeListener {
        void onLikeListener();
    }

    /**
     * 设置双击点赞事件
     * @param onLikeListener
     */
    public void setOnLikeListener(OnLikeListener onLikeListener) {
        this.onLikeListener = onLikeListener;
    }
}
