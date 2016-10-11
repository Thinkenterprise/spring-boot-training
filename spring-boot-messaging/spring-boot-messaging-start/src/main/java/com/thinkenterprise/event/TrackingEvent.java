package com.thinkenterprise.event;

import com.thinkenterprise.domain.tracking.Tracking;

public class TrackingEvent {

    private Tracking tracking;

    public TrackingEvent(Tracking tracking) {
        this.tracking = tracking;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }
}
