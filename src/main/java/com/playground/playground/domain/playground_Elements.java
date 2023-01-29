package com.playground.playground.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Table(name="playground",schema="playground")
@Entity @Getter @Setter
public class playground_Elements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code1;
    private String code2;
    private String road_address1;
    private Boolean is_best;
    private String facility_open_code;
    private double longitude;
    private double latitude;




}
