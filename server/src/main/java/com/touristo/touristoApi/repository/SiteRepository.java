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

}
