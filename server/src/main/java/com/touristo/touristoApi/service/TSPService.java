package com.touristo.touristoApi.service;

import com.touristo.touristoApi.model.Site;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TSPService {
    private List<Site> sites;
    private Site startSite; // New variable for the start site
    private double[][] distance;
    private int numCities;
    private int[][] memo;

    public TSPService(List<Site> sites, Site startSite) { // Modified constructor
        this.sites = sites;
        this.startSite = startSite;
        this.numCities = sites.size();
        this.distance = new double[numCities][numCities];
        this.memo = new int[numCities][1 << numCities];
    }

    public void calculateDurations() {
        for (int i = 0; i < numCities; i++) {
            Site site1 = sites.get(i);
            for (int j = 0; j < numCities; j++) {
                Site site2 = sites.get(j);
                distance[i][j] = calculateDurationBetweenSites(site1, site2);
            }
        }
    }

    protected double calculateTotalDuration(List<Site> path) {
        double duration = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Site currentSite = path.get(i);
            Site nextSite = path.get(i + 1);
            duration += calculateDurationBetweenSites(currentSite, nextSite);
        }
        return duration;
    }

    public List<Site> solveTSP() {
        calculateDurations();

        // Initialize memoization table
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < (1 << numCities); j++) {
                memo[i][j] = -1;
            }
        }

        // Find the index of the start site
        int startIndex = sites.indexOf(startSite);

        // Call the recursive function to solve TSP
        int mask = (1 << numCities) - 1;
        int result = tsp(startIndex, mask);

        // Reconstruct the path
        List<Site> path = new ArrayList<>();
        path.add(startSite); // Start from the specified start site
        int currCity = startIndex;

        while (mask != 0) {
            int nextCity = memo[currCity][mask];
            if (nextCity != startIndex) {
                path.add(sites.get(nextCity));
            }
            mask ^= (1 << nextCity);
            currCity = nextCity;
        }
        path.add(startSite);
        return path;
    }

    public int tsp(int city, int mask) {
        if (mask == 0) {
            return 0; // All sites have been visited, return 0
        }

        if (memo[city][mask] != -1) {
            return memo[city][mask]; // Return memoized value
        }

        int minDistance = Integer.MAX_VALUE;

        for (int nextCity = 0; nextCity < numCities; nextCity++) {
            if ((mask & (1 << nextCity)) != 0) {
                int newMask = mask ^ (1 << nextCity);
                int distanceToNextCity = (int) distance[city][nextCity] + tsp(nextCity, newMask);

                if (distanceToNextCity < minDistance) {
                    minDistance = distanceToNextCity;
                    memo[city][mask] = nextCity;
                }
            }
        }

        return minDistance;
    }

    double calculateDurationBetweenSites(Site site1, Site site2) {
        String origin = site1.getLatitude() + "," + site1.getLongitude();
        String destination = site2.getLatitude() + "," + site2.getLongitude();
        String apiKey = "AIzaSyBjU1gZUIMq0oOlmgnUfg44WtxNJp0Agio"; // A metttre en variable d'environnement

        try {
            URL url = new URL(
                    "https://maps.googleapis.com/maps/api/directions/json?origin=" + origin
                            + "&destination=" + destination
                            + "&key=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse the JSON response to extract the duration in seconds
            JSONObject json = new JSONObject(response.toString());
            JSONArray routes = json.getJSONArray("routes");
            if (routes.length() > 0) {
                JSONObject route = routes.getJSONObject(0);
                JSONArray legs = route.getJSONArray("legs");
                if (legs.length() > 0) {
                    JSONObject leg = legs.getJSONObject(0);
                    JSONObject duration = leg.getJSONObject("duration");
                    int durationSeconds = duration.getInt("value");
                    return durationSeconds / 3600.0; // Convertit les econdes en heures
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return 0.0; // Par defaut en cas d'erreur
    }

    public static void main(String[] args) {

        // Create a list of sites
        Site site1 = new Site(UUID.randomUUID(), "City 1", 1, "Site 1", "Historical context 1", 0.8, 48.8566, 2.3522,
                "Site 1", "Type 1");
        Site site2 = new Site(UUID.randomUUID(), "City 2", 2, "Site 2", "Historical context 2", 0.6, 51.5074, -0.1278,
                "Site 2", "Type 2");
        Site site3 = new Site(UUID.randomUUID(), "City 3", 3, "Site 3", "Historical context 3", 0.9, 51.124, 0.1278,
                "Site 3", "Type 3");
        Site site4 = new Site(UUID.randomUUID(), "City 4", 4, "Site 4", "Historical context 4", 0.7, 40.86, 0.3522,
                "Site 4", "Type 4");
        Site[] sites = { site1, site2, site3, site4 };

        TSPService tspSolver = new TSPService(List.of(sites), site2); // Pass the desired start site

        List<Site> path = tspSolver.solveTSP();
        Double totalDuration = tspSolver.calculateTotalDuration(path);
        System.out.println("Optimal TSP path:");
        for (Site site : path) {
            System.out.println(site.getName());
        }

        System.out.println("shortest duration: " + totalDuration);
    }
}
