package com.learning.service;

import com.learning.entity.Company;
import com.learning.rest.EventWrapper;

/**
 * Created by amits on 17/09/16.
 */
public interface CompanyService {
    Company createCompany(Company company);

    Company createCompany(EventWrapper eventWrapper);
}
