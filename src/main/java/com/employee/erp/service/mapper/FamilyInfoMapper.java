package com.employee.erp.service.mapper;

import com.employee.erp.domain.FamilyInfo;
import com.employee.erp.service.dto.FamilyInfoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FamilyInfo} and its DTO {@link FamilyInfoDTO}.
 */
@Mapper(componentModel = "spring")
public interface FamilyInfoMapper extends EntityMapper<FamilyInfoDTO, FamilyInfo> {}
