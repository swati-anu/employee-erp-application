package com.employee.erp.repository;

import com.employee.erp.domain.FamilyInfo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FamilyInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FamilyInfoRepository extends JpaRepository<FamilyInfo, Long>, JpaSpecificationExecutor<FamilyInfo> {}
