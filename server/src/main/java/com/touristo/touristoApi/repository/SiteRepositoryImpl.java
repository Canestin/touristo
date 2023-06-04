package com.touristo.touristoApi.repository;

import com.touristo.touristoApi.model.Site;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class SiteRepositoryImpl implements SiteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Site> findSitesByParameters(String city, String codeDepartment, String type, Integer numberOfDays, Integer numberOfSitePerDay, String historicalContext) {
        String queryString = "SELECT s FROM Site s WHERE s.city = :city " +
                "AND s.code_departement = :codeDepartment AND s.type = :type " +
                "AND s.historical_context = :historicalContext ORDER BY s.importance DESC ";

        TypedQuery<Site> query = entityManager.createQuery(queryString, Site.class);
        query.setParameter("city", city);
        query.setParameter("codeDepartment", codeDepartment);
        query.setParameter("type", type);
        query.setParameter("historicalContext", historicalContext);
        query.setMaxResults(numberOfSitePerDay* numberOfDays); // Set the limit based on numberOfDays
        return query.getResultList();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Site> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Site> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Site> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Site getOne(Integer integer) {
        return null;
    }

    @Override
    public Site getById(Integer integer) {
        return null;
    }

    @Override
    public Site getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Site> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Site> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Site> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Site> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Site> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Site> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Site, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Site> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Site> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Site> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Site> findAll() {
        return null;
    }

    @Override
    public List<Site> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Site entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Site> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Site> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Site> findAll(Pageable pageable) {
        return null;
    }
}
