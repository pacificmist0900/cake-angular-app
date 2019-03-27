package com.waracle.cakemgr.cakemgr.controller;

import com.google.common.collect.Lists;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;
import com.waracle.cakemgr.cakemgr.mother.CakeMother;
import com.waracle.cakemgr.cakemgr.service.CakeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by prashantsharma on 27/03/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class CakeControllerTest {

    @Mock
    CakeService cakeService;
    @Mock
    CakeDto cakeDto;
    CakeController cakeController;

    @Before
    public void before(){
        cakeController = new CakeController(cakeService);
    }


    @Test
    public void testgetCakes(){
        when(cakeService.getAllCakes()).thenReturn(Lists.newArrayList(cakeDto));
        assertEquals(Lists.newArrayList(cakeDto), cakeController.getCakes());
    }

    @Test
    public void testgetCakeById(){
        when(cakeService.getCake(CakeMother.CAKE_ID)).thenReturn(cakeDto);
        assertEquals(cakeDto, cakeController.getCake(CakeMother.CAKE_ID));
    }

    @Test
    public void testSaveCake(){
        cakeController.createCake(cakeDto);
        verify(cakeService).saveCake(cakeDto);

    }
}
