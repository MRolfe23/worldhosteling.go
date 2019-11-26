package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Photo;
import com.worldhosteling.go.repository.PhotoRepository;
import com.worldhosteling.go.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return null;
    }

    @Override
    public Photo findPhotoById(Integer id) {
        return null;
    }

    @Override
    public List<Photo> findAllPhotos() {
        return null;
    }

    @Override
    public void deletePhoto(Integer id) {

    }

    @Override
    public Photo findPhotoByMostLikes() {
        return null;
    }
}
