package com.worldhosteling.go.services;

import com.worldhosteling.go.models.PrivateMessage;

import java.util.List;
import java.util.Optional;

public interface PrivateMessageService {

    PrivateMessage savePrivateMessage(PrivateMessage privateMessage);

    List<PrivateMessage> findAllPrivateMessages();

    PrivateMessage findPrivateMessageById(Integer id);

    void deletePrivateMessage(Integer id);

}
