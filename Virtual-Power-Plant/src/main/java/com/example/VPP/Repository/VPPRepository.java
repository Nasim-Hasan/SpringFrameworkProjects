package com.example.VPP.Repository;

import com.example.VPP.Entity.VPPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VPPRepository extends JpaRepository<VPPEntity, Long> {
    List<VPPEntity> findByCapacityBetweenOrderByNameAsc(long minwatt, long maxwatt);
}
