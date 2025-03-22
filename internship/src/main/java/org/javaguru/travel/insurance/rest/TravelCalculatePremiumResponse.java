package org.javaguru.travel.insurance.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TravelCalculatePremiumResponse {

    private String personFirstName;
    private String personLastName;
    private LocalDate agreementDateFrom;
    private LocalDate agreementDateTo;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TravelCalculatePremiumResponse () {}

    public TravelCalculatePremiumResponse (String personFirstName, String personLastName, CharSequence agreementDateFrom, CharSequence agreementDateTo) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = LocalDate.parse(agreementDateFrom, formatter);
        this.agreementDateTo = LocalDate.parse(agreementDateTo, formatter);
    }

    public String getPersonFirstName () {
        return personFirstName;
    }

    public void setPersonFirstName (String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public CharSequence getAgreementDateFrom () {
        return agreementDateFrom.format(formatter);
    }

    public void setAgreementDateFrom (CharSequence agreementDateFrom) {
        this.agreementDateFrom = LocalDate.parse(agreementDateFrom, formatter);

    }

    public CharSequence getAgreementDateTo () {
        return agreementDateTo.format(formatter);
    }

    public void setAgreementDateTo (CharSequence agreementDateTo) {
        this.agreementDateTo = LocalDate.parse(agreementDateTo, formatter);
    }
}
