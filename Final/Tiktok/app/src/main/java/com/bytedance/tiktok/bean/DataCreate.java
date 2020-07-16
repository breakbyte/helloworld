package com.bytedance.tiktok.bean;

import com.bytedance.tiktok.R;
import java.util.ArrayList;

/*
        本地数据创建，代替接口获取数据
 */
public class DataCreate {
    public static ArrayList<VideoBean> datas = new ArrayList<>();
    public static ArrayList<VideoBean.UserBean> userList = new ArrayList<>();

    public void initData() {

        VideoBean videoBeanOne = new VideoBean();
        videoBeanOne.setCoverRes(R.mipmap.cover1);
        videoBeanOne.setContent("自制多米诺骨牌高能#玩具 #童年 #solo出道谁最nata");
        videoBeanOne.setVideoRes(R.raw.video1);
        videoBeanOne.setDistance(7.9f);
        videoBeanOne.setFocused(false);
        videoBeanOne.setLiked(true);
        videoBeanOne.setLikeCount(226823);
        videoBeanOne.setCommentCount(3480);
        videoBeanOne.setShareCount(4252);

        VideoBean.UserBean userBeanOne = new VideoBean.UserBean();
        userBeanOne.setUid(1);
        userBeanOne.setHead(R.mipmap.head1);
        userBeanOne.setNickName("玩具新科技");

        userList.add(userBeanOne);
        videoBeanOne.setUserBean(userBeanOne);

        VideoBean videoBeanTwo = new VideoBean();
        videoBeanTwo.setCoverRes(R.mipmap.cover2);
        videoBeanTwo.setContent("下雨天不能出去了，一家人的娱乐方式都在她身上了@抖音小助手");
        videoBeanTwo.setVideoRes(R.raw.video2);
        videoBeanTwo.setDistance(19.7f);
        videoBeanTwo.setFocused(true);
        videoBeanTwo.setLiked(false);
        videoBeanTwo.setLikeCount(1938230);
        videoBeanTwo.setCommentCount(8923);
        videoBeanTwo.setShareCount(5892);

        VideoBean.UserBean userBeanTwo = new VideoBean.UserBean();
        userBeanTwo.setUid(2);
        userBeanTwo.setHead( R.mipmap.head2);
        userBeanTwo.setNickName("瑞琪组合");

        userList.add(userBeanTwo);
        videoBeanTwo.setUserBean(userBeanTwo);

        VideoBean videoBeanThree = new VideoBean();
        videoBeanThree.setCoverRes(R.mipmap.cover3);
        videoBeanThree.setContent("#乡村教师 活力的小世界@抖音小助手");
        videoBeanThree.setVideoRes(R.raw.video3);
        videoBeanThree.setDistance(15.9f);
        videoBeanThree.setFocused(false);
        videoBeanThree.setLiked(false);
        videoBeanThree.setLikeCount(592032);
        videoBeanThree.setCommentCount(9221);
        videoBeanThree.setShareCount(982);

        VideoBean.UserBean userBeanThree = new VideoBean.UserBean();
        userBeanThree.setUid(3);
        userBeanThree.setHead(R.mipmap.head3);
        userBeanThree.setNickName("Q·小酒窝");

        userList.add(userBeanThree);
        videoBeanThree.setUserBean(userBeanThree);

        VideoBean videoBeanFour = new VideoBean();
        videoBeanFour.setCoverRes(R.mipmap.cover4);
        videoBeanFour.setContent("最大胆的出师，用艺术诠释美食#dou出新知 #美食");
        videoBeanFour.setVideoRes(R.raw.video4);
        videoBeanFour.setDistance(25.2f);
        videoBeanFour.setFocused(false);
        videoBeanFour.setLiked(false);
        videoBeanFour.setLikeCount(887232);
        videoBeanFour.setCommentCount(2731);
        videoBeanFour.setShareCount(8924);

        VideoBean.UserBean userBeanFour = new VideoBean.UserBean();
        userBeanFour.setUid(4);
        userBeanFour.setHead(R.mipmap.head4);
        userBeanFour.setNickName("寻味记");

        userList.add(userBeanFour);
        videoBeanFour.setUserBean(userBeanFour);

        VideoBean videoBeanFive = new VideoBean();
        videoBeanFive.setCoverRes(R.mipmap.cover5);
        videoBeanFive.setContent("唱的太悲伤了！听哭了！ ");
        videoBeanFive.setVideoRes(R.raw.video5);
        videoBeanFive.setDistance(9.2f);
        videoBeanFive.setFocused(false);
        videoBeanFive.setLiked(false);
        videoBeanFive.setLikeCount(8293241);
        videoBeanFive.setCommentCount(982);
        videoBeanFive.setShareCount(8923);

        VideoBean.UserBean userBeanFive = new VideoBean.UserBean();
        userBeanFive.setUid(5);
        userBeanFive.setHead(R.mipmap.head5);
        userBeanFive.setNickName("情感音乐库");

        userList.add(userBeanFive);
        videoBeanFive.setUserBean(userBeanFive);

        VideoBean videoBeanSix = new VideoBean();
        videoBeanSix.setCoverRes(R.mipmap.cover6);
        videoBeanSix.setContent("#夏邑县红团羊肉汤 感谢老板从安徽跑到李集光临小店！");
        videoBeanSix.setVideoRes(R.raw.video6);
        videoBeanSix.setDistance(16.4f);
        videoBeanSix.setFocused(true);
        videoBeanSix.setLiked(true);
        videoBeanSix.setLikeCount(2109823);
        videoBeanSix.setCommentCount(9723);
        videoBeanFive.setShareCount(424);

        VideoBean.UserBean userBeanSix = new VideoBean.UserBean();
        userBeanSix.setUid(6);
        userBeanSix.setHead(R.mipmap.head6);
        userBeanSix.setNickName("红团羊肉汤");

        userList.add(userBeanSix);
        videoBeanSix.setUserBean(userBeanSix);

        datas.add(videoBeanOne);
        datas.add(videoBeanTwo);
        datas.add(videoBeanThree);
        datas.add(videoBeanFour);
        datas.add(videoBeanFive);
        datas.add(videoBeanSix);



    }
}
