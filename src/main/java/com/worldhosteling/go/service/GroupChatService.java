package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.GroupChat;

import java.util.List;
import java.util.Optional;

public interface GroupChatService {

    GroupChat saveGroupChat(GroupChat groupChat);

    Optional<GroupChat> findGroupChatById(Integer id);

    List<GroupChat> findAllGroupChats();

    void deleteGroupChat(GroupChat groupChat);

//    List<GroupChat> findGroupChatByAccountFirstNameOrLastName(String name);

}
