package com.learning.service.impl;

import com.learning.entity.Marketplace;
import com.learning.exception.InvalidPayloadDataException;
import com.learning.repository.MarketplaceRepository;
import com.learning.rest.EventWrapper;
import com.learning.service.AbstractService;
import com.learning.service.MarketplaceService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class MarketplaceServiceImpl extends AbstractService implements MarketplaceService {
    @Autowired
    private MarketplaceRepository marketplaceRepository;

    @Override
    @Transactional
    public Marketplace createMarketplace(EventWrapper eventWrapper) {
        log.info("Creating marketplace ");
        Marketplace marketplace = eventWrapper.getMarketplace();
        if (Objects.isNull(marketplace)) {
            throw new InvalidPayloadDataException("Marketplace data ins missing");
        }
        List<Marketplace> existingMarketplaceList = marketplaceRepository.findByPartner(marketplace.getPartner());
        if (Objects.isNull(existingMarketplaceList) || existingMarketplaceList.isEmpty()) {
            marketplace = marketplaceRepository.save(marketplace);
        } else {
            marketplace = existingMarketplaceList.get(0);
        }
        eventWrapper.setMarketplace(marketplace);
        return marketplace;
    }

    @Transactional
    @Override
    public Marketplace createMarketplace(Marketplace marketplace) {
        List<Marketplace> existingMarketplaceList = marketplaceRepository.findByPartner(marketplace.getPartner());
        Marketplace marketplaceEntity;
        if (Objects.isNull(existingMarketplaceList) || existingMarketplaceList.isEmpty()) {
            marketplaceEntity = marketplaceRepository.save(marketplace);
        } else {
            marketplaceEntity = existingMarketplaceList.get(0);
        }
        return marketplaceEntity;
    }

}
