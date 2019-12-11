package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Hostel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HostelRepository extends CrudRepository<Hostel, String> {

    List<Hostel> findAllByNameLike(String name);

    List<Hostel> findAllByCountryLike(String country);

    List<Hostel> findAllByCityLike(String city);

    List<Hostel> findAllByRegionLike(String region);

    List<Hostel> findAllByPriceLike(double price);

    List<Hostel> findAllByRatingLike(Integer rating);

    void deleteHostelById(String id);

}
