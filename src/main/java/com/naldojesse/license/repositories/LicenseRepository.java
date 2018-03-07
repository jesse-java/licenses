package com.naldojesse.license.repositories;

import com.naldojesse.license.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
}
