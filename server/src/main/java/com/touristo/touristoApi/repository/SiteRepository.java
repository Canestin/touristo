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

        @Query("SELECT s FROM Site s WHERE s.code_departement= :departement ORDER BY s.importance DESC LIMIT 15")

        List<Site> findSitesByParameters(String departement);
        /*
         * @Query("SELECT s FROM Site s WHERE s.city LIKE CONCAT('%', :city, '%') " +
         * "AND s.code_departement = :codeDepartment AND s.type = :type " +
         * "AND s.historical_context = :historicalContext " +
         * "ORDER BY s.importance DESC")
         * 
         * 
         * List<Site> findSitesByParameters(@Param("city") String city,
         * 
         * @Param("codeDepartment") String codeDepartment,
         * 
         * @Param("type") String type,
         * 
         * @Param("historicalContext") String historicalContext);
         */

}
