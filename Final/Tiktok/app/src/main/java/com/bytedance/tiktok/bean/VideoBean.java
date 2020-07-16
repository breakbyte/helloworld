package com.bytedance.tiktok.bean;

/*
        视频实体类
 */
public class VideoBean {
    private int videoId;

    private String videopath;
    /** 视频播放资源 */
    private int videoRes;
    /** 封面图片资源 */
    private int coverRes;
    /** 视频文案内容 */
    private String content;
    /** 作者 */
    private UserBean userBean;
    /** 是否已点赞 */
    private boolean isLiked;
    /** 与视频发布距离 */
    private float distance;
    /** 是否已关注 */
    private boolean isFocused;
    /** 点赞数 */
    private int likeCount;
    /** 评论数 */
    private int commentCount;
    /** 转发数 */
    private int shareCount;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoPath() {
        return videopath;
    }

    public void setVideoPath(String path) {
        this.videopath = path;
    }

    public int getVideoRes() {
        return videoRes;
    }

    public void setVideoRes(int videoRes) {
        this.videoRes = videoRes;
    }

    public int getCoverRes() {
        return coverRes;
    }

    public void setCoverRes(int coverRes) {
        this.coverRes = coverRes;
    }

    public String getContent() {
        return content == null ? "" : content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean focused) {
        isFocused = focused;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public static class UserBean {
        private int uid;
        private String nickName;
        private int head;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNickName() {
            return nickName == null ? "" : nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getHead() {
            return head;
        }

        public void setHead(int head) {
            this.head = head;
        }
    }
}
