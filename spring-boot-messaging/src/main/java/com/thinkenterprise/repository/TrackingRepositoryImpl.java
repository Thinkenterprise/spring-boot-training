package com.thinkenterprise.repository;

import com.thinkenterprise.domain.tracking.Tracking;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrackingRepositoryImpl implements TrackingRepository {

    private List<Tracking> trackingList = new ArrayList<>();

    @Override
    public Tracking save(Tracking entity) {
        trackingList.add(entity);
        return entity;
    }

    @Override
    public Iterable<Tracking> findAll() {
        return trackingList.subList(0, trackingList.size());
    }
}
