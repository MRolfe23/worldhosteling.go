package com.worldhosteling.go.services;

import com.worldhosteling.go.models.GroupChat;

import java.util.List;
import java.util.Optional;

public interface GroupChatService {

    GroupChat saveGroupChat(GroupChat groupChat);

    Optional<GroupChat> findGroupChatById(Integer id);

    List<GroupChat> findAllGroupChats();

    void deleteGroupChat(GroupChat groupChat);

//    List<GroupChat> findGroupChatByAccountFirstNameOrLastName(String name);

}
