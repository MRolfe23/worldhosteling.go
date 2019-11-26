package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.NotificationPost;

import java.util.List;
import java.util.Optional;


public interface NotificationPostService {

    NotificationPost saveNotificationPost(NotificationPost notificationPost);

    Optional<NotificationPost> findNotificationPostById(Integer id);

    List<NotificationPost> findNotificationPostByTo(Account account);

    List<NotificationPost> findNotificationPostByFrom(Account account);

    List<NotificationPost> findNotificationPostByIsSeen(boolean bool);

    void deleteNotificationPost(NotificationPost notificationPost);

}
