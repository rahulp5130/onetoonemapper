package com.crossasyst.mapping.onetoonemapper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "person_info")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String firstName;
    private String lastName;


    @OneToOne(cascade = CascadeType.ALL)
   // @JsonIgnore
    @PrimaryKeyJoinColumn
    private AddressEntity address;
}
