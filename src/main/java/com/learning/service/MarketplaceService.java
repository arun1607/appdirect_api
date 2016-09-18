package com.learning.service;

import com.learning.entity.Marketplace;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by amits on 17/09/16.
 */
public interface MarketplaceService {
    Marketplace createMarketplace(Marketplace marketplace);
}
