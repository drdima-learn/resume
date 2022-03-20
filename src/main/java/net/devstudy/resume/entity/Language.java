package net.devstudy.resume.entity;

import lombok.Data;
import net.devstudy.resume.model.LanguageLevel;
import net.devstudy.resume.model.LanguageType;

import javax.persistence.*;

@Data
@Entity
public class Language extends AbstractEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", length = 18, nullable = false)
    @Convert(converter = LanguageLevel.PersistJPAConverter.class)
    private LanguageLevel level;

    @Column(name = "type", length = 7, nullable = false)
    @Convert(converter = LanguageType.PersistJPAConverter.class)
    private LanguageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    private Profile profile;

    public String getLevelPretty() {
        return level.getPrettyFormat();
    }
}
