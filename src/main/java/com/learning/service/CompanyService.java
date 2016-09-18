package com.learning.service;

import com.learning.entity.Company;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 17/09/16.
 */
public interface CompanyService {
    Company createCompany(Company company);
}
