package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.PrivateMessage;
import com.worldhosteling.go.repositories.PrivateMessageRepository;
import com.worldhosteling.go.services.PrivateMessageService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<PrivateMessage> findAllPrivateMessages() {
        return (List<PrivateMessage>) privateMessageRepository.findAll();
    }

    @Override
    public PrivateMessage findPrivateMessageById(Integer id) {
        return privateMessageRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePrivateMessage(Integer id) {
        privateMessageRepository.deleteById(id);
    }
}
