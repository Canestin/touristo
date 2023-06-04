package com.touristo.touristoApi.service;

import com.touristo.touristoApi.model.*;
import com.touristo.touristoApi.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Site createSite(Site site) throws UnsupportedEncodingException {
        return siteRepository.save(site);

    }

    public Optional<Site> getSiteById(UUID siteId) {
        return siteRepository.findById(siteId);
    }

}
