package com.crossasyst.mapping.onetoonemapper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
        private String firstName;
        private String lastName;

        private Address address;

}
