package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.GroupChat;
import com.worldhosteling.go.repositories.GroupChatRepository;
import com.worldhosteling.go.services.GroupChatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupChatServiceImpl implements GroupChatService {

    private final GroupChatRepository groupChatRepository;

    GroupChatServiceImpl(GroupChatRepository groupChatRepository) {
        this.groupChatRepository = groupChatRepository;
    }

    @Override
    public GroupChat saveGroupChat(GroupChat groupChat) {
        return groupChatRepository.save(groupChat);
    }

    @Override
    public GroupChat findGroupChatById(Integer id) {
        return groupChatRepository.findById(id).orElse(null);
    }

    @Override
    public List<GroupChat> findAllGroupChats() {
        return (List<GroupChat>) groupChatRepository.findAll();
    }

    @Override
    public void deleteGroupChat(Integer id) {
        groupChatRepository.deleteById(id);
    }

}
