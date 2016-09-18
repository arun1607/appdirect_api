package com.learning.repository;

import com.learning.entity.Marketplace;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by amits on 15/09/16.
 */

public interface MarketplaceRepository extends PagingAndSortingRepository<Marketplace, Long> {

    List<Marketplace> findByPartner(String partner);
}
