package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse(request.getPersonFirstName(),
                request.getPersonLastName(),
                request.getAgreementDateFrom(),
                request.getAgreementDateTo());
        Long period = calculateAgreementInDays(request);
        response.setAgreementPrice(new BigDecimal(period));
        return response;
    }

    @Override
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
