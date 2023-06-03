package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.DTO.*;
import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.response.apiResponse;
import com.touristo.touristoApi.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/sites")
public class SiteController {

    @Autowired
    SiteService siteService;

    /*
     * @PostMapping("/add")
     * public ResponseDTO createSite(@RequestBody Site site)
     * throws UnsupportedEncodingException {
     * 
     * return siteService.createSite(site);
     * }
     * 
     * @PostMapping("/add-many")
     * public ResponseEntity<apiResponse> createSites(@RequestBody List<Site> sites)
     * throws UnsupportedEncodingException {
     * for (Site site : sites) {
     * siteService.createSite(site);
     * }
     * 
     * return new ResponseEntity<apiResponse>(new apiResponse(true,
     * "created multiple sites"), HttpStatus.CREATED);
     * }
     */

    @GetMapping
    public ResponseEntity<List<Site>> getSites() {
        List<Site> body = siteService.listSites();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping(value = "/{Id}")
    public Site getSiteById(@PathVariable(value = "Id") Integer id) {
        return siteService.getSiteById(id);

    }
}
