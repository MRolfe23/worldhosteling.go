package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.Account;
import com.worldhosteling.go.models.NotificationPost;
import com.worldhosteling.go.repositories.NotificationPostRepository;
import com.worldhosteling.go.services.NotificationPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationPostServiceImpl implements NotificationPostService {

    private final NotificationPostRepository notificationPostRepository;

    NotificationPostServiceImpl(NotificationPostRepository notificationPostRepository) {
        this.notificationPostRepository = notificationPostRepository;
    }

    @Override
    public List<NotificationPost> findAllNotificationPost() {
        return (List<NotificationPost>) notificationPostRepository.findAll();
    }

    @Override
    public NotificationPost saveNotificationPost(NotificationPost notificationPost) {
        return notificationPostRepository.save(notificationPost);
    }

    @Override
    public NotificationPost findNotificationPostById(Integer id) {
        return notificationPostRepository.findById(id).orElse(null);
    }

    @Override
    public List<NotificationPost> findNotificationPostByTo(Account account) {
        return notificationPostRepository.findAllNotificationPostByFrom(account);
    }

    @Override
    public List<NotificationPost> findNotificationPostByFrom(Account account) {
        return notificationPostRepository.findAllNotificationPostByTo(account);
    }

    @Override
    public List<NotificationPost> findNotificationPostByIsSeen(boolean bool) {
        return notificationPostRepository.findAllByIsSeen(bool);
    }

    @Override
    public void deleteNotificationPost(Integer id) {
        notificationPostRepository.deleteById(id);
    }

}
