package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Photo;

import java.util.Optional;

public interface PhotoService {

    Photo savePhoto(Photo photo);

    Optional<Photo> findPhotoById(Integer id);

    void deletePhoto(Photo photo);

}
