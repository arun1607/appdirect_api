package com.learning.service.impl;

import com.learning.controller.ResponseErrorCode;
import com.learning.entity.Company;
import com.learning.exception.InvalidPayloadDataException;
import com.learning.repository.CompanyRepository;
import com.learning.rest.EventWrapper;
import com.learning.rest.Payload;
import com.learning.service.AbstractService;
import com.learning.service.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class CompanyServiceImpl extends AbstractService implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public Company createCompany(EventWrapper eventWrapper) {
        log.info("Creating Company ");
        Payload payload = eventWrapper.getPayload();
        if (Objects.isNull(payload)) {
            throw new InvalidPayloadDataException(ResponseErrorCode.INVALID_RESPONSE, "Payload can not be null");
        }
        Company company = payload.getCompany();
        if (Objects.isNull(company)) {
            throw new InvalidPayloadDataException(ResponseErrorCode.INVALID_RESPONSE, "Company can not be null");
        }
        Company existingCompany = companyRepository.findByUuid(company.getUuid());
        if (Objects.isNull(existingCompany)) {
            existingCompany = companyRepository.save(company);
        }
        payload.setCompany(existingCompany);
        return existingCompany;
    }

    @Transactional
    @Override
    public Company createCompany(Company company) {
        Company companyEntity = companyRepository.findByUuid(company.getUuid());
        if (Objects.isNull(companyEntity)) {
            companyEntity = companyRepository.save(company);
        }
        return companyEntity;
    }

}
