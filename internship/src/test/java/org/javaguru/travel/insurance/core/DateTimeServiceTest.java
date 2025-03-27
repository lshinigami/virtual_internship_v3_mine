package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTimeServiceTest {
    TravelCalculatePremiumRequest request;
    @BeforeEach
    public void setUp(){
        request = new TravelCalculatePremiumRequest(
                "Zhansaya", "Kalymova",
                new Date(), new Date()
        );
    }

    @Test
    public void getAgreementInDays() {
        DateTimeService dts = new DateTimeService();
        Long periodInDays = dts.calculateAgreementInDays(request);
    }
}
