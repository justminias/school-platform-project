package com.example.school.converter;

import com.example.school.entity.Subject;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class ListOfSubjectsToStringConverter implements AttributeConverter<List<Subject>, String> {

    @Override
    public String convertToDatabaseColumn(List<Subject> subjects) {

        List<String> convertedSubjects = subjects.stream()
                .map(Subject::name)
                .collect(Collectors.toList());

        return subjects == null ? null : String.join(",", convertedSubjects);
    }

    @Override
    public List<Subject> convertToEntityAttribute(String dbData) {

        List<Subject> convertedSubjects = Arrays.stream(dbData.split(","))
                .map(Subject::valueOf)
                .collect(Collectors.toList());

        return dbData == null ? Collections.emptyList() : convertedSubjects;
    }
}
