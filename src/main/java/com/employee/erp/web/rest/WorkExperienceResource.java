package com.employee.erp.web.rest;

import com.employee.erp.repository.WorkExperienceRepository;
import com.employee.erp.service.WorkExperienceQueryService;
import com.employee.erp.service.WorkExperienceService;
import com.employee.erp.service.criteria.WorkExperienceCriteria;
import com.employee.erp.service.dto.WorkExperienceDTO;
import com.employee.erp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.employee.erp.domain.WorkExperience}.
 */
@RestController
@RequestMapping("/api")
public class WorkExperienceResource {

    private final Logger log = LoggerFactory.getLogger(WorkExperienceResource.class);

    private static final String ENTITY_NAME = "workExperience";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkExperienceService workExperienceService;

    private final WorkExperienceRepository workExperienceRepository;

    private final WorkExperienceQueryService workExperienceQueryService;

    public WorkExperienceResource(
        WorkExperienceService workExperienceService,
        WorkExperienceRepository workExperienceRepository,
        WorkExperienceQueryService workExperienceQueryService
    ) {
        this.workExperienceService = workExperienceService;
        this.workExperienceRepository = workExperienceRepository;
        this.workExperienceQueryService = workExperienceQueryService;
    }

    /**
     * {@code POST  /work-experiences} : Create a new workExperience.
     *
     * @param workExperienceDTO the workExperienceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workExperienceDTO, or with status {@code 400 (Bad Request)} if the workExperience has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/work-experiences")
    public ResponseEntity<WorkExperienceDTO> createWorkExperience(@RequestBody WorkExperienceDTO workExperienceDTO)
        throws URISyntaxException {
        log.debug("REST request to save WorkExperience : {}", workExperienceDTO);
        if (workExperienceDTO.getId() != null) {
            throw new BadRequestAlertException("A new workExperience cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkExperienceDTO result = workExperienceService.save(workExperienceDTO);
        return ResponseEntity
            .created(new URI("/api/work-experiences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /work-experiences/:id} : Updates an existing workExperience.
     *
     * @param id the id of the workExperienceDTO to save.
     * @param workExperienceDTO the workExperienceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workExperienceDTO,
     * or with status {@code 400 (Bad Request)} if the workExperienceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workExperienceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/work-experiences/{id}")
    public ResponseEntity<WorkExperienceDTO> updateWorkExperience(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody WorkExperienceDTO workExperienceDTO
    ) throws URISyntaxException {
        log.debug("REST request to update WorkExperience : {}, {}", id, workExperienceDTO);
        if (workExperienceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, workExperienceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!workExperienceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        WorkExperienceDTO result = workExperienceService.update(workExperienceDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workExperienceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /work-experiences/:id} : Partial updates given fields of an existing workExperience, field will ignore if it is null
     *
     * @param id the id of the workExperienceDTO to save.
     * @param workExperienceDTO the workExperienceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workExperienceDTO,
     * or with status {@code 400 (Bad Request)} if the workExperienceDTO is not valid,
     * or with status {@code 404 (Not Found)} if the workExperienceDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the workExperienceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/work-experiences/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<WorkExperienceDTO> partialUpdateWorkExperience(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody WorkExperienceDTO workExperienceDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update WorkExperience partially : {}, {}", id, workExperienceDTO);
        if (workExperienceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, workExperienceDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!workExperienceRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<WorkExperienceDTO> result = workExperienceService.partialUpdate(workExperienceDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workExperienceDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /work-experiences} : get all the workExperiences.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workExperiences in body.
     */
    @GetMapping("/work-experiences")
    public ResponseEntity<List<WorkExperienceDTO>> getAllWorkExperiences(
        WorkExperienceCriteria criteria,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get WorkExperiences by criteria: {}", criteria);
        Page<WorkExperienceDTO> page = workExperienceQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /work-experiences/count} : count all the workExperiences.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/work-experiences/count")
    public ResponseEntity<Long> countWorkExperiences(WorkExperienceCriteria criteria) {
        log.debug("REST request to count WorkExperiences by criteria: {}", criteria);
        return ResponseEntity.ok().body(workExperienceQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /work-experiences/:id} : get the "id" workExperience.
     *
     * @param id the id of the workExperienceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workExperienceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/work-experiences/{id}")
    public ResponseEntity<WorkExperienceDTO> getWorkExperience(@PathVariable Long id) {
        log.debug("REST request to get WorkExperience : {}", id);
        Optional<WorkExperienceDTO> workExperienceDTO = workExperienceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workExperienceDTO);
    }

    /**
     * {@code DELETE  /work-experiences/:id} : delete the "id" workExperience.
     *
     * @param id the id of the workExperienceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/work-experiences/{id}")
    public ResponseEntity<Void> deleteWorkExperience(@PathVariable Long id) {
        log.debug("REST request to delete WorkExperience : {}", id);
        workExperienceService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
            .build();
    }
}
