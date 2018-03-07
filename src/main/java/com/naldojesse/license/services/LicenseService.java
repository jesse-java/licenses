package com.naldojesse.license.services;

import com.naldojesse.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LicenseService {
    private LicenseRepository licenseRepository;
    public LicenseService (LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

//    public void addLicense(String number, String state, String expiration_date) throws ParseException {
//        Date date=new SimpleDateFormat("MM/dd/yyyy").parse(expiration_date);
////        licenseRepository.save(number, state, date);
//    }

    public void addLicense(license) {
        licenseRepository.save(license);
    }

}
