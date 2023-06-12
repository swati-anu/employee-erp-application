package com.employee.erp.service;

import com.employee.erp.domain.*; // for static metamodels
import com.employee.erp.domain.Employee;
import com.employee.erp.repository.EmployeeRepository;
import com.employee.erp.service.criteria.EmployeeCriteria;
import com.employee.erp.service.dto.EmployeeDTO;
import com.employee.erp.service.mapper.EmployeeMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Employee} entities in the database.
 * The main input is a {@link EmployeeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link EmployeeDTO} or a {@link Page} of {@link EmployeeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class EmployeeQueryService extends QueryService<Employee> {

    private final Logger log = LoggerFactory.getLogger(EmployeeQueryService.class);

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeQueryService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    /**
     * Return a {@link List} of {@link EmployeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<EmployeeDTO> findByCriteria(EmployeeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Employee> specification = createSpecification(criteria);
        return employeeMapper.toDto(employeeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link EmployeeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findByCriteria(EmployeeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Employee> specification = createSpecification(criteria);
        return employeeRepository.findAll(specification, page).map(employeeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(EmployeeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Employee> specification = createSpecification(criteria);
        return employeeRepository.count(specification);
    }

    /**
     * Function to convert {@link EmployeeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Employee> createSpecification(EmployeeCriteria criteria) {
        Specification<Employee> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Employee_.id));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), Employee_.firstName));
            }
            if (criteria.getMiddleName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getMiddleName(), Employee_.middleName));
            }
            if (criteria.getLastName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastName(), Employee_.lastName));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), Employee_.gender));
            }
            if (criteria.getEmpUniqueId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmpUniqueId(), Employee_.empUniqueId));
            }
            if (criteria.getJoindate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getJoindate(), Employee_.joindate));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), Employee_.status));
            }
            if (criteria.getEmailId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmailId(), Employee_.emailId));
            }
            if (criteria.getEmploymentTypeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEmploymentTypeId(), Employee_.employmentTypeId));
            }
            if (criteria.getReportingEmpId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getReportingEmpId(), Employee_.reportingEmpId));
            }
            if (criteria.getCompanyId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCompanyId(), Employee_.companyId));
            }
            if (criteria.getLastModified() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLastModified(), Employee_.lastModified));
            }
            if (criteria.getLastModifiedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Employee_.lastModifiedBy));
            }
            if (criteria.getDesignationId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getDesignationId(),
                            root -> root.join(Employee_.designation, JoinType.LEFT).get(Designation_.id)
                        )
                    );
            }
            if (criteria.getDepartmentId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getDepartmentId(),
                            root -> root.join(Employee_.department, JoinType.LEFT).get(Department_.id)
                        )
                    );
            }
            if (criteria.getPersonaldetailsId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getPersonaldetailsId(),
                            root -> root.join(Employee_.personaldetails, JoinType.LEFT).get(PersonalDetails_.id)
                        )
                    );
            }
            if (criteria.getAddressId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getAddressId(), root -> root.join(Employee_.address, JoinType.LEFT).get(Address_.id))
                    );
            }
            if (criteria.getContactsId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getContactsId(), root -> root.join(Employee_.contacts, JoinType.LEFT).get(Contacts_.id))
                    );
            }
            if (criteria.getBankdetailsId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getBankdetailsId(),
                            root -> root.join(Employee_.bankdetails, JoinType.LEFT).get(BanksDetails_.id)
                        )
                    );
            }
            if (criteria.getFamilyinfoId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getFamilyinfoId(),
                            root -> root.join(Employee_.familyinfo, JoinType.LEFT).get(FamilyInfo_.id)
                        )
                    );
            }
            if (criteria.getWorkexperienceId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getWorkexperienceId(),
                            root -> root.join(Employee_.workexperience, JoinType.LEFT).get(WorkExperience_.id)
                        )
                    );
            }
            if (criteria.getEducationId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getEducationId(),
                            root -> root.join(Employee_.education, JoinType.LEFT).get(Education_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
