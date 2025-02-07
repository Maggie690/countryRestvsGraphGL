package com.example.countryRestvsGraphGL.entiies;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "countryId")
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long countryId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private int phone;

    @Column(name = "currency_symbol")
    private String currencySymbol;

    @Column(name = "capital")
    private String capital;

    @Column(name = "currency")
    private String currency;

    @Column(name = "alpha_3")
    private String alpha_3;

    @ManyToOne
    @JsonIgnoreProperties("countries")
    private Continent continent;
}
