package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
