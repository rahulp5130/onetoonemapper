package com.crossasyst.mapping.onetoonemapper.mapper;

import com.crossasyst.mapping.onetoonemapper.entity.AddressEntity;
import com.crossasyst.mapping.onetoonemapper.entity.PersonEntity;
import com.crossasyst.mapping.onetoonemapper.model.Address;
import com.crossasyst.mapping.onetoonemapper.model.PersonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    public PersonEntity modelToPersonEntity(PersonRequest personRequest);

    public PersonRequest entityToPersonModel(PersonEntity personEntity);

    List<PersonRequest> entityToModelList(List<PersonEntity> personEntities);

   public AddressEntity modelToAddressEntity(Address address);

   //public AddressRequest entityToAddressModel(AddressEntity addressEntity);

   public Address entityToAddressModel(AddressEntity addressEntity);


}
