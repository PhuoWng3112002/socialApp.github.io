package com.example.chatmeapp.Utills;

public class Posts {
    private String postDesc,datePost,postImageUrl,userProfileImageUrl,username;

    public Posts() {
    }

    public Posts(String postDesc, String datePost, String postImageUrl, String userProfileImageUrl, String username) {
        this.postDesc = postDesc;
        this.datePost = datePost;
        this.postImageUrl = postImageUrl;
        this.userProfileImageUrl = userProfileImageUrl;
        this.username = username;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
