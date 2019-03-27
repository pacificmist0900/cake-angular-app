package com.waracle.cakemgr.cakemgr.dto;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * Created by prashantsharma on 27/03/2019.
 */
@Component
public class CakeToCakeDtoTransformer {


    public CakeDto cakeToCakeDto(Cake cake){
       return CakeDto.builder()
               .id(cake.getId().toString())
               .description(cake.getDescription()).image(cake.getImage())
               .title(cake.getTitle()).build();

    }

    public Cake cakeDtoToCake(CakeDto cakeDto){
        Cake cake = new Cake();
        cake.setDescription(cakeDto.getDescription());
        cake.setImage(cake.getImage());
        cake.setTitle(cakeDto.getTitle());
        return cake;
    }
}
