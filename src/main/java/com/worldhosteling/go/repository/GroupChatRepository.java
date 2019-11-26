package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.GroupChat;
import org.springframework.data.repository.CrudRepository;

public interface GroupChatRepository extends CrudRepository<GroupChat, Integer> {

    void delete(GroupChat id);

}