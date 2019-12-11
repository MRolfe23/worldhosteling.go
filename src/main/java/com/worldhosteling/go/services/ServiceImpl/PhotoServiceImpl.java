package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Photo;
import com.worldhosteling.go.repositories.PhotoRepository;
import com.worldhosteling.go.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo findPhotoById(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Photo> findAllPhotos() {
        return (List<Photo>) photoRepository.findAll();
    }

    @Override
    public void deletePhoto(Integer id) {
        photoRepository.deleteById(id);
    }
}