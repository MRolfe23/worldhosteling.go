package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class PrivateMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @NotEmpty(message = "Must include an account from.")
    private Account from;

    @OneToOne
    @NotEmpty(message = "Must include an account to.")
    private GroupChat to;

    @Column(nullable = false)
    @NotEmpty(message = "Must include content.")
    private String messageContent;

    @ElementCollection(targetClass=String.class)
    private List<String> photoList;

    public PrivateMessage() {}

    public PrivateMessage(Account from, GroupChat to, String messageContent, List<String> photoList) {
        this.from = from;
        this.to = to;
        this.messageContent = messageContent;
        this.photoList = photoList;
    }

    public PrivateMessage(Account from, GroupChat to, String messageContent) {
        this.from = from;
        this.to = to;
        this.messageContent = messageContent;
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

    public GroupChat getTo() {
        return to;
    }

    public void setTo(GroupChat to) {
        this.to = to;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }

    @Override
    public String toString() {
        return "PrivateMessage{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", messageContent='" + messageContent + '\'' +
                ", photoList=" + photoList +
                '}';
    }
}
