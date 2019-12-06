package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Hostel;
import com.worldhosteling.go.repositories.HostelRepository;
import com.worldhosteling.go.services.HostelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelServiceImpl implements HostelService {

    private HostelRepository hostelRepository;

    HostelServiceImpl(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    @Override
    public Hostel saveHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    @Override
    public Optional<Hostel> findHostelById(String id) {
        return hostelRepository.findById(id);
    }

    @Override
    public List<Hostel> findHostelsByName(String name) {
        return hostelRepository.findAllByNameLike(name);
    }

    @Override
    public List<Hostel> findAllHostelsByCountry(String country) {
        return hostelRepository.findAllByCountryLike(country);
    }

    @Override
    public List<Hostel> findAllHostelsByCity(String city) {
        return hostelRepository.findAllByCityLike(city);
    }

    @Override
    public List<Hostel> findAllHostelsByRegion(String region) {
        return hostelRepository.findAllByRegionLike(region);
    }

    @Override
    public List<Hostel> findAllHostelsByPrice(double price) {
        return hostelRepository.findAllByPriceLike(price);
    }

    @Override
    public List<Hostel> findAllHostelsByRating(Integer rating) {
        return hostelRepository.findAllByRatingLike(rating);
    }

    @Override
    public void deleteHostel(Hostel hostel) {
        hostelRepository.delete(hostel);
    }

}
