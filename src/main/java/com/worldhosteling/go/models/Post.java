package com.worldhosteling.go.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotEmpty(message = "Must include an account from.")
    private Account from;

    @OneToOne
    @NotEmpty(message = "Must include an account to.")
    private Account to;

    @Column(nullable = false)
    @NotEmpty(message = "Must include content.")
    private String content;

    @OneToMany
    private List<Photo> photoList;

    private LocalDate createDate = LocalDate.now();

    @OneToMany
    private List<Account> likeCount;

    @OneToMany
    private List<Comment> commentList;

    public Post() {}

    public Post(Account from, Account to, String content, List<Photo> photoList, LocalDate createDate, List<Comment> commentList) {
        this.from = from;
        this.to = to;
        this.content = content;
        this.photoList = photoList;
        this.createDate = createDate;
        this.commentList = commentList;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Account> getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(List<Account> likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", content='" + content + '\'' +
                ", photoList=" + photoList +
                ", createDate=" + createDate +
                ", likeCount=" + likeCount +
                ", commentList=" + commentList +
                '}';
    }


}
