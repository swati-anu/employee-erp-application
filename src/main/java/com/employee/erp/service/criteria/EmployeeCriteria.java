package com.employee.erp.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.employee.erp.domain.Employee} entity. This class is used
 * in {@link com.employee.erp.web.rest.EmployeeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /employees?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class EmployeeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private StringFilter gender;

    private StringFilter empUniqueId;

    private InstantFilter joindate;

    private StringFilter status;

    private StringFilter emailId;

    private LongFilter employmentTypeId;

    private LongFilter reportingEmpId;

    private LongFilter companyId;

    private InstantFilter lastModified;

    private StringFilter lastModifiedBy;

    private LongFilter designationId;

    private LongFilter departmentId;

    private LongFilter personaldetailsId;

    private LongFilter addressId;

    private LongFilter contactsId;

    private LongFilter bankdetailsId;

    private LongFilter familyinfoId;

    private LongFilter workexperienceId;

    private LongFilter educationId;

    private Boolean distinct;

    public EmployeeCriteria() {}

    public EmployeeCriteria(EmployeeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.empUniqueId = other.empUniqueId == null ? null : other.empUniqueId.copy();
        this.joindate = other.joindate == null ? null : other.joindate.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.emailId = other.emailId == null ? null : other.emailId.copy();
        this.employmentTypeId = other.employmentTypeId == null ? null : other.employmentTypeId.copy();
        this.reportingEmpId = other.reportingEmpId == null ? null : other.reportingEmpId.copy();
        this.companyId = other.companyId == null ? null : other.companyId.copy();
        this.lastModified = other.lastModified == null ? null : other.lastModified.copy();
        this.lastModifiedBy = other.lastModifiedBy == null ? null : other.lastModifiedBy.copy();
        this.designationId = other.designationId == null ? null : other.designationId.copy();
        this.departmentId = other.departmentId == null ? null : other.departmentId.copy();
        this.personaldetailsId = other.personaldetailsId == null ? null : other.personaldetailsId.copy();
        this.addressId = other.addressId == null ? null : other.addressId.copy();
        this.contactsId = other.contactsId == null ? null : other.contactsId.copy();
        this.bankdetailsId = other.bankdetailsId == null ? null : other.bankdetailsId.copy();
        this.familyinfoId = other.familyinfoId == null ? null : other.familyinfoId.copy();
        this.workexperienceId = other.workexperienceId == null ? null : other.workexperienceId.copy();
        this.educationId = other.educationId == null ? null : other.educationId.copy();
        this.distinct = other.distinct;
    }

    @Override
    public EmployeeCriteria copy() {
        return new EmployeeCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public StringFilter firstName() {
        if (firstName == null) {
            firstName = new StringFilter();
        }
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getMiddleName() {
        return middleName;
    }

    public StringFilter middleName() {
        if (middleName == null) {
            middleName = new StringFilter();
        }
        return middleName;
    }

    public void setMiddleName(StringFilter middleName) {
        this.middleName = middleName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public StringFilter lastName() {
        if (lastName == null) {
            lastName = new StringFilter();
        }
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getGender() {
        return gender;
    }

    public StringFilter gender() {
        if (gender == null) {
            gender = new StringFilter();
        }
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public StringFilter getEmpUniqueId() {
        return empUniqueId;
    }

    public StringFilter empUniqueId() {
        if (empUniqueId == null) {
            empUniqueId = new StringFilter();
        }
        return empUniqueId;
    }

    public void setEmpUniqueId(StringFilter empUniqueId) {
        this.empUniqueId = empUniqueId;
    }

    public InstantFilter getJoindate() {
        return joindate;
    }

    public InstantFilter joindate() {
        if (joindate == null) {
            joindate = new InstantFilter();
        }
        return joindate;
    }

    public void setJoindate(InstantFilter joindate) {
        this.joindate = joindate;
    }

    public StringFilter getStatus() {
        return status;
    }

    public StringFilter status() {
        if (status == null) {
            status = new StringFilter();
        }
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public StringFilter getEmailId() {
        return emailId;
    }

    public StringFilter emailId() {
        if (emailId == null) {
            emailId = new StringFilter();
        }
        return emailId;
    }

    public void setEmailId(StringFilter emailId) {
        this.emailId = emailId;
    }

    public LongFilter getEmploymentTypeId() {
        return employmentTypeId;
    }

    public LongFilter employmentTypeId() {
        if (employmentTypeId == null) {
            employmentTypeId = new LongFilter();
        }
        return employmentTypeId;
    }

    public void setEmploymentTypeId(LongFilter employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
    }

    public LongFilter getReportingEmpId() {
        return reportingEmpId;
    }

    public LongFilter reportingEmpId() {
        if (reportingEmpId == null) {
            reportingEmpId = new LongFilter();
        }
        return reportingEmpId;
    }

    public void setReportingEmpId(LongFilter reportingEmpId) {
        this.reportingEmpId = reportingEmpId;
    }

    public LongFilter getCompanyId() {
        return companyId;
    }

    public LongFilter companyId() {
        if (companyId == null) {
            companyId = new LongFilter();
        }
        return companyId;
    }

    public void setCompanyId(LongFilter companyId) {
        this.companyId = companyId;
    }

    public InstantFilter getLastModified() {
        return lastModified;
    }

    public InstantFilter lastModified() {
        if (lastModified == null) {
            lastModified = new InstantFilter();
        }
        return lastModified;
    }

    public void setLastModified(InstantFilter lastModified) {
        this.lastModified = lastModified;
    }

    public StringFilter getLastModifiedBy() {
        return lastModifiedBy;
    }

    public StringFilter lastModifiedBy() {
        if (lastModifiedBy == null) {
            lastModifiedBy = new StringFilter();
        }
        return lastModifiedBy;
    }

    public void setLastModifiedBy(StringFilter lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LongFilter getDesignationId() {
        return designationId;
    }

    public LongFilter designationId() {
        if (designationId == null) {
            designationId = new LongFilter();
        }
        return designationId;
    }

    public void setDesignationId(LongFilter designationId) {
        this.designationId = designationId;
    }

    public LongFilter getDepartmentId() {
        return departmentId;
    }

    public LongFilter departmentId() {
        if (departmentId == null) {
            departmentId = new LongFilter();
        }
        return departmentId;
    }

    public void setDepartmentId(LongFilter departmentId) {
        this.departmentId = departmentId;
    }

    public LongFilter getPersonaldetailsId() {
        return personaldetailsId;
    }

    public LongFilter personaldetailsId() {
        if (personaldetailsId == null) {
            personaldetailsId = new LongFilter();
        }
        return personaldetailsId;
    }

    public void setPersonaldetailsId(LongFilter personaldetailsId) {
        this.personaldetailsId = personaldetailsId;
    }

    public LongFilter getAddressId() {
        return addressId;
    }

    public LongFilter addressId() {
        if (addressId == null) {
            addressId = new LongFilter();
        }
        return addressId;
    }

    public void setAddressId(LongFilter addressId) {
        this.addressId = addressId;
    }

    public LongFilter getContactsId() {
        return contactsId;
    }

    public LongFilter contactsId() {
        if (contactsId == null) {
            contactsId = new LongFilter();
        }
        return contactsId;
    }

    public void setContactsId(LongFilter contactsId) {
        this.contactsId = contactsId;
    }

    public LongFilter getBankdetailsId() {
        return bankdetailsId;
    }

    public LongFilter bankdetailsId() {
        if (bankdetailsId == null) {
            bankdetailsId = new LongFilter();
        }
        return bankdetailsId;
    }

    public void setBankdetailsId(LongFilter bankdetailsId) {
        this.bankdetailsId = bankdetailsId;
    }

    public LongFilter getFamilyinfoId() {
        return familyinfoId;
    }

    public LongFilter familyinfoId() {
        if (familyinfoId == null) {
            familyinfoId = new LongFilter();
        }
        return familyinfoId;
    }

    public void setFamilyinfoId(LongFilter familyinfoId) {
        this.familyinfoId = familyinfoId;
    }

    public LongFilter getWorkexperienceId() {
        return workexperienceId;
    }

    public LongFilter workexperienceId() {
        if (workexperienceId == null) {
            workexperienceId = new LongFilter();
        }
        return workexperienceId;
    }

    public void setWorkexperienceId(LongFilter workexperienceId) {
        this.workexperienceId = workexperienceId;
    }

    public LongFilter getEducationId() {
        return educationId;
    }

    public LongFilter educationId() {
        if (educationId == null) {
            educationId = new LongFilter();
        }
        return educationId;
    }

    public void setEducationId(LongFilter educationId) {
        this.educationId = educationId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EmployeeCriteria that = (EmployeeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(empUniqueId, that.empUniqueId) &&
            Objects.equals(joindate, that.joindate) &&
            Objects.equals(status, that.status) &&
            Objects.equals(emailId, that.emailId) &&
            Objects.equals(employmentTypeId, that.employmentTypeId) &&
            Objects.equals(reportingEmpId, that.reportingEmpId) &&
            Objects.equals(companyId, that.companyId) &&
            Objects.equals(lastModified, that.lastModified) &&
            Objects.equals(lastModifiedBy, that.lastModifiedBy) &&
            Objects.equals(designationId, that.designationId) &&
            Objects.equals(departmentId, that.departmentId) &&
            Objects.equals(personaldetailsId, that.personaldetailsId) &&
            Objects.equals(addressId, that.addressId) &&
            Objects.equals(contactsId, that.contactsId) &&
            Objects.equals(bankdetailsId, that.bankdetailsId) &&
            Objects.equals(familyinfoId, that.familyinfoId) &&
            Objects.equals(workexperienceId, that.workexperienceId) &&
            Objects.equals(educationId, that.educationId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            firstName,
            middleName,
            lastName,
            gender,
            empUniqueId,
            joindate,
            status,
            emailId,
            employmentTypeId,
            reportingEmpId,
            companyId,
            lastModified,
            lastModifiedBy,
            designationId,
            departmentId,
            personaldetailsId,
            addressId,
            contactsId,
            bankdetailsId,
            familyinfoId,
            workexperienceId,
            educationId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (firstName != null ? "firstName=" + firstName + ", " : "") +
            (middleName != null ? "middleName=" + middleName + ", " : "") +
            (lastName != null ? "lastName=" + lastName + ", " : "") +
            (gender != null ? "gender=" + gender + ", " : "") +
            (empUniqueId != null ? "empUniqueId=" + empUniqueId + ", " : "") +
            (joindate != null ? "joindate=" + joindate + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (emailId != null ? "emailId=" + emailId + ", " : "") +
            (employmentTypeId != null ? "employmentTypeId=" + employmentTypeId + ", " : "") +
            (reportingEmpId != null ? "reportingEmpId=" + reportingEmpId + ", " : "") +
            (companyId != null ? "companyId=" + companyId + ", " : "") +
            (lastModified != null ? "lastModified=" + lastModified + ", " : "") +
            (lastModifiedBy != null ? "lastModifiedBy=" + lastModifiedBy + ", " : "") +
            (designationId != null ? "designationId=" + designationId + ", " : "") +
            (departmentId != null ? "departmentId=" + departmentId + ", " : "") +
            (personaldetailsId != null ? "personaldetailsId=" + personaldetailsId + ", " : "") +
            (addressId != null ? "addressId=" + addressId + ", " : "") +
            (contactsId != null ? "contactsId=" + contactsId + ", " : "") +
            (bankdetailsId != null ? "bankdetailsId=" + bankdetailsId + ", " : "") +
            (familyinfoId != null ? "familyinfoId=" + familyinfoId + ", " : "") +
            (workexperienceId != null ? "workexperienceId=" + workexperienceId + ", " : "") +
            (educationId != null ? "educationId=" + educationId + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
