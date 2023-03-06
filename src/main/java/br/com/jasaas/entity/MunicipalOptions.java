package br.com.jasaas.entity;

import br.com.jasaas.enumeration.AuthenticationType;
import com.google.gson.annotations.Expose;

import java.util.List;

public class MunicipalOptions {
    @Expose(serialize = false)
    private AuthenticationType authenticationType;
    @Expose(serialize = false)
    private Boolean supportsCancellation;
    @Expose(serialize = false)
    private Boolean usesSpecialTaxRegimes;
    @Expose(serialize = false)
    private Boolean usesServiceListItem;
    @Expose(serialize = false)
    private Boolean usesStateInscription;
    @Expose(serialize = false)
    private List<SpecialTaxRegime> specialTaxRegimesList;
    @Expose(serialize = false)
    private String municipalInscriptionHelp;
    @Expose(serialize = false)
    private String specialTaxRegimeHelp;
    @Expose(serialize = false)
    private String serviceListItemHelp;
    @Expose(serialize = false)
    private String digitalCertificatedHelp;
    @Expose(serialize = false)
    private String accessTokenHelp;
    @Expose(serialize = false)
    private String municipalServiceCodeHelp;

    public MunicipalOptions() {
    }

    public MunicipalOptions(AuthenticationType authenticationType, Boolean supportsCancellation, Boolean usesSpecialTaxRegimes,
                            Boolean usesServiceListItem, Boolean usesStateInscription, List<SpecialTaxRegime> specialTaxRegimesList,
                            String municipalInscriptionHelp, String specialTaxRegimeHelp, String serviceListItemHelp,
                            String digitalCertificatedHelp, String accessTokenHelp, String municipalServiceCodeHelp) {
        this.authenticationType = authenticationType;
        this.supportsCancellation = supportsCancellation;
        this.usesSpecialTaxRegimes = usesSpecialTaxRegimes;
        this.usesServiceListItem = usesServiceListItem;
        this.usesStateInscription = usesStateInscription;
        this.specialTaxRegimesList = specialTaxRegimesList;
        this.municipalInscriptionHelp = municipalInscriptionHelp;
        this.specialTaxRegimeHelp = specialTaxRegimeHelp;
        this.serviceListItemHelp = serviceListItemHelp;
        this.digitalCertificatedHelp = digitalCertificatedHelp;
        this.accessTokenHelp = accessTokenHelp;
        this.municipalServiceCodeHelp = municipalServiceCodeHelp;
    }

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public Boolean getSupportsCancellation() {
        return supportsCancellation;
    }

    public void setSupportsCancellation(Boolean supportsCancellation) {
        this.supportsCancellation = supportsCancellation;
    }

    public Boolean getUsesSpecialTaxRegimes() {
        return usesSpecialTaxRegimes;
    }

    public void setUsesSpecialTaxRegimes(Boolean usesSpecialTaxRegimes) {
        this.usesSpecialTaxRegimes = usesSpecialTaxRegimes;
    }

    public Boolean getUsesServiceListItem() {
        return usesServiceListItem;
    }

    public void setUsesServiceListItem(Boolean usesServiceListItem) {
        this.usesServiceListItem = usesServiceListItem;
    }

    public Boolean getUsesStateInscription() {
        return usesStateInscription;
    }

    public void setUsesStateInscription(Boolean usesStateInscription) {
        this.usesStateInscription = usesStateInscription;
    }

    public List<SpecialTaxRegime> getSpecialTaxRegimesList() {
        return specialTaxRegimesList;
    }

    public void setSpecialTaxRegimesList(List<SpecialTaxRegime> specialTaxRegimesList) {
        this.specialTaxRegimesList = specialTaxRegimesList;
    }

    public String getMunicipalInscriptionHelp() {
        return municipalInscriptionHelp;
    }

    public void setMunicipalInscriptionHelp(String municipalInscriptionHelp) {
        this.municipalInscriptionHelp = municipalInscriptionHelp;
    }

    public String getSpecialTaxRegimeHelp() {
        return specialTaxRegimeHelp;
    }

    public void setSpecialTaxRegimeHelp(String specialTaxRegimeHelp) {
        this.specialTaxRegimeHelp = specialTaxRegimeHelp;
    }

    public String getServiceListItemHelp() {
        return serviceListItemHelp;
    }

    public void setServiceListItemHelp(String serviceListItemHelp) {
        this.serviceListItemHelp = serviceListItemHelp;
    }

    public String getDigitalCertificatedHelp() {
        return digitalCertificatedHelp;
    }

    public void setDigitalCertificatedHelp(String digitalCertificatedHelp) {
        this.digitalCertificatedHelp = digitalCertificatedHelp;
    }

    public String getAccessTokenHelp() {
        return accessTokenHelp;
    }

    public void setAccessTokenHelp(String accessTokenHelp) {
        this.accessTokenHelp = accessTokenHelp;
    }

    public String getMunicipalServiceCodeHelp() {
        return municipalServiceCodeHelp;
    }

    public void setMunicipalServiceCodeHelp(String municipalServiceCodeHelp) {
        this.municipalServiceCodeHelp = municipalServiceCodeHelp;
    }
}