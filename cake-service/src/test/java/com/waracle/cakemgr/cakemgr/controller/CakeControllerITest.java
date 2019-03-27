package com.waracle.cakemgr.cakemgr.controller;


import com.waracle.cakemgr.cakemgr.AbstractIntegrationTest;
import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;
import com.waracle.cakemgr.cakemgr.mother.CakeMother;
import com.waracle.cakemgr.cakemgr.service.CakeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CakeControllerITest extends AbstractIntegrationTest {


    @MockBean
    private CakeService cakeService;

    @Autowired
    CakeController cakeController;

    @Test
    public void testAllCakes() throws Exception {

        List<CakeDto> cakes = givenCakeServiceReturnsCakes();
        assertEquals(cakes, cakeController.getCakes());

    }

    @Test
    public void testCakeById() throws Exception {

        CakeDto cakeDto = givenCakeServiceReturnsCakeForAnId();
        assertEquals(cakeDto, cakeController.getCake(cakeDto.getId().toString()));

    }

    @Test
    public void saveCakeOK() throws Exception {

       cakeController.createCake(CakeMother.buildCakeDto());

    }

    @Test(expected = IllegalArgumentException.class)
    public void saveCakeFail() {
        CakeDto cakeDto = CakeMother.buildCakeDto();
        cakeDto.setImage(null);

        cakeController.createCake(cakeDto);

    }

    private CakeDto givenCakeServiceReturnsCakeForAnId() {

        CakeDto cakeDto = CakeMother.buildCakeDtoWithId();
        when(cakeService.getCake(cakeDto.getId().toString())).thenReturn(cakeDto);
        return cakeDto;
    }

    private List<CakeDto> givenCakeServiceReturnsCakes() {

        CakeDto cakeDto = CakeMother.buildCakeDto();
        when(cakeService.getAllCakes()).thenReturn(Collections.singletonList(cakeDto));
        return Collections.singletonList(cakeDto);
    }


}
