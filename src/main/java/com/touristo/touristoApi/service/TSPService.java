package com.touristo.touristoApi.service;

import com.touristo.touristoApi.model.Site;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TSPService {
    private Site[] sites;
    private int numSites;

    public TSPService(Site[] sites) {
        this.sites = sites;
        this.numSites = sites.length;
    }

    public List<Site> tsp() {
        List<Site> bestPath = new ArrayList<>();
        List<Site> currentPath = new ArrayList<>();
        double[] minDuration = { Double.MAX_VALUE };

        permute(new ArrayList<>(List.of(sites)), currentPath, minDuration, bestPath);

        return bestPath;
    }

    private void permute(List<Site> sites, List<Site> currentPath, double[] minDuration, List<Site> bestPath) {
        if (sites.isEmpty()) {
            double duration = calculateDuration(currentPath);
            if (duration < minDuration[0]) {
                minDuration[0] = duration;
                bestPath.clear();
                bestPath.addAll(currentPath);
            }
            return;
        }

        for (int i = 0; i < sites.size(); i++) {
            Site currentSite = sites.get(i);
            List<Site> remainingSites = new ArrayList<>(sites);
            remainingSites.remove(i);
            currentPath.add(currentSite);

            permute(remainingSites, currentPath, minDuration, bestPath);

            currentPath.remove(currentSite);
        }
    }


    private double calculateDuration(List<Site> path) {
        double duration = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Site currentSite = path.get(i);
            Site nextSite = path.get(i + 1);
            duration += calculateDurationBetweenSites(currentSite, nextSite);
        }
        return duration;
    }

    private double calculateDurationBetweenSites(Site site1, Site site2) {
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
        // Petit Test
        Site site1 = new Site(1, "Department1", "Site 1", "Street 1", "12345", "City 1", "Country 1", 48.8566,2.3522, "Historical context 1", 0.8, "Type 1");
        Site site2 = new Site(2, "Department2", "Site 2", "Street 2", "23456", "City 2", "Country 2", 51.5074,-0.1278, "Historical context 2", 0.6, "Type 2");
        Site site3 = new Site(3, "Department3", "Site 3", "Street 3", "34567", "City 3", "Country 3", 51.5074, -0.1278, "Historical context 3", 0.9, "Type 3");
        Site site4 = new Site(4, "Department4", "Site 4", "Street 4", "45678", "City 4", "Country 4", 48.8566, 2.3522, "Historical context 4", 0.7, "Type 4");
        Site[] sites = { site1, site2, site3, site4 };
        TSPService tsp = new TSPService(sites);
        List<Site> shortestPath = tsp.tsp();
        double shortestDistance = tsp.calculateDuration(shortestPath);
        System.out.println("Best Path: ");
        for (Site site : shortestPath) {
            System.out.println(site.getName());
        }
        System.out.println("Shortest Distance: " + shortestDistance);
        System.out.println(tsp.calculateDurationBetweenSites(site1, site2));// Test de l'api
    }
}
