package com.learning.service;

import com.learning.entity.Marketplace;
import com.learning.entity.UserType;
import com.learning.rest.EventWrapper;

/**
 * Created by amits on 17/09/16.
 */
public interface MarketplaceService {
    Marketplace createMarketplace(Marketplace marketplace);

    Marketplace createMarketplace(EventWrapper eventWrapper);
}
