package com.worldhosteling.go.models;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "Must include a photo path.")
    private String photoPath;

    private String caption;

    @OneToMany
    private List<Account> likeList;

    public Photo() {
    }

    public Photo(String photoPath) {
        this.photoPath = photoPath;
    }

    public Photo(String photoPath, String caption) {
        this.photoPath = photoPath;
        this.caption = caption;
    }

    public Photo(String photoPath, String caption, List<Account> likeList) {
        this.photoPath = photoPath;
        this.caption = caption;
        this.likeList = likeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<Account> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Account> likeList) {
        this.likeList = likeList;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", photoPath='" + photoPath + '\'' +
                ", caption='" + caption + '\'' +
                ", likeList=" + likeList +
                '}';
    }
}
