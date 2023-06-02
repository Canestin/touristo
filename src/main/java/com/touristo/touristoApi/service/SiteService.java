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

    public Double getDistance(Site siteA, Site siteB){
        int R = 6371; // Rayon de la Terre en kilomètres

        double latDistance = Math.toRadians(siteB.getLatitude() - siteA.getLatitude());
        double lonDistance = Math.toRadians(siteB.getLongitude() - siteA.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(siteA.getLatitude())) * Math.cos(Math.toRadians(siteA.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return distance;
    }
}
