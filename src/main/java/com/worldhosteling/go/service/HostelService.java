package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Hostel;

import java.util.List;
import java.util.Optional;

public interface HostelService {

    Hostel saveHostel(Hostel hostel);

    Optional<Hostel> findHostelById(String id);

    List<Hostel> findHostelsByName(String name);

    List<Hostel> findAllHostelsByCountry(String country);

    List<Hostel> findAllHostelsByCity(String city);

    List<Hostel> findAllHostelsByRegion(String region);

    List<Hostel> findAllHostelsByPrice(double price);

    List<Hostel> findAllHostelsByRating(Integer rating);

    void deleteHostel(Hostel hostel);

}
