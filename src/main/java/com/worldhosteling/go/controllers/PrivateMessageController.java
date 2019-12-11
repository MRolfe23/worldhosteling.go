package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.PrivateMessage;
import com.worldhosteling.go.services.PrivateMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification_post")
public class PrivateMessageController {

    private final Logger logger = LoggerFactory.getLogger(PrivateMessageController.class);

    private PrivateMessageService privateMessageService;

    public PrivateMessageController() {}

    public PrivateMessageController(PrivateMessageService privateMessageService) {
        this.privateMessageService = privateMessageService;
    }

    @GetMapping("/")
    public List<PrivateMessage> getAllPrivateMessages() {
        return privateMessageService.findAllPrivateMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrivateMessage> getPrivateMessageById(@PathVariable Integer id) {
        PrivateMessage foundPrivateMessage = privateMessageService.findPrivateMessageById(id);
        if (foundPrivateMessage == null) {
            logger.error("Private message with id: " + id + " was not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundPrivateMessage);
    }

    @PostMapping("/")
    public PrivateMessage savePrivateMessage(PrivateMessage privateMessage) {
        return privateMessageService.savePrivateMessage(privateMessage);
    }

    @PostMapping("/{id}")
    public void deletePrivateMessage(@PathVariable Integer id) {
        privateMessageService.deletePrivateMessage(id);
    }

}
