package com.naldojesse.license.services;

import com.naldojesse.license.models.License;
import com.naldojesse.license.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LicenseService {
    private LicenseRepository licenseRepository;
    public LicenseService (LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public void addLicense(License license) {
        licenseRepository.save(license);
    }

}
