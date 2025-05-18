package com.example.VPP.Controller;

import com.example.VPP.Entity.VPPEntity;
import com.example.VPP.Service.VPPService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/vpp")
public class VPPController {
    @Autowired
    private VPPService vppService;
    private static final Logger logger = (Logger) LogManager.getLogger(VPPController.class);
    @PostMapping("/batteries")
    public List<VPPEntity> createBatteries(@RequestBody List<VPPEntity> vppEntities) {
        logger.info("Received request to create batteries: {}", vppEntities);
        return vppService.createBatteriesService(vppEntities);
    }
    @GetMapping("/get_batteries/{minwatt}/{maxwatt}/{determiner}")
    public List<VPPEntity> getBatteries(@PathVariable long minwatt, @PathVariable long maxwatt, @PathVariable int determiner)
            throws JsonProcessingException {
        logger.info("Received request to get batteries with minwatt: {}, maxwatt: {}, determiner: {}", minwatt, maxwatt, determiner);
        List<VPPEntity>getBatterieslist=vppService.getBatteriesService(minwatt, maxwatt);
        List<Long>capacityList=getBatterieslist.stream().map(object->object.getCapacity()).sorted().toList();
        if(determiner==0){
            VPPEntity vppEntity = new VPPEntity();
            double avgCapacity=capacityList.stream()
                    .mapToLong(Long::longValue)
                    .average().orElse(0.0);
            long totalCapacity = capacityList.stream()
                    .mapToLong(Long::longValue)
                    .sum();

            vppEntity.setAvgCapacity(avgCapacity);
            vppEntity.setTotalCapacity(totalCapacity);
            getBatterieslist.add(vppEntity);
            logger.info("Received request to get batteries with minwatt: {}, maxwatt: {}", minwatt, maxwatt);
        }
        else if(determiner==1){
            getBatterieslist=getBatterieslist.stream().
                    filter(object->object.getCapacity()==capacityList.get(0))
                    .collect(Collectors.toList());
            logger.info("Received request to get batteries with minwatt: {}", minwatt);
        }
        else if(determiner==2){
            getBatterieslist=getBatterieslist.stream().
                    filter(object->object.getCapacity()==capacityList.get(capacityList.size()-1))
                    .collect(Collectors.toList());
            logger.info("Received request to get batteries with maxwatt: {}", maxwatt);
        }

        return getBatterieslist;
    }

}
