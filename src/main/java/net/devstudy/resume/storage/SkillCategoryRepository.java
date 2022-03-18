package net.devstudy.resume.storage;

import net.devstudy.resume.entity.SkillCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillCategoryRepository extends CrudRepository<SkillCategory, Integer> {
    List<SkillCategory> findAll(Sort sort);
}
