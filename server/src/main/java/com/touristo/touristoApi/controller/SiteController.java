package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sites")
public class SiteController {

    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public ResponseEntity<List<Site>> listSites() {
        List<Site> sites = siteService.listSites();
        return ResponseEntity.ok(sites);
    }

    @PostMapping
    public ResponseEntity<Site> createSite(@RequestBody Site site) throws UnsupportedEncodingException {
        Site createdSite = siteService.createSite(site);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSite);
    }

    @GetMapping("/{siteId}")
    public ResponseEntity<Site> getSiteById(@PathVariable Integer siteId) {
        Optional<Site> site = siteService.getSiteById(siteId);
        return site.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
