package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Hostel;
import com.worldhosteling.go.services.HostelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hostel")
public class HostelController {

    //TODO: need to work in the HTTP headers

    private HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping("/")
    public List<Hostel> findAllHostels() {
        return hostelService.findAllHostels();
    }

    @GetMapping("/city/{city}")
    public List<Hostel> findAllHostelsByCity(@PathVariable String city) {
        return hostelService.findAllHostelsByCity(city);
    }

    @GetMapping("/region/{region}")
    public List<Hostel> findAllHostelsByRegion(@PathVariable String region) {
        return hostelService.findAllHostelsByRegion(region);
    }

    @GetMapping("/country/{country}")
    public List<Hostel> findAllHostelsByCountry(@PathVariable String country) {
        return hostelService.findAllHostelsByCountry(country);
    }

    @GetMapping("/price/{price}")
    public List<Hostel> findAllHostelsWithPriceLike(@PathVariable double price) {
        return hostelService.findAllHostelsByPrice(price);
    }

    @GetMapping("/rating/{rating}")
    public List<Hostel> findAllHostelsWithRatingLike(@PathVariable Integer rating) {
        return hostelService.findAllHostelsByRating(rating);
    }

    @GetMapping("/name/{name}")
    public List<Hostel> findAllHostelsWithNameLike(@PathVariable String name) {
        return hostelService.findHostelsByName(name);
    }

    @PostMapping("/")
    public Hostel saveHostel(@RequestBody Hostel hostel) {
        return hostelService.saveHostel(hostel);
    }

    @PostMapping("/{id}")
    public void deleteHostel(@PathVariable String id) {
        hostelService.deleteHostel(id);
    }

}