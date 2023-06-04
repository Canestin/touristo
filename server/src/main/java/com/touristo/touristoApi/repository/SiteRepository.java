package com.touristo.touristoApi.repository;

import com.touristo.touristoApi.model.Site;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    @Query("SELECT s FROM Site s WHERE s.city = :city " +
            "AND s.code_departement = :codeDepartment AND s.type = :type " +
            "AND s.historical_context = :historicalContext " +
            "AND (:numberOfDays IS NULL OR :numberOfSitePerDay IS NULL) " +
            "ORDER BY s.importance DESC ")


    List<Site> findSitesByParameters(@Param("city") String city,
                                     @Param("codeDepartment") String codeDepartment,
                                     @Param("type") String type,
                                     @Param("numberOfDays")Integer numberOfDays,
                                     @Param("numberOfSitePerDay")Integer numberOfSitePerDay,
                                     @Param("historicalContext") String historicalContext);

}
