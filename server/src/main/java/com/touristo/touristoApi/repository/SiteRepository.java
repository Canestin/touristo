package com.touristo.touristoApi.repository;

import com.touristo.touristoApi.model.Site;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {

        @Query("SELECT s FROM Site s WHERE s.code_departement= :departement  ORDER BY s.importance DESC LIMIT 60")

        List<Site> findSitesByParameters(String departement);

        @Query("SELECT s FROM Site s WHERE s.code_departement= :departement AND s.type= :type ORDER BY s.importance DESC LIMIT 60")

        List<Site> findSitesByDeptAndType(String departement, String type);

        @Query("SELECT s FROM Site s WHERE s.code_departement= :departement AND s.historical_context= :historicalContext  ORDER BY s.importance DESC LIMIT 60")

        List<Site> findSitesByDeptAndHistoricalContext(String departement, String historicalContext);


        @Query("SELECT s FROM Site s WHERE s.code_departement= :departement AND s.historical_context= :historicalContext AND s.type =:type ORDER BY s.importance DESC LIMIT 60")

        List<Site> findSitesByDeptAndHistoricalContextAndType(String departement, String historicalContext, String type);


}
