package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.jpa.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile, Integer> {

    Profile findById(int id);

    Profile findByUid(String uid);

    Profile findByEmail(String email);

    Profile findByPhone(String phone);

    int countByUid(String uid);

    Page<Profile> findAllByCompletedTrue(Pageable pageble);

    List<Profile> findByCompletedFalseAndCreatedBefore(Timestamp oldDate);
}
