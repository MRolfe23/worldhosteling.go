package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Photo;

import java.util.Optional;

public interface PhotoService {

    Photo savePhoto(Photo photo);

    Optional<Photo> findPhotoById(Integer id);

    void deletePhoto(Photo photo);

}
