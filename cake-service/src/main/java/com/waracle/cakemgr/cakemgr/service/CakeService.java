package com.waracle.cakemgr.cakemgr.service;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;

import java.util.List;

/**
 * Created by prashantsharma on 24/03/2019.
 */
public interface CakeService {

    List<CakeDto> getAllCakes();

    CakeDto getCake(String id);

    void saveCake(CakeDto cake);
}
