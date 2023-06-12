package com.employee.erp.service.mapper;

import com.employee.erp.domain.Address;
import com.employee.erp.domain.BanksDetails;
import com.employee.erp.domain.Contacts;
import com.employee.erp.domain.Department;
import com.employee.erp.domain.Designation;
import com.employee.erp.domain.Education;
import com.employee.erp.domain.Employee;
import com.employee.erp.domain.FamilyInfo;
import com.employee.erp.domain.PersonalDetails;
import com.employee.erp.domain.WorkExperience;
import com.employee.erp.service.dto.AddressDTO;
import com.employee.erp.service.dto.BanksDetailsDTO;
import com.employee.erp.service.dto.ContactsDTO;
import com.employee.erp.service.dto.DepartmentDTO;
import com.employee.erp.service.dto.DesignationDTO;
import com.employee.erp.service.dto.EducationDTO;
import com.employee.erp.service.dto.EmployeeDTO;
import com.employee.erp.service.dto.FamilyInfoDTO;
import com.employee.erp.service.dto.PersonalDetailsDTO;
import com.employee.erp.service.dto.WorkExperienceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {
    @Mapping(target = "designation", source = "designation", qualifiedByName = "designationName")
    @Mapping(target = "department", source = "department", qualifiedByName = "departmentName")
    @Mapping(target = "personaldetails", source = "personaldetails", qualifiedByName = "personalDetailsId")
    @Mapping(target = "address", source = "address", qualifiedByName = "addressId")
    @Mapping(target = "contacts", source = "contacts", qualifiedByName = "contactsId")
    @Mapping(target = "bankdetails", source = "bankdetails", qualifiedByName = "banksDetailsId")
    @Mapping(target = "familyinfo", source = "familyinfo", qualifiedByName = "familyInfoId")
    @Mapping(target = "workexperience", source = "workexperience", qualifiedByName = "workExperienceId")
    @Mapping(target = "education", source = "education", qualifiedByName = "educationId")
    EmployeeDTO toDto(Employee s);

    @Named("designationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DesignationDTO toDtoDesignationName(Designation designation);

    @Named("departmentName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DepartmentDTO toDtoDepartmentName(Department department);

    @Named("personalDetailsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PersonalDetailsDTO toDtoPersonalDetailsId(PersonalDetails personalDetails);

    @Named("addressId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AddressDTO toDtoAddressId(Address address);

    @Named("contactsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ContactsDTO toDtoContactsId(Contacts contacts);

    @Named("banksDetailsId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BanksDetailsDTO toDtoBanksDetailsId(BanksDetails banksDetails);

    @Named("familyInfoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FamilyInfoDTO toDtoFamilyInfoId(FamilyInfo familyInfo);

    @Named("workExperienceId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    WorkExperienceDTO toDtoWorkExperienceId(WorkExperience workExperience);

    @Named("educationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EducationDTO toDtoEducationId(Education education);
}
