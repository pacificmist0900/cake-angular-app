package com.waracle.cakemgr.cakemgr.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Data
@Entity
@NoArgsConstructor
@Table(name = "Cake", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Cake implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private UUID id;
    @Column(name = "title", unique = true, nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "image", nullable = false, length = 300)
    private String image;


}