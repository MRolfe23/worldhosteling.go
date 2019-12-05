package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotEmpty(message = "Must include an account from.")
    private Account from;

    @Column(nullable = false)
    @NotEmpty(message = "Cannot send empty comment.")
    private String content;

    private String photo;

    private LocalDate createDate = LocalDate.now();

    public Comment() {}

    public Comment(Account from, String content, String photo, LocalDate createDate) {
        this.from = from;
        this.content = content;
        this.photo = photo;
        this.createDate = createDate;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", content='" + content + '\'' +
                ", photo='" + photo + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
