package com.example.school.converter;

import com.example.school.dto.Dto;

public interface Converter<DtoType extends Dto, EntityType> {

    EntityType convertToEntity(DtoType dtoType);
    DtoType convertToDto(EntityType entityType);
}
