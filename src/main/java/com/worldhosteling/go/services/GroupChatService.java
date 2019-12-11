package com.worldhosteling.go.services;

import com.worldhosteling.go.models.GroupChat;

import java.util.List;
import java.util.Optional;

public interface GroupChatService {

    GroupChat saveGroupChat(GroupChat groupChat);

    GroupChat findGroupChatById(Integer id);

    List<GroupChat> findAllGroupChats();

    void deleteGroupChat(Integer id);

//    List<GroupChat> findGroupChatByAccountFirstNameOrLastName(String name);

}
