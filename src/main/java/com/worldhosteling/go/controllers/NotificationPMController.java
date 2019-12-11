package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.NotificationPM;
import com.worldhosteling.go.services.NotificationPMService;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification_pm")
public class NotificationPMController {
    // TODO: COME BACK TO SET RETRIEVE TO SPECIFICS
    private final Logger logger = LoggerFactory.getLogger(NotificationPMController.class);

    private NotificationPMService notificationPMService;

    public NotificationPMController() {

    }

    public NotificationPMController(NotificationPMService notificationPMService) {
        this.notificationPMService = notificationPMService;
    }

    @GetMapping("/")
    public List<NotificationPM> getAllNotificationPM() {
        return notificationPMService.findAllNotificationPM();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationPM> getNotificationPMById(@PathVariable Integer id) {
        NotificationPM foundNotificationPM = notificationPMService.findNotificationPMById(id);
        if (foundNotificationPM == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundNotificationPM);
    }

    @PostMapping("/")
    public NotificationPM saveNotificationPM(@RequestBody NotificationPM notificationPM) {
        return notificationPMService.saveNotificationPM(notificationPM);
    }

    @PostMapping("/{id}")
    public void deleteNotificationPMById(@PathVariable Integer id) {
        notificationPMService.deleteNotificationPM(id);
    }

}
