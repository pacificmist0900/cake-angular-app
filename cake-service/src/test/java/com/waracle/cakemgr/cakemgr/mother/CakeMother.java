package com.waracle.cakemgr.cakemgr.mother;

import com.waracle.cakemgr.cakemgr.domain.Cake;
import com.waracle.cakemgr.cakemgr.dto.CakeDto;

import java.util.UUID;

/**
 * Created by prashantsharma on 24/03/2019.
 */
public class CakeMother {

    public static final String CAKE_TITLE = "CARROT CAKE";
    public static final String CAKE_IMAGE = "http://localhost:8080/carrot.png";
    public static final String CAKE_DESCRIPTION = "CARROT CAKE WITH SUGAR";
    public static final String CAKE_ID = "4bf6793a-d43b-4f93-8a51-769e6d456610";
    public static final UUID CAKE_UUID = UUID.fromString(CAKE_ID);

    public static Cake buildCake() {
        Cake cake = new Cake();
        cake.setDescription(CAKE_DESCRIPTION);
        cake.setTitle(CAKE_TITLE);
        cake.setImage(CAKE_IMAGE);
        return cake;
    }

    public static CakeDto buildCakeDto() {

        return CakeDto.builder()
                .image(CAKE_IMAGE)
                .description(CAKE_DESCRIPTION).title(CAKE_TITLE).build();

    }

    public static Cake buildCakeWithId() {
        Cake cake = new Cake();
        cake.setDescription(CAKE_DESCRIPTION);
        cake.setTitle(CAKE_TITLE);
        cake.setImage(CAKE_IMAGE);
        cake.setId(CAKE_UUID);
        return cake;
    }

    public static CakeDto buildCakeDtoWithId() {
        return CakeDto.builder().image(CAKE_IMAGE).description(CAKE_DESCRIPTION).title(CAKE_TITLE).id(CAKE_ID).build();
    }
}
