package com.learning.repository;

import com.learning.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 15/09/16.
 */

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    Company findByUuid(String uuid);
}