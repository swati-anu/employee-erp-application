package com.employee.erp.service.mapper;

import com.employee.erp.domain.Designation;
import com.employee.erp.service.dto.DesignationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Designation} and its DTO {@link DesignationDTO}.
 */
@Mapper(componentModel = "spring")
public interface DesignationMapper extends EntityMapper<DesignationDTO, Designation> {}
