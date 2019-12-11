package com.worldhosteling.go.services;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.NotificationPost;

import java.util.List;
import java.util.Optional;


public interface NotificationPostService {

    List<NotificationPost> findAllNotificationPost();

    NotificationPost saveNotificationPost(NotificationPost notificationPost);

    NotificationPost findNotificationPostById(Integer id);

    List<NotificationPost> findNotificationPostByTo(Account account);

    List<NotificationPost> findNotificationPostByFrom(Account account);

    List<NotificationPost> findNotificationPostByIsSeen(boolean bool);

    void deleteNotificationPost(Integer id);

}
