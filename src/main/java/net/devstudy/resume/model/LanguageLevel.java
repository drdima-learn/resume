package net.devstudy.resume.model;

import org.apache.commons.lang.WordUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Transient;

public enum LanguageLevel {

    BEGINNER,

    ELEMENTARY,

    PRE_INTERMEDIATE,

    INTERMEDIATE,

    UPPER_INTERMEDIATE,

    ADVANCED,

    PROFICIENCY;

    public String getDbValue(){
        return name().toLowerCase();
    }

    public String getPrettyFormat(){
        String s = name().toLowerCase();
        if (s.contains("_")){
            String parts[] = s.split("_");
            return WordUtils.capitalize(parts[0]) + "-" + WordUtils.capitalize(parts[1]);
        }
        return WordUtils.capitalize(s);

    }

    @Convert
    public static class PersistJPAConverter implements AttributeConverter<LanguageLevel, String> {

        @Override
        public String convertToDatabaseColumn(LanguageLevel attribute) {
            return attribute.getDbValue();
        }

        @Override
        public LanguageLevel convertToEntityAttribute(String dbValue) {
            return LanguageLevel.valueOf(dbValue.toUpperCase());
        }
    }
}
