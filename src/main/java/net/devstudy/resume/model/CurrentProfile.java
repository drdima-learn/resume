package net.devstudy.resume.model;

import lombok.Getter;
import lombok.ToString;
import net.devstudy.resume.Constants;
import net.devstudy.resume.entity.jpa.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
@ToString
public class CurrentProfile extends User {

    private final Integer id;
    private final String fullName;


    public CurrentProfile(Profile profile) {
        super(
                profile.getUid()
                , profile.getPassword()
                , true
                , true
                , true
                , true
                , Collections.singleton(new SimpleGrantedAuthority(Constants.USER))
        );
        this.id = profile.getId();
        this.fullName = profile.getFullName();

    }
}
