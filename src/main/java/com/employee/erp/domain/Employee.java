package com.employee.erp.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "emp_unique_id", nullable = false)
    private String empUniqueId;

    @Column(name = "joindate")
    private Instant joindate;

    @Column(name = "status")
    private String status;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "employment_type_id")
    private Long employmentTypeId;

    @Column(name = "reporting_emp_id")
    private Long reportingEmpId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "last_modified")
    private Instant lastModified;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @ManyToOne
    private Designation designation;

    @ManyToOne
    private Department department;

    @ManyToOne
    private PersonalDetails personaldetails;

    @ManyToOne
    private Address address;

    @ManyToOne
    private Contacts contacts;

    @ManyToOne
    private BanksDetails bankdetails;

    @ManyToOne
    private FamilyInfo familyinfo;

    @ManyToOne
    private WorkExperience workexperience;

    @ManyToOne
    private Education education;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Employee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Employee firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public Employee middleName(String middleName) {
        this.setMiddleName(middleName);
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Employee lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public Employee gender(String gender) {
        this.setGender(gender);
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmpUniqueId() {
        return this.empUniqueId;
    }

    public Employee empUniqueId(String empUniqueId) {
        this.setEmpUniqueId(empUniqueId);
        return this;
    }

    public void setEmpUniqueId(String empUniqueId) {
        this.empUniqueId = empUniqueId;
    }

    public Instant getJoindate() {
        return this.joindate;
    }

    public Employee joindate(Instant joindate) {
        this.setJoindate(joindate);
        return this;
    }

    public void setJoindate(Instant joindate) {
        this.joindate = joindate;
    }

    public String getStatus() {
        return this.status;
    }

    public Employee status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public Employee emailId(String emailId) {
        this.setEmailId(emailId);
        return this;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getEmploymentTypeId() {
        return this.employmentTypeId;
    }

    public Employee employmentTypeId(Long employmentTypeId) {
        this.setEmploymentTypeId(employmentTypeId);
        return this;
    }

    public void setEmploymentTypeId(Long employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
    }

    public Long getReportingEmpId() {
        return this.reportingEmpId;
    }

    public Employee reportingEmpId(Long reportingEmpId) {
        this.setReportingEmpId(reportingEmpId);
        return this;
    }

    public void setReportingEmpId(Long reportingEmpId) {
        this.reportingEmpId = reportingEmpId;
    }

    public Long getCompanyId() {
        return this.companyId;
    }

    public Employee companyId(Long companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Instant getLastModified() {
        return this.lastModified;
    }

    public Employee lastModified(Instant lastModified) {
        this.setLastModified(lastModified);
        return this;
    }

    public void setLastModified(Instant lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public Employee lastModifiedBy(String lastModifiedBy) {
        this.setLastModifiedBy(lastModifiedBy);
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Designation getDesignation() {
        return this.designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public Employee designation(Designation designation) {
        this.setDesignation(designation);
        return this;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee department(Department department) {
        this.setDepartment(department);
        return this;
    }

    public PersonalDetails getPersonaldetails() {
        return this.personaldetails;
    }

    public void setPersonaldetails(PersonalDetails personalDetails) {
        this.personaldetails = personalDetails;
    }

    public Employee personaldetails(PersonalDetails personalDetails) {
        this.setPersonaldetails(personalDetails);
        return this;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee address(Address address) {
        this.setAddress(address);
        return this;
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Employee contacts(Contacts contacts) {
        this.setContacts(contacts);
        return this;
    }

    public BanksDetails getBankdetails() {
        return this.bankdetails;
    }

    public void setBankdetails(BanksDetails banksDetails) {
        this.bankdetails = banksDetails;
    }

    public Employee bankdetails(BanksDetails banksDetails) {
        this.setBankdetails(banksDetails);
        return this;
    }

    public FamilyInfo getFamilyinfo() {
        return this.familyinfo;
    }

    public void setFamilyinfo(FamilyInfo familyInfo) {
        this.familyinfo = familyInfo;
    }

    public Employee familyinfo(FamilyInfo familyInfo) {
        this.setFamilyinfo(familyInfo);
        return this;
    }

    public WorkExperience getWorkexperience() {
        return this.workexperience;
    }

    public void setWorkexperience(WorkExperience workExperience) {
        this.workexperience = workExperience;
    }

    public Employee workexperience(WorkExperience workExperience) {
        this.setWorkexperience(workExperience);
        return this;
    }

    public Education getEducation() {
        return this.education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Employee education(Education education) {
        this.setEducation(education);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Employee{" +
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
            "}";
    }
}
