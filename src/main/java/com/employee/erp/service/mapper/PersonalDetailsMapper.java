package com.employee.erp.service.mapper;

import com.employee.erp.domain.PersonalDetails;
import com.employee.erp.service.dto.PersonalDetailsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PersonalDetails} and its DTO {@link PersonalDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper extends EntityMapper<PersonalDetailsDTO, PersonalDetails> {}
