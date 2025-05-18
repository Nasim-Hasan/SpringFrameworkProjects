package com.example.VPP.Service;


import com.example.VPP.Entity.VPPEntity;
import com.example.VPP.Repository.VPPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VPPService {
    @Autowired
    private VPPRepository vppRepository;

    public List<VPPEntity> createBatteriesService(List<VPPEntity> vppEntities){
          return vppRepository.saveAll(vppEntities);
    }
    public List<VPPEntity> getBatteriesService(long minwatt, long maxwatt) {
        return vppRepository.findByCapacityBetweenOrderByNameAsc(minwatt,maxwatt);
    }
}
