package com.crossasyst.mapping.onetoonemapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "add_info")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "address_one")
    private String addressOne;
    @Column(name = "address_two")
    private String addressTwo;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip_code")
    private String zipCode;

    //@MapsId
    @OneToOne( fetch =FetchType.LAZY,   mappedBy = "address")
    //@JoinColumn(name = "address_id")
    @PrimaryKeyJoinColumn
    private PersonEntity person;
}
