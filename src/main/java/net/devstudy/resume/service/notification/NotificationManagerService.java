package net.devstudy.resume.service.notification;

import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.model.NotificationMessage;
import net.devstudy.resume.service.AbstractService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationManagerService extends AbstractService {

    @Autowired
    private AsyncEmailNotificationSenderService notificationSenderService;

    @Autowired
    private NotificationTemplateService notificationTemplateService;

    public void sendRestoreAccessLink(Profile profile, String restoreLink){
        LOGGER.debug("Restore link: {} for account {}", restoreLink, profile.getUid());
        Map<String, Object> model = new HashMap<>();
        model.put("profile", profile);
        model.put("restoreLink", restoreLink);
        processNotification(profile, "restoreAccessNotification", model);

    }

    public void sendPasswordChanged(Profile profile){
        LOGGER.debug("Password changed for account {}", profile.getUid());
        Map<String, Object> model = new HashMap<>();
        model.put("profile", profile);
        processNotification(profile, "passwordChangedNotification", model);
    }

    private void processNotification(Profile profile, String templateName, Map<String, Object> model) {
        String destinationAddress = notificationSenderService.getDestinationAddress(profile);
        if (StringUtils.isNotBlank(destinationAddress)){
            NotificationMessage notificationMessage = notificationTemplateService.createNotificationMessage(templateName, model);
            notificationMessage.setDestinationAddress(destinationAddress);
            notificationMessage.setDestinationName(profile.getFullName());
            notificationSenderService.sendNotification(notificationMessage);
        } else {
            LOGGER.error("Notification ignored: destinationAddress is empty for profile" + profile.getUid());
        }
    }

}
