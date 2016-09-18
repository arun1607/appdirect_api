package com.learning.service.impl;

import com.learning.entity.Marketplace;
import com.learning.repository.MarketplaceRepository;
import com.learning.service.AbstractService;
import com.learning.service.MarketplaceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class MarketplaceServiceImpl extends AbstractService implements MarketplaceService {
    @Autowired
    private MarketplaceRepository marketplaceRepository;

    @Transactional
    @Override
    public Marketplace createMarketplace(Marketplace marketplace) {
        List<Marketplace> existingMarketplaceList = marketplaceRepository.findByPartner(marketplace.getPartner());
        Marketplace marketplaceEntity;
        if (existingMarketplaceList.isEmpty()) {
            marketplaceEntity = marketplaceRepository.save(marketplace);
        } else {
            marketplaceEntity = existingMarketplaceList.get(0);
        }
        return marketplaceEntity;
    }

}
