package com.example.VPP.ServiceTest;

import com.example.VPP.Entity.VPPEntity;
import com.example.VPP.Repository.VPPRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VPPServiceTest {
    @Mock
    private VPPRepository vppRepository;
    private static final Logger logger = (Logger) LogManager.getLogger(VPPServiceTest.class);

    @Test
    public void testCreateBatteries() {
        // Test logic for createBatteries method
        logger.info("Testing createBatteries method:Service Layer");
        // Add assertions and mock behavior as needed
        // Example assertion
        List<VPPEntity> vppEntity = new ArrayList<VPPEntity>();
        VPPEntity vpp = new VPPEntity();
        vpp.setName("Test Battery");
        vpp.setCapacity(1000);
        vpp.setPostcode("4500");
        assertNotNull(vppRepository.saveAll(vppEntity).size());
    }
   @Test
   public void testGetBatteries(){
         // Test logic for getBatteries method
         logger.info("Testing getBatteries method:Service Layer");
         // Add assertions and mock behavior as needed
         // Example assertion
         assertNotNull(vppRepository.findByCapacityBetweenOrderByNameAsc(13000,50000).size());
         assertEquals(0,vppRepository.findByCapacityBetweenOrderByNameAsc(1000,2000).size());
   }

}
