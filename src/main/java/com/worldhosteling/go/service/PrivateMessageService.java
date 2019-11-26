package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.PrivateMessage;

import java.util.Optional;

public interface PrivateMessageService {

    PrivateMessage savePrivateMessage(PrivateMessage privateMessage);

    Optional<PrivateMessage> findPrivateMessageById(Integer id);

    void deletePrivateMessage(PrivateMessage privateMessage);

}
