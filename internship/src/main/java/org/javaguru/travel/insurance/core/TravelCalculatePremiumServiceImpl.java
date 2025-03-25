package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse(request.getPersonFirstName(),
                request.getPersonLastName(),
                request.getAgreementDateFrom(),
                request.getAgreementDateTo());

        Period period = Period.between(LocalDate.parse(request.getAgreementDateFrom(), formatter), LocalDate.parse(request.getAgreementDateTo(), formatter));
        response.setAgreementPrice(new BigDecimal(String.valueOf(period)));
        return response;
    }
}
