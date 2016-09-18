package com.learning.repository;

import com.learning.entity.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by amits on 15/09/16.
 */

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
