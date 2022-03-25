package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.form.SignUpForm;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import net.devstudy.resume.util.DataUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EditProfileService extends AbstractService {

    @Autowired
    ProfileRepository profileRepository;

    @Value("${generate.uid.max.try.count}")
    int maxTryCountGenerateUid;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Transactional
    public Profile createNewProfile(SignUpForm signUpForm) {
        Profile profile = new Profile();
        profile.setUid(generateProfileUid(signUpForm));
        profile.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
        profile.setLastName(DataUtil.capitalizeName(signUpForm.getLastName()));
        profile.setPassword(signUpForm.getPassword());
        profile.setCompleted(false);
        profile = profileRepository.save(profile);
        return profile;
    }

    private String generateProfileUid(SignUpForm signUpForm) {
        String baseUid = DataUtil.generateProfileUid(signUpForm);
        String uid = baseUid;
        for (int i = 0; profileRepository.countByUid(uid) > 0; i++) {
            if (i == maxTryCountGenerateUid) {
                throw new CantCompleteClientRequestException(
                        "Can't generate unique uid for profile " + baseUid + ": maxTryCountGenerateUid detected"
                );
            }
            uid = DataUtil.addSuffix(baseUid);

        }
        return uid;
    }


    public List<Skill> getSkills(int idProfile) {
        List<Skill> skillList = profileRepository.findById(idProfile).getSkills();
        return skillList;
    }

    public List<SkillCategory> getSkillCategoryList() {
        List<SkillCategory> skillCategoryList = skillCategoryRepository.findAll(Sort.by("id"));
        return skillCategoryList;
    }

    @Transactional
    public void updateSkills(int idProfile, List<Skill> updateData) {
        Profile profile = profileRepository.findById(idProfile);
        if (CollectionUtils.isEqualCollection(updateData, profile.getSkills())) {
            LOGGER.debug("Profile skills: nothing to update");
            return;
        } else {
            profile.setSkills(updateData);
            profileRepository.save(profile);
        }

    }
}
