package com.thinkenterprise.repository;

import com.thinkenterprise.domain.tracking.Tracking;

public interface TrackingRepository {
    Tracking save(Tracking entity);

    Iterable<Tracking> findAll();
}
