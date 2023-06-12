package com.employee.erp.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.employee.erp.domain.Employee} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class EmployeeDTO implements Serializable {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    @NotNull
    private String empUniqueId;

    private Instant joindate;

    private String status;

    private String emailId;

    private Long employmentTypeId;

    private Long reportingEmpId;

    private Long companyId;

    private Instant lastModified;

    private String lastModifiedBy;

    private DesignationDTO designation;

    private DepartmentDTO department;

    private PersonalDetailsDTO personaldetails;

    private AddressDTO address;

    private ContactsDTO contacts;

    private BanksDetailsDTO bankdetails;

    private FamilyInfoDTO familyinfo;

    private WorkExperienceDTO workexperience;

    private EducationDTO education;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmpUniqueId() {
        return empUniqueId;
    }

    public void setEmpUniqueId(String empUniqueId) {
        this.empUniqueId = empUniqueId;
    }

    public Instant getJoindate() {
        return joindate;
    }

    public void setJoindate(Instant joindate) {
        this.joindate = joindate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getEmploymentTypeId() {
        return employmentTypeId;
    }

    public void setEmploymentTypeId(Long employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
    }

    public Long getReportingEmpId() {
        return reportingEmpId;
    }

    public void setReportingEmpId(Long reportingEmpId) {
        this.reportingEmpId = reportingEmpId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public DesignationDTO getDesignation() {
        return designation;
    }

    public void setDesignation(DesignationDTO designation) {
        this.designation = designation;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public PersonalDetailsDTO getPersonaldetails() {
        return personaldetails;
    }

    public void setPersonaldetails(PersonalDetailsDTO personaldetails) {
        this.personaldetails = personaldetails;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ContactsDTO getContacts() {
        return contacts;
    }

    public void setContacts(ContactsDTO contacts) {
        this.contacts = contacts;
    }

    public BanksDetailsDTO getBankdetails() {
        return bankdetails;
    }

    public void setBankdetails(BanksDetailsDTO bankdetails) {
        this.bankdetails = bankdetails;
    }

    public FamilyInfoDTO getFamilyinfo() {
        return familyinfo;
    }

    public void setFamilyinfo(FamilyInfoDTO familyinfo) {
        this.familyinfo = familyinfo;
    }

    public WorkExperienceDTO getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(WorkExperienceDTO workexperience) {
        this.workexperience = workexperience;
    }

    public EducationDTO getEducation() {
        return education;
    }

    public void setEducation(EducationDTO education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeDTO)) {
            return false;
        }

        EmployeeDTO employeeDTO = (EmployeeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, employeeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeDTO{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", gender='" + getGender() + "'" +
            ", empUniqueId='" + getEmpUniqueId() + "'" +
            ", joindate='" + getJoindate() + "'" +
            ", status='" + getStatus() + "'" +
            ", emailId='" + getEmailId() + "'" +
            ", employmentTypeId=" + getEmploymentTypeId() +
            ", reportingEmpId=" + getReportingEmpId() +
            ", companyId=" + getCompanyId() +
            ", lastModified='" + getLastModified() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", designation=" + getDesignation() +
            ", department=" + getDepartment() +
            ", personaldetails=" + getPersonaldetails() +
            ", address=" + getAddress() +
            ", contacts=" + getContacts() +
            ", bankdetails=" + getBankdetails() +
            ", familyinfo=" + getFamilyinfo() +
            ", workexperience=" + getWorkexperience() +
            ", education=" + getEducation() +
            "}";
    }
}
