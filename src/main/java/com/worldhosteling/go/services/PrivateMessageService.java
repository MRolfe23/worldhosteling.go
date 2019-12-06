package com.worldhosteling.go.services;

import com.worldhosteling.go.models.PrivateMessage;

import java.util.Optional;

public interface PrivateMessageService {

    PrivateMessage savePrivateMessage(PrivateMessage privateMessage);

    Optional<PrivateMessage> findPrivateMessageById(Integer id);

    void deletePrivateMessage(PrivateMessage privateMessage);

}
