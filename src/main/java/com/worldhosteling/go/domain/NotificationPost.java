package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class NotificationPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotEmpty(message = "Must include an account from.")
    private Account from;

    @OneToOne
    @NotEmpty(message = "Must include an account to.")
    private Account to;

    @OneToOne
    @NotEmpty(message = "Must include a post.")
    private Post post;

    private boolean isSeen = false;

    public NotificationPost() {}

    public NotificationPost(Account from, Account to, Post post, boolean isSeen) {
        this.from = from;
        this.to = to;
        this.post = post;
        this.isSeen = isSeen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    @Override
    public String toString() {
        return "NotificationPost{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", post=" + post +
                ", isSeen=" + isSeen +
                '}';
    }

}