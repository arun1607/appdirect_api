package com.learning.service.impl;

import com.learning.entity.Company;
import com.learning.repository.CompanyRepository;
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
