package com.worldhosteling.go.controllers;

import com.worldhosteling.go.models.GroupChat;
import com.worldhosteling.go.services.GroupChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group_chat")
public class GroupChatController {

    private final Logger logger = LoggerFactory.getLogger(GroupChatController.class);

    private GroupChatService groupChatService;

    public GroupChatController() {}

    public GroupChatController(GroupChatService groupChatService) {
        this.groupChatService = groupChatService;
    }

    @GetMapping("/")
    public List<GroupChat> getAllGroupChats() {
        return groupChatService.findAllGroupChats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupChat> getGroupChatById(@PathVariable Integer id) {
        GroupChat foundGroupChat = groupChatService.findGroupChatById(id);
        if (foundGroupChat == null) {
            logger.error("GroupChat with id: " + id + " was not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok().body(foundGroupChat);
    }

    @PostMapping("/")
    public GroupChat saveGroupChat(@RequestBody GroupChat groupChat) {
        return groupChatService.saveGroupChat(groupChat);
    }

    @PostMapping("/{id}")
    public  void deleteGroupChatById(@PathVariable Integer id) {
        groupChatService.deleteGroupChat(id);
    }
}
