package br.com.jasaas.entity;

import br.com.jasaas.enumeration.PIsCofinsRetentionType;
import br.com.jasaas.util.StringUtils;
import br.com.jasaas.enumeration.PisCofinsTaxStatus;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class Taxes {
    @Expose
    private String nbsCode;
    @Expose
    private String taxSituationCode;
    @Expose
    private String taxClassificationCode;
    @Expose
    private String operationIndicatorCode;
    @Expose
    private Boolean retainIss;
    @Expose
    private BigDecimal iss;
    /**
     * Calculado automaticamente pelo Asaas a partir da NT-007. Não deve ser enviado nas requisições.
     */
    @Expose(serialize = false)
    private PIsCofinsRetentionType pisCofinsRetentionType;
    @Expose
    private PisCofinsTaxStatus pisCofinsTaxStatus;
    @Expose
    private BigDecimal operationPis;
    @Expose
    private BigDecimal operationCofins;
    @Expose
    private Boolean useTaxSystemReformNT007;
    @Expose
    private BigDecimal cofins;
    @Expose
    private BigDecimal csll;
    @Expose
    private BigDecimal inss;
    @Expose
    private BigDecimal ir;
    @Expose
    private BigDecimal pis;

    public Taxes() {
    }

    public Taxes(String nbsCode, String taxSituationCode, String taxClassificationCode, String operationIndicatorCode,
                 Boolean retainIss, BigDecimal iss, PIsCofinsRetentionType pisCofinsRetentionType, PisCofinsTaxStatus pisCofinsTaxStatus,
                 BigDecimal cofins, BigDecimal csll, BigDecimal inss, BigDecimal ir, BigDecimal pis) {
        this.nbsCode = nbsCode;
        this.taxSituationCode = taxSituationCode;
        this.taxClassificationCode = taxClassificationCode;
        this.operationIndicatorCode = operationIndicatorCode;
        this.retainIss = retainIss;
        this.iss = iss;
        this.pisCofinsRetentionType = pisCofinsRetentionType;
        this.pisCofinsTaxStatus = pisCofinsTaxStatus;
        this.cofins = cofins;
        this.csll = csll;
        this.inss = inss;
        this.ir = ir;
        this.pis = pis;
    }

    public String getNbsCode() {
        return nbsCode;
    }

    public void setNbsCode(String nbsCode) {
        this.nbsCode = StringUtils.removerAcentos(nbsCode);
    }

    public String getTaxSituationCode() {
        return taxSituationCode;
    }

    public void setTaxSituationCode(String taxSituationCode) {
        this.taxSituationCode = StringUtils.removerAcentos(taxSituationCode);
    }

    public String getTaxClassificationCode() {
        return taxClassificationCode;
    }

    public void setTaxClassificationCode(String taxClassificationCode) {
        this.taxClassificationCode = StringUtils.removerAcentos(taxClassificationCode);
    }

    public String getOperationIndicatorCode() {
        return operationIndicatorCode;
    }

    public void setOperationIndicatorCode(String operationIndicatorCode) {
        this.operationIndicatorCode = StringUtils.removerAcentos(operationIndicatorCode);
    }

    public Boolean getRetainIss() {
        return retainIss;
    }

    public void setRetainIss(Boolean retainIss) {
        this.retainIss = retainIss;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public PIsCofinsRetentionType getPisCofinsRetentionType() {
        return pisCofinsRetentionType;
    }

    public void setPisCofinsRetentionType(PIsCofinsRetentionType pisCofinsRetentionType) {
        this.pisCofinsRetentionType = pisCofinsRetentionType;
    }

    public PisCofinsTaxStatus getPisCofinsTaxStatus() {
        return pisCofinsTaxStatus;
    }

    public void setPisCofinsTaxStatus(PisCofinsTaxStatus pisCofinsTaxStatus) {
        this.pisCofinsTaxStatus = pisCofinsTaxStatus;
    }

    public BigDecimal getOperationPis() {
        return operationPis;
    }

    public void setOperationPis(BigDecimal operationPis) {
        this.operationPis = operationPis;
    }

    public BigDecimal getOperationCofins() {
        return operationCofins;
    }

    public void setOperationCofins(BigDecimal operationCofins) {
        this.operationCofins = operationCofins;
    }

    public Boolean getUseTaxSystemReformNT007() {
        return useTaxSystemReformNT007;
    }

    public void setUseTaxSystemReformNT007(Boolean useTaxSystemReformNT007) {
        this.useTaxSystemReformNT007 = useTaxSystemReformNT007;
    }

    public BigDecimal getCofins() {
        return cofins;
    }

    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
    }

    public BigDecimal getCsll() {
        return csll;
    }

    public void setCsll(BigDecimal csll) {
        this.csll = csll;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getIr() {
        return ir;
    }

    public void setIr(BigDecimal ir) {
        this.ir = ir;
    }

    public BigDecimal getPis() {
        return pis;
    }

    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }
}
