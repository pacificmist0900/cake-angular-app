package com.waracle.cakemgr.cakemgr.repository;

import com.waracle.cakemgr.cakemgr.AbstractIntegrationTest;
import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.mother.CakeMother;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CakeRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;


    @Autowired
    private CakeRepository cakeRepository;

    @Test
    public void testCakePersistAndSearch() {
        assertEquals(cakeRepository.findAll().size(), 1);
        addCake();
        List<Cake> cakeList = cakeRepository.findAll();
        assertEquals(cakeList.size(), 2);
    }

    private void addCake() {
        Cake cake = CakeMother.buildCake();
        entityManager.persist(cake);
        entityManager.flush();
    }


}