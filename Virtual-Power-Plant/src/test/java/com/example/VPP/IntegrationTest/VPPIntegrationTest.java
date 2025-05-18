package com.example.VPP.IntegrationTest;

import com.example.VPP.ControllerTest.VPPControllerTest;
import com.example.VPP.Entity.VPPEntity;
import com.example.VPP.Repository.VPPRepository;
import com.example.VPP.Service.VPPService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VPPIntegrationTest {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    @Autowired
    private VPPService vppService;
    @Mock
    private VPPRepository vppRepository;
    private static final Logger logger = (Logger) LogManager.getLogger(VPPControllerTest.class);
    // Add your test methods here
    // Example test method
    @Test
    public void testCreateBatteries() {
        // Test logic for createBatteries method
        // Use restTemplate to send requests to the application
        // Example: restTemplate.postForObject("http://localhost:" + port + "/vpp/batteries", request, responseType);
        logger.info("Testing createBatteries method:Integration Layer");
        VPPEntity vppEntity = new VPPEntity();
        vppEntity.setName("Test Battery");
        vppEntity.setCapacity(1000);
        vppEntity.setPostcode("4500");
        List<VPPEntity> vppEntities = List.of(vppEntity);
        HttpEntity<List<VPPEntity>> request = new HttpEntity<List<VPPEntity>>(vppEntities);
        List<VPPEntity>response=restTemplate.exchange("http://localhost:" + port + "/vpp/batteries", HttpMethod.POST, request, List.class).getBody();
        assertNotEquals(null,response);
        assertNotEquals(0,response.size());
    }
    @Test
    public void testGetBatteries() {
        // Test logic for getBatteries method
        logger.info("Testing getBatteries method:Integration Layer");
        // Use restTemplate to send requests to the application
        // Example: restTemplate.getForObject("http://localhost:" + port + "/vpp/get_batteries/{minwatt}/{maxwatt}/{determiner}", responseType, minwatt, maxwatt, determiner);
        List<VPPEntity>response=restTemplate.getForObject("http://localhost:" + port + "/vpp/get_batteries/{minwatt}/{maxwatt}/{determiner}", List.class, 13000, 50000, 0).stream().toList();
        assertNotEquals(null,response);
        assertNotEquals(0,response.size());
        assertNotEquals(vppService.getBatteriesService(13000,50000).size(),response.size());
    }
}
