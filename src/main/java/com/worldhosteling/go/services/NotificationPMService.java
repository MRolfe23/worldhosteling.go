package com.worldhosteling.go.services;

import com.worldhosteling.go.models.NotificationPM;

import java.util.List;
import java.util.Optional;

public interface NotificationPMService {

    NotificationPM saveNotificationPM(NotificationPM notificationPM);

    Optional<NotificationPM> findNotificationPMById(Integer id);

    List<NotificationPM> findAllNotificationPM();

    List<NotificationPM> findAllNotificationPMByGroupChatId(Integer id);

    void deleteNotificationPM(NotificationPM notificationPM);

}
