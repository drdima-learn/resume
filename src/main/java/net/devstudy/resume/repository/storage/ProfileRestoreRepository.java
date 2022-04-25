package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.jpa.ProfileRestore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Integer> {

    ProfileRestore findByToken(String token);
}
