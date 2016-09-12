package com.learning.repository;

import com.learning.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 11/09/16.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
