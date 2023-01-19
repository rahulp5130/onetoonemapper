package com.crossasyst.mapping.onetoonemapper.mapper;

import com.crossasyst.mapping.onetoonemapper.entity.AddressEntity;
import com.crossasyst.mapping.onetoonemapper.entity.PersonEntity;
import com.crossasyst.mapping.onetoonemapper.model.Address;
import com.crossasyst.mapping.onetoonemapper.model.PersonRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-19T11:58:32+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity modelToPersonEntity(PersonRequest personRequest) {
        if ( personRequest == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setFirstName( personRequest.getFirstName() );
        personEntity.setLastName( personRequest.getLastName() );
        personEntity.setAddress( modelToAddressEntity( personRequest.getAddress() ) );

        return personEntity;
    }

    @Override
    public PersonRequest entityToPersonModel(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonRequest personRequest = new PersonRequest();

        personRequest.setFirstName( personEntity.getFirstName() );
        personRequest.setLastName( personEntity.getLastName() );
        personRequest.setAddress( entityToAddressModel( personEntity.getAddress() ) );

        return personRequest;
    }

    @Override
    public List<PersonRequest> entityToModelList(List<PersonEntity> personEntities) {
        if ( personEntities == null ) {
            return null;
        }

        List<PersonRequest> list = new ArrayList<PersonRequest>( personEntities.size() );
        for ( PersonEntity personEntity : personEntities ) {
            list.add( entityToPersonModel( personEntity ) );
        }

        return list;
    }

    @Override
    public AddressEntity modelToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAddressOne( address.getAddressOne() );
        addressEntity.setAddressTwo( address.getAddressTwo() );
        addressEntity.setCity( address.getCity() );
        addressEntity.setState( address.getState() );
        addressEntity.setZipCode( address.getZipCode() );

        return addressEntity;
    }

    @Override
    public Address entityToAddressModel(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressOne( addressEntity.getAddressOne() );
        address.setAddressTwo( addressEntity.getAddressTwo() );
        address.setCity( addressEntity.getCity() );
        address.setState( addressEntity.getState() );
        address.setZipCode( addressEntity.getZipCode() );

        return address;
    }
}
