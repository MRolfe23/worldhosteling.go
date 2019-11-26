package com.worldhosteling.go.service;

import com.worldhosteling.go.domain.NotificationPM;

import java.util.List;
import java.util.Optional;

public interface NotificationPMService {

    NotificationPM saveNotificationPM(NotificationPM notificationPM);

    Optional<NotificationPM> findNotificationPMById(Integer id);

    List<NotificationPM> findAllNotificationPM();

    List<NotificationPM> findAllNotificationPMByGroupChatId(Integer id);

    void deleteNotificationPM(NotificationPM notificationPM);

}
