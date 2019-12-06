package com.worldhosteling.go.controllers;

import com.worldhosteling.go.services.HostelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hostel")
public class HostelController {

    private HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

}
