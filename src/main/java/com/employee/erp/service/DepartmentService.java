package com.employee.erp.service;

import com.employee.erp.domain.Department;
import com.employee.erp.repository.DepartmentRepository;
import com.employee.erp.service.dto.DepartmentDTO;
import com.employee.erp.service.mapper.DepartmentMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Department}.
 */
@Service
@Transactional
public class DepartmentService {

    private final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    /**
     * Save a department.
     *
     * @param departmentDTO the entity to save.
     * @return the persisted entity.
     */
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        log.debug("Request to save Department : {}", departmentDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentMapper.toDto(department);
    }

    /**
     * Update a department.
     *
     * @param departmentDTO the entity to save.
     * @return the persisted entity.
     */
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        log.debug("Request to update Department : {}", departmentDTO);
        Department department = departmentMapper.toEntity(departmentDTO);
        department = departmentRepository.save(department);
        return departmentMapper.toDto(department);
    }

    /**
     * Partially update a department.
     *
     * @param departmentDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<DepartmentDTO> partialUpdate(DepartmentDTO departmentDTO) {
        log.debug("Request to partially update Department : {}", departmentDTO);

        return departmentRepository
            .findById(departmentDTO.getId())
            .map(existingDepartment -> {
                departmentMapper.partialUpdate(existingDepartment, departmentDTO);

                return existingDepartment;
            })
            .map(departmentRepository::save)
            .map(departmentMapper::toDto);
    }

    /**
     * Get all the departments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Departments");
        return departmentRepository.findAll(pageable).map(departmentMapper::toDto);
    }

    /**
     * Get one department by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<DepartmentDTO> findOne(Long id) {
        log.debug("Request to get Department : {}", id);
        return departmentRepository.findById(id).map(departmentMapper::toDto);
    }

    /**
     * Delete the department by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Department : {}", id);
        departmentRepository.deleteById(id);
    }
}
