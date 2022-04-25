package net.devstudy.resume.service;

import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RemoveNotCompleteProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Value("${remove.not.completed.profiles.days.interval}")
    private int removeNotCompletedProfilesDaysInterval;


    @Transactional
    @Scheduled(cron = "0 59 23 * * *" )
    public void removeNotCompleteProfiles() {
        LocalDate date = LocalDate.now();
        date = date.minusDays(removeNotCompletedProfilesDaysInterval);
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        List<Profile> profileList = profileRepository.findByCompletedFalseAndCreatedBefore(timestamp);
        for (Profile profile : profileList) {
            profileRepository.delete(profile);
        }
    }
}
