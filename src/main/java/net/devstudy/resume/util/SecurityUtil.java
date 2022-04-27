package net.devstudy.resume.util;

import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.model.CurrentProfile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public final class SecurityUtil {

    public static CurrentProfile getCurrentProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null){
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof CurrentProfile){
            return ((CurrentProfile) principal);
        } else {
            return null;
        }
    }


    public static Integer getCurrentIdProfile(){
        CurrentProfile currentProfile = getCurrentProfile();
        Integer id = currentProfile!=null ? currentProfile.getId() : null;
        return id;
    }

    public static void authentificate(Profile profile){
        CurrentProfile currentProfile = new CurrentProfile(profile);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                currentProfile
                ,currentProfile.getPassword()
                ,currentProfile.getAuthorities()
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public static boolean isCurrentProfileAuthentificated(){
        return getCurrentProfile() != null;
    }

    public static String generateNewActionUid(){
        return UUID.randomUUID().toString();
    }

    public static String generateNewRestoreAccessToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
