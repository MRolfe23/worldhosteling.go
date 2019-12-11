package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.NotificationPost;
import com.worldhosteling.go.services.NotificationPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification_post")
public class NotificationPostController {

    private final Logger logger = LoggerFactory.getLogger(NotificationPMController.class);

    private NotificationPostService notificationPostService;

    public NotificationPostController() {}

    public NotificationPostController(NotificationPostService notificationPostService) {
        this.notificationPostService = notificationPostService;
    }

    @GetMapping("/")
    public List<NotificationPost> getAllNotificationPost() {
        return notificationPostService.findAllNotificationPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationPost> getNotificationPostById(@PathVariable Integer id) {
        NotificationPost foundNotificationPost = notificationPostService.findNotificationPostById(id);
        if (foundNotificationPost == null) {
            logger.error("Notification Post with id: " + id + " not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundNotificationPost);
    }

    @GetMapping("/to/{account}")
    public List<NotificationPost> getAllNotificationPostTo(@PathVariable Account account) {
        return notificationPostService.findNotificationPostByTo(account);
    }

    @GetMapping("/from/{account}")
    public List<NotificationPost> getAllNotificationPostFrom(@PathVariable Account account) {
        return notificationPostService.findNotificationPostByFrom(account);
    }

    @GetMapping("/is_seen/{bool}")
    public List<NotificationPost> getAllNotificationPostByIsSeen(@PathVariable boolean bool) {
        return notificationPostService.findNotificationPostByIsSeen(bool);
    }

    @PostMapping("/")
    public NotificationPost saveNotificationPost(@RequestBody NotificationPost notificationPost) {
        return notificationPostService.saveNotificationPost(notificationPost);
    }

    @PostMapping("/{id}")
    public void deleteNotificationPostById(@PathVariable Integer id) {
        notificationPostService.deleteNotificationPost(id);
    }

}
