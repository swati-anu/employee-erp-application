package com.employee.erp.service.mapper;

import com.employee.erp.domain.WorkExperience;
import com.employee.erp.service.dto.WorkExperienceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link WorkExperience} and its DTO {@link WorkExperienceDTO}.
 */
@Mapper(componentModel = "spring")
public interface WorkExperienceMapper extends EntityMapper<WorkExperienceDTO, WorkExperience> {}
