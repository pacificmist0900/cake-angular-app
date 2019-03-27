package com.waracle.cakemgr.cakemgr.service;

import com.waracle.cakemgr.cakemgr.dto.CakeToCakeDtoTransformer;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;
import com.waracle.cakemgr.cakemgr.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by prashantsharma on 24/03/2019.
 */
@Service("cakeService")
@Transactional
public class CakeServiceImpl implements CakeService {

    private CakeRepository cakeRepository;

    private CakeToCakeDtoTransformer cakeToCakeDtoTransformer;
    @Autowired
    public CakeServiceImpl(CakeRepository cakeRepository, CakeToCakeDtoTransformer cakeToCakeDtoTransformer) {
        this.cakeRepository = cakeRepository;
        this.cakeToCakeDtoTransformer = cakeToCakeDtoTransformer;
    }

    @Override
    public List<CakeDto> getAllCakes() {
        return cakeRepository.findAll().stream().map(cakeToCakeDtoTransformer::cakeToCakeDto).collect(Collectors.toList());
    }

    @Override
    public CakeDto getCake(String id) {
        return cakeToCakeDtoTransformer.cakeToCakeDto(cakeRepository.getOne(UUID.fromString(id)));
    }

    @Override
    public void saveCake(CakeDto cake) {
        cakeRepository.save(cakeToCakeDtoTransformer.cakeDtoToCake(cake));
    }

}