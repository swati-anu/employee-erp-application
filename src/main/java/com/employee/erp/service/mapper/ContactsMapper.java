package com.employee.erp.service.mapper;

import com.employee.erp.domain.Contacts;
import com.employee.erp.service.dto.ContactsDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Contacts} and its DTO {@link ContactsDTO}.
 */
@Mapper(componentModel = "spring")
public interface ContactsMapper extends EntityMapper<ContactsDTO, Contacts> {}
