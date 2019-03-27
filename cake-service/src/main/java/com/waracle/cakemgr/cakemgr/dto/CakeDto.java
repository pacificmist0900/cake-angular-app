package com.waracle.cakemgr.cakemgr.dto;

import lombok.*;

/**
 * Created by prashantsharma on 27/03/2019.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CakeDto {

    private String id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String image;


}