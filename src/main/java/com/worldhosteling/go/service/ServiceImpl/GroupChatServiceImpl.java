package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.GroupChat;
import com.worldhosteling.go.repository.GroupChatRepository;
import com.worldhosteling.go.service.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<GroupChat> findGroupChatById(Integer id) {
        return groupChatRepository.findById(id);
    }

    @Override
    public List<GroupChat> findAllGroupChats() {
        return (List<GroupChat>) groupChatRepository.findAll();
    }

    @Override
    public void deleteGroupChat(GroupChat groupChat) {
        groupChatRepository.delete(groupChat);
    }

}
