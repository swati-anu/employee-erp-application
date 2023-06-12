package com.employee.erp.service;

import com.employee.erp.domain.*; // for static metamodels
import com.employee.erp.domain.Designation;
import com.employee.erp.repository.DesignationRepository;
import com.employee.erp.service.criteria.DesignationCriteria;
import com.employee.erp.service.dto.DesignationDTO;
import com.employee.erp.service.mapper.DesignationMapper;
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
 * Service for executing complex queries for {@link Designation} entities in the database.
 * The main input is a {@link DesignationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link DesignationDTO} or a {@link Page} of {@link DesignationDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class DesignationQueryService extends QueryService<Designation> {

    private final Logger log = LoggerFactory.getLogger(DesignationQueryService.class);

    private final DesignationRepository designationRepository;

    private final DesignationMapper designationMapper;

    public DesignationQueryService(DesignationRepository designationRepository, DesignationMapper designationMapper) {
        this.designationRepository = designationRepository;
        this.designationMapper = designationMapper;
    }

    /**
     * Return a {@link List} of {@link DesignationDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<DesignationDTO> findByCriteria(DesignationCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Designation> specification = createSpecification(criteria);
        return designationMapper.toDto(designationRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link DesignationDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<DesignationDTO> findByCriteria(DesignationCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Designation> specification = createSpecification(criteria);
        return designationRepository.findAll(specification, page).map(designationMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(DesignationCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Designation> specification = createSpecification(criteria);
        return designationRepository.count(specification);
    }

    /**
     * Function to convert {@link DesignationCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Designation> createSpecification(DesignationCriteria criteria) {
        Specification<Designation> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Designation_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Designation_.name));
            }
            if (criteria.getDepartmentId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDepartmentId(), Designation_.departmentId));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildStringSpecification(criteria.getStatus(), Designation_.status));
            }
            if (criteria.getCompanyId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCompanyId(), Designation_.companyId));
            }
            if (criteria.getLastModified() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getLastModified(), Designation_.lastModified));
            }
            if (criteria.getLastModifiedBy() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLastModifiedBy(), Designation_.lastModifiedBy));
            }
        }
        return specification;
    }
}
