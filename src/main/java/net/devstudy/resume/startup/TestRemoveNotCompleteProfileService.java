package net.devstudy.resume.startup;

import net.devstudy.resume.service.RemoveNotCompleteProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRemoveNotCompleteProfileService implements CommandLineRunner {


    @Autowired
    private RemoveNotCompleteProfileService removeNotCompleteProfileService;

    @Override
    public void run(String... args) throws Exception {
        //removeNotCompleteProfileService.removeNotCompleteProfiles();
    }
}
