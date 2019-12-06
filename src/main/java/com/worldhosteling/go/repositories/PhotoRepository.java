package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
