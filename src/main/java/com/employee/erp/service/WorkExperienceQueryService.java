package com.employee.erp.service;

import com.employee.erp.domain.*; // for static metamodels
import com.employee.erp.domain.WorkExperience;
import com.employee.erp.repository.WorkExperienceRepository;
import com.employee.erp.service.criteria.WorkExperienceCriteria;
import com.employee.erp.service.dto.WorkExperienceDTO;
import com.employee.erp.service.mapper.WorkExperienceMapper;
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
 * Service for executing complex queries for {@link WorkExperience} entities in the database.
 * The main input is a {@link WorkExperienceCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link WorkExperienceDTO} or a {@link Page} of {@link WorkExperienceDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class WorkExperienceQueryService extends QueryService<WorkExperience> {

    private final Logger log = LoggerFactory.getLogger(WorkExperienceQueryService.class);

    private final WorkExperienceRepository workExperienceRepository;

    private final WorkExperienceMapper workExperienceMapper;

    public WorkExperienceQueryService(WorkExperienceRepository workExperienceRepository, WorkExperienceMapper workExperienceMapper) {
        this.workExperienceRepository = workExperienceRepository;
        this.workExperienceMapper = workExperienceMapper;
    }

    /**
     * Return a {@link List} of {@link WorkExperienceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<WorkExperienceDTO> findByCriteria(WorkExperienceCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<WorkExperience> specification = createSpecification(criteria);
        return workExperienceMapper.toDto(workExperienceRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link WorkExperienceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<WorkExperienceDTO> findByCriteria(WorkExperienceCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<WorkExperience> specification = createSpecification(criteria);
        return workExperienceRepository.findAll(specification, page).map(workExperienceMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(WorkExperienceCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<WorkExperience> specification = createSpecification(criteria);
        return workExperienceRepository.count(specification);
    }

    /**
     * Function to convert {@link WorkExperienceCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<WorkExperience> createSpecification(WorkExperienceCriteria criteria) {
        Specification<WorkExperience> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), WorkExperience_.id));
            }
            if (criteria.getJobTitle() != null) {
                specification = specification.and(buildStringSpecification(criteria.getJobTitle(), WorkExperience_.jobTitle));
            }
            if (criteria.getCompanyName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCompanyName(), WorkExperience_.companyName));
            }
            if (criteria.getStartDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getStartDate(), WorkExperience_.startDate));
            }
            if (criteria.getEndDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEndDate(), WorkExperience_.endDate));
            }
            if (criteria.getAddressId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getAddressId(), WorkExperience_.addressId));
            }
            if (criteria.getEmployeeId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getEmployeeId(), WorkExperience_.employeeId));
            }
            if (criteria.getJobDesc() != null) {
                specification = specification.and(buildStringSpecification(criteria.getJobDesc(), WorkExperience_.jobDesc));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), WorkExperience_.status));
            }
            if (criteria.getCompanyId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCompanyId(), WorkExperience_.companyId));
            }
            if (criteria.getLastModified() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLastModified(), WorkExperience_.lastModified));
            }
            if (criteria.getLastModifiedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), WorkExperience_.lastModifiedBy));
            }
        }
        return specification;
    }
}
