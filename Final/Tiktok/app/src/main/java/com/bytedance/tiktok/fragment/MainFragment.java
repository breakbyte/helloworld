package com.bytedance.tiktok.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bytedance.tiktok.R;
import com.bytedance.tiktok.activity.VideoActivity;
import com.bytedance.tiktok.base.BaseFragment;
import com.bytedance.tiktok.base.CommPagerAdapter;
import com.bytedance.tiktok.bean.DataCreate;
import com.bytedance.tiktok.bean.PauseVideoEvent;
import com.bytedance.tiktok.bean.VideoBean;
import com.bytedance.tiktok.utils.RxBus;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/*
        主页fragment
 */
public class MainFragment extends BaseFragment {
    private CurrentLocationFragment currentLocationFragment;
    private RecommendFragment recommendFragment;
    private static final int REQUEST_CODE_1 = 1357;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tab_title)
    XTabLayout tabTitle;
    @BindView(R.id.tab_mainmenu)
    XTabLayout tabMainMenu;
    @BindView(R.id.ic_video)
    ImageView Videoget;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private CommPagerAdapter pagerAdapter;
    /** 默认显示第一页推荐页 */
    public static int curPage = 1;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init() {
        setFragments();

        setMainMenu();
        Videoget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                startActivityForResult(intent,REQUEST_CODE_1);
            }
        });
    }

    private void setFragments() {
        currentLocationFragment = new CurrentLocationFragment();
        recommendFragment = new RecommendFragment();
        fragments.add(currentLocationFragment);
        fragments.add(recommendFragment);

        tabTitle.addTab(tabTitle.newTab().setText("新疆"));
        tabTitle.addTab(tabTitle.newTab().setText("推荐"));

        pagerAdapter = new CommPagerAdapter(getChildFragmentManager(), fragments, new String[] {"新疆", "推荐"});
        viewPager.setAdapter(pagerAdapter);
        tabTitle.setupWithViewPager(viewPager);

        tabTitle.getTabAt(1).select();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curPage = position;
                if (position == 1) {
                    //继续播放
                    RxBus.getDefault().post(new PauseVideoEvent(true));
                } else {
                    //切换到其他页面，需要暂停视频
                    RxBus.getDefault().post(new PauseVideoEvent(false));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setMainMenu() {
        tabMainMenu.addTab(tabMainMenu.newTab().setText("首页"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("好友"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText(""));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("消息"));
        tabMainMenu.addTab(tabMainMenu.newTab().setText("我"));
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_1) {
            if (resultCode == RESULT_OK && data != null) {
                new Thread() {
                    @Override
                    public void run() {
                        String result = data.getStringExtra(VideoActivity.KEY);
                        VideoBean videoBeannew = new VideoBean();
                        videoBeannew.setCoverRes(R.mipmap.cover9);
                        videoBeannew.setContent("#自制抖音 来看看我的录制呀！");
                        videoBeannew.setVideoPath(result);
                        videoBeannew.setDistance(7.9f);
                        videoBeannew.setFocused(false);
                        videoBeannew.setLiked(true);
                        videoBeannew.setLikeCount(336769);
                        videoBeannew.setCommentCount(999);
                        videoBeannew.setShareCount(6123);

                        VideoBean.UserBean userBeannew = new VideoBean.UserBean();
                        userBeannew.setUid(1);
                        userBeannew.setHead(R.mipmap.head9);
                        userBeannew.setNickName("浙大无名氏");

                        DataCreate.userList.add(userBeannew);
                        videoBeannew.setUserBean(userBeannew);
                        DataCreate.datas.add(videoBeannew);
                    }
                }.start();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getContext(), "没有获取视频", Toast.LENGTH_LONG).show();
            }
        }
    }

}
