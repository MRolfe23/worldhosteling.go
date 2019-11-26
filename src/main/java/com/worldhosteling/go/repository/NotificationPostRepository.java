package com.worldhosteling.go.repository;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.NotificationPost;
import com.worldhosteling.go.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;

import java.util.List;

public interface NotificationPostRepository extends CrudRepository<NotificationPost, Integer> {

    List<NotificationPost> findAllNotificationPostByFrom(Account account);

    List<NotificationPost> findAllNotificationPostByTo(Account account);
    List<NotificationPost> findAllByIsSeen(boolean bool);
}
