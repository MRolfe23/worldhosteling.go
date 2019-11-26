package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class GroupChat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String createDate;

    @OneToMany
    private List<Account> groupChatList;

    public GroupChat() {}

    public GroupChat(String name, List<Account> groupChatList) {
        this.name = name;
        this.groupChatList = groupChatList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<Account> getGroupChatList() {
        return groupChatList;
    }

    public void setGroupChatList(List<Account> groupChatList) {
        this.groupChatList = groupChatList;
    }

    @Override
    public String toString() {
        return "GroupChat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                ", groupChatList=" + groupChatList +
                '}';
    }
}
