package com.worldhosteling.go.services.ServiceImpl;

import com.worldhosteling.go.models.NotificationPM;
import com.worldhosteling.go.repositories.NotificationPMRepository;
import com.worldhosteling.go.services.NotificationPMService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationPMServiceImpl implements NotificationPMService {

    private NotificationPMRepository notificationPMRepository;

    NotificationPMServiceImpl(NotificationPMRepository notificationPMRepository) {
        this.notificationPMRepository = notificationPMRepository;
    }

    @Override
    public NotificationPM saveNotificationPM(NotificationPM notificationPM) {
        return notificationPMRepository.save(notificationPM);
    }

    @Override
    public Optional<NotificationPM> findNotificationPMById(Integer id) {
        return notificationPMRepository.findById(id);
    }

    @Override
    public List<NotificationPM> findAllNotificationPM() {
        return (List<NotificationPM>) notificationPMRepository.findAll();
    }

    @Override
    public List<NotificationPM> findAllNotificationPMByGroupChatId(Integer id) {
        return null;
    }

    @Override
    public void deleteNotificationPM(NotificationPM notificationPM) {
        notificationPMRepository.delete(notificationPM);
    }
}
