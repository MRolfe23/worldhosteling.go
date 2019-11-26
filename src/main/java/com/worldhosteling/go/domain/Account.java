package com.worldhosteling.go.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Account extends Person {

    private String userName;

    private String password;

    private String accountType;

    private String aboutMe;

    private String profilePicture;

    private String backgroundPicture;

    @OneToMany
    private List<Photo> photoList;

    @OneToMany
    private List<Account> friendList;

    @OneToMany
    private List<Hostel> hostelList;

    private boolean isActive;

    private boolean isPrivate;

    public Account() {}

    // probably dont need this
    public Account(String userName, String password, String accountType, String aboutMe, String profilePicture, String backgroundPicture) {
        super();
        this.userName = userName;
        this.aboutMe = aboutMe;
        this.accountType = accountType;
        this.password = password;
        this.backgroundPicture = backgroundPicture;
        this.profilePicture = profilePicture;
    }

    public Account(String id, String firstName, String lastName, String email, Date birthDate, String userName, String password, String accountType, String aboutMe, String profilePicture, String backgroundPicture, List<Photo> photoList, List<Account> friendList, List<Hostel> hostelList, boolean isActive, boolean isPrivate) {
        super(id, firstName, lastName, email, birthDate);
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
        this.aboutMe = aboutMe;
        this.profilePicture = profilePicture;
        this.backgroundPicture = backgroundPicture;
        this.photoList = photoList;
        this.friendList = friendList;
        this.hostelList = hostelList;
        this.isActive = isActive;
        this.isPrivate = isPrivate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBackgroundPicture() {
        return backgroundPicture;
    }

    public void setBackgroundPicture(String backgroundPicture) {
        this.backgroundPicture = backgroundPicture;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<Account> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Account> friendList) {
        this.friendList = friendList;
    }

    public List<Hostel> getHostelList() {
        return hostelList;
    }

    public void setHostelList(List<Hostel> hostelList) {
        this.hostelList = hostelList;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountType='" + accountType + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", backgroundPicture='" + backgroundPicture + '\'' +
                '}';
    }

}
