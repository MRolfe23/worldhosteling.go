package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;


// @Data -- Lombok, is used to auto-generate getters and setters and toString and constructors without coding it out.
// so what I did is overKill except for overloaded constructors `\(',')/`
@Data
@Entity
public class NotificationPM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Account from;

    // TODO: Might need to make this a many to one or one to one
    @ManyToOne
    private GroupChat groupChat;

    private boolean isSeen;

    public NotificationPM() {}

    public NotificationPM(Account from, GroupChat groupChat, boolean isSeen) {
        this.from = from;
        this.groupChat = groupChat;
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

    public GroupChat getGroupChat() {
        return groupChat;
    }

    public void setGroupChat(GroupChat groupChat) {
        this.groupChat = groupChat;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    @Override
    public String toString() {
        return "NotificationPM{" +
                "id=" + id +
                ", from=" + from +
                ", groupChat=" + groupChat +
                ", isSeen=" + isSeen +
                '}';
    }
}
