package com.touristo.touristoApi.service;

import com.touristo.touristoApi.DTO.*;
import com.touristo.touristoApi.model.*;
import com.touristo.touristoApi.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class SiteService {
    @Autowired
    SiteRepository siteRepository;

    public List<Site> listSites() {
        List<Site> sites = siteRepository.findAll();
        return sites;
    }

    public ResponseDTO createSite(Site site) throws UnsupportedEncodingException {

        siteRepository.save(site);

        ResponseDTO responseDTO = new ResponseDTO("success", "site successfully created");
        return responseDTO;
    }

    public Site getSiteById(Integer siteId) {
        Optional<Site> optionalSite = siteRepository.findById(siteId);
        if (optionalSite.isPresent()) {
            return optionalSite.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "site not found with ID: " + siteId);
        }
    }
}
