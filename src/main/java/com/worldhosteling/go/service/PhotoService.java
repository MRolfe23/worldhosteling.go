package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Photo;

import java.util.List;

public interface PhotoService {

    Photo savePhoto(Photo photo);

    Photo findPhotoById(Integer id);

    List<Photo> findAllPhotos();

    Photo findPhotoByMostLikes();

    void deletePhoto(Integer id);

}
