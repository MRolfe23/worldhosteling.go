package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.PrivateMessage;
import com.worldhosteling.go.repository.PrivateMessageRepository;
import com.worldhosteling.go.service.PrivateMessageService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

    private final PrivateMessageRepository privateMessageRepository;

    PrivateMessageServiceImpl(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    @Override
    public PrivateMessage savePrivateMessage(PrivateMessage privateMessage) {
        return privateMessageRepository.save(privateMessage);
    }

    @Override
    public Optional<PrivateMessage> findPrivateMessageById(Integer id) {
        return privateMessageRepository.findById(id);
    }

    @Override
    public void deletePrivateMessage(PrivateMessage privateMessage) {
        privateMessageRepository.delete(privateMessage);
    }
}
