package com.waracle.cakemgr.cakemgr.controller;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;
import com.waracle.cakemgr.cakemgr.service.CakeService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prashantsharma on 17/03/2019.
 */
@Api(value = "cakes", produces = "application/json", consumes = "application/json")
@RestController
@RequestMapping("/api")
@Slf4j
public class CakeController {


    private CakeService cakeService;

    @Autowired
    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping({"/", "/cakes"})
    public List<CakeDto> getCakes() {
        log.debug("Request received to get all cakes ");
        return cakeService.getAllCakes();
    }


    @PostMapping({"/cake"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createCake(@RequestBody CakeDto cake) {
        log.debug("Request received to add new cake ");
        cakeService.saveCake(cake);

    }

    @GetMapping("/cake/{id}")
    public CakeDto getCake(@PathVariable("id") String id) {
        log.debug("Request received to get cake for id " + id);
        return cakeService.getCake(id);
    }
}
