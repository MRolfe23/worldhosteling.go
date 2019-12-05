package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
