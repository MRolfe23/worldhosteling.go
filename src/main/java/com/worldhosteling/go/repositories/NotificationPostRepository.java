package com.worldhosteling.go.repositories;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.NotificationPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationPostRepository extends CrudRepository<NotificationPost, Integer> {

    List<NotificationPost> findAllNotificationPostByFrom(Account account);

    List<NotificationPost> findAllNotificationPostByTo(Account account);
    List<NotificationPost> findAllByIsSeen(boolean bool);
}
