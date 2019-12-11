package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {

    Photo savePhoto(Photo photo);

    Photo findPhotoById(Integer id);

    List<Photo> findAllPhotos();

    void deletePhoto(Integer id);

}
