package com.waracle.cakemgr.cakemgr.repository;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by prashantsharma on 18/03/2019.
 */
@Repository
public interface CakeRepository extends JpaRepository<Cake, UUID> {
}
