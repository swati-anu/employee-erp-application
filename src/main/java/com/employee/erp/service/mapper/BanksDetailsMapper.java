package com.employee.erp.service.mapper;

import com.employee.erp.domain.BanksDetails;
import com.employee.erp.service.dto.BanksDetailsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BanksDetails} and its DTO {@link BanksDetailsDTO}.
 */
@Mapper(componentModel = "spring")
public interface BanksDetailsMapper extends EntityMapper<BanksDetailsDTO, BanksDetails> {}
