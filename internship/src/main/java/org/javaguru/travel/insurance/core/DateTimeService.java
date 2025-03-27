package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeService {

    public Long calculateAgreementInDays(TravelCalculatePremiumRequest request) {
        LocalDate startDate = convertToLocalDate(request.getAgreementDateFrom());
        LocalDate endDate = convertToLocalDate(request.getAgreementDateTo());
        Long quantityOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        return quantityOfDays;
    }

    private LocalDate convertToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
