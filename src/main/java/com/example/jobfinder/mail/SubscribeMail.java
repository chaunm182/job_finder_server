package com.example.jobfinder.mail;

import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.post.Post;

public class SubscribeMail extends Mail {
    private User user;
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
