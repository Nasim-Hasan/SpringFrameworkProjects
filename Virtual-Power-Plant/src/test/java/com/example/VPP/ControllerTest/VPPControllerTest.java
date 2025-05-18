package com.example.VPP.ControllerTest;

import com.example.VPP.Controller.VPPController;
import com.example.VPP.Entity.VPPEntity;
import com.example.VPP.Service.VPPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VPPControllerTest {
    @Mock
    private VPPService vppService;
    @InjectMocks
    private VPPController vppController;
    private static final Logger logger = (Logger) LogManager.getLogger(VPPControllerTest.class);
    @Test
    public void testCreateBatteries() {
        // Test logic for createBatteries method
        logger.info("Testing createBatteries method:Controller Layer");
        // Add assertions and mock behavior as needed
        // Example assertion
        List<VPPEntity> vppEntity = new ArrayList<VPPEntity>();
        VPPEntity vpp = new VPPEntity();
        vpp.setName("Test Battery");
        vpp.setCapacity(1000);
        vpp.setPostcode("4500");
        assertNotNull(vppService.createBatteriesService(vppEntity));
    }
    @Test
    public void testGetBatteries() throws JsonProcessingException {
        // Test logic for getBatteries method
        logger.info("Testing getBatteries method:Controller Layer");
        // Add assertions and mock behavior as needed
        // Example assertion
        assertNotNull(vppController.getBatteries(13000,50000,0));
        assertEquals(0,vppController.getBatteries(13000,50000,1).size());
        assertEquals(0,vppController.getBatteries(13000,50000,2).size());
        assertEquals(0,vppService.getBatteriesService(13000,50000).size());

    }
}
