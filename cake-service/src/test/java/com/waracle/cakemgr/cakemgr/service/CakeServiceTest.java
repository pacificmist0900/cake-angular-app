package com.waracle.cakemgr.cakemgr.service;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.dto.CakeToCakeDtoTransformer;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;
import com.waracle.cakemgr.cakemgr.mother.CakeMother;
import com.waracle.cakemgr.cakemgr.repository.CakeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by prashantsharma on 26/03/2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class CakeServiceTest {

    private CakeServiceImpl cakeService;
    @Mock
    private CakeRepository cakeRepository;

    @Mock
    private CakeToCakeDtoTransformer cakeToCakeDtoTransformer;

    @Mock
    private CakeDto cakeDto;
    @Mock
    private Cake cake;

    @Before
    public void before() {

        cakeService = new CakeServiceImpl(cakeRepository, cakeToCakeDtoTransformer);
        when(cakeToCakeDtoTransformer.cakeDtoToCake(cakeDto)).thenReturn(cake);


    }

    @Test
    public void getAllCakesTest() {
        cakeService.getAllCakes();
        verify(cakeRepository).findAll();
    }

    @Test
    public void saveCakeTest() {
        cakeService.saveCake(cakeDto);
        verify(cakeRepository).save(cake);
    }

    @Test
    public void getCakeTest() {
        cakeService.getCake(CakeMother.CAKE_ID);
        verify(cakeRepository).getOne(UUID.fromString(CakeMother.CAKE_ID));
    }


}
