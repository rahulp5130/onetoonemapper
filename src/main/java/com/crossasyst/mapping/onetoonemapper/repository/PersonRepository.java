package com.crossasyst.mapping.onetoonemapper.repository;

import com.crossasyst.mapping.onetoonemapper.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

}
