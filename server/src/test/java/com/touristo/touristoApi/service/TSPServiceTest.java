// package com.touristo.touristoApi.service;

// import com.touristo.touristoApi.model.Site;
// import com.touristo.touristoApi.repository.SiteRepository;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// class TSPServiceTest {

// @Mock
// private SiteRepository siteRepository;

// private TSPService tspService;

// @BeforeEach
// void setUp() {
// MockitoAnnotations.openMocks(this);

// // Create a list of mock sites
// List<Site> mockSites = new ArrayList<>();
// mockSites.add(new Site());
// mockSites.add(new Site());
// // Add more mock sites as needed

// // Create a mock start site
// Site mockStartSite = new Site();

// // Create an instance of TSPService with the mock sites and start site
// tspService = new TSPService(mockSites, mockStartSite);
// }

// @Test
// void testSolveTSP() {
// // Mock the calculation of durations
// tspService.calculateDurations();

// // Mock the call to tsp method and return a mock path
// List<Site> mockPath = new ArrayList<>();
// // Add mock sites to the mock path as needed
// when(tspService.tsp(anyInt(), anyInt())).thenReturn(mockPath);

// // Perform the TSP solving
// List<Site> result = tspService.solveTSP();

// // Verify the calls to tsp method
// verify(tspService, times(1)).tsp(anyInt(), anyInt());

// // Verify the result
// assertEquals(mockPath, result);
// }

// @Test
// void testCalculateTotalDuration() {
// // Mock the calculation of duration between sites
// double mockDuration = 10.0; // Mock duration in hours
// when(tspService.calculateDurationBetweenSites(any(Site.class),
// any(Site.class))).thenReturn(mockDuration);

// // Create a mock path
// List<Site> mockPath = new ArrayList<>();
// // Add mock sites to the mock path as needed

// // Calculate the total duration
// double result = tspService.calculateTotalDuration(mockPath);

// // Verify the calls to calculateDurationBetweenSites method
// verify(tspService, times(mockPath.size() -
// 1)).calculateDurationBetweenSites(any(Site.class), any(Site.class));

// // Verify the result
// double expectedDuration = (mockPath.size() - 1) * mockDuration;
// assertEquals(expectedDuration, result);
// }
// }
