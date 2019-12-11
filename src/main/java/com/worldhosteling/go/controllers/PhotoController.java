package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Photo;
import com.worldhosteling.go.services.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    private final Logger logger = LoggerFactory.getLogger(PhotoController.class);

    private PhotoService photoService;

    public PhotoController() {}

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public List<Photo> findAllPhotos() {
        return photoService.findAllPhotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> findPhotoById(@PathVariable Integer id) {
        Photo foundPhoto = photoService.findPhotoById(id);
        if (foundPhoto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundPhoto);
    }

    @PostMapping("/")
    public Photo savePhoto(@RequestBody Photo photo) {
        return photoService.savePhoto(photo);
    }

    @PostMapping("/{id}")
    public void deletePhotoById(@PathVariable Integer id) {
        photoService.deletePhoto(id);
    }

}
