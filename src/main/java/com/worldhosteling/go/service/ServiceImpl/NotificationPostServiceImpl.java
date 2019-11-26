package com.worldhosteling.go.service.ServiceImpl;

import com.worldhosteling.go.domain.Account;
import com.worldhosteling.go.domain.NotificationPost;
import com.worldhosteling.go.repository.NotificationPostRepository;
import com.worldhosteling.go.service.NotificationPostService;
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
    public NotificationPost saveNotificationPost(NotificationPost notificationPost) {
        return notificationPostRepository.save(notificationPost);
    }

    @Override
    public Optional<NotificationPost> findNotificationPostById(Integer id) {
        return notificationPostRepository.findById(id);
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
    public void deleteNotificationPost(NotificationPost notificationPost) {
        notificationPostRepository.delete(notificationPost);
    }
}
