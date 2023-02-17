package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class Taxes {
    @Expose
    private Boolean retainIss;
    @Expose
    private BigDecimal iss;
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

    public Taxes(Boolean retainIss, BigDecimal iss, BigDecimal cofins, BigDecimal csll, BigDecimal inss, BigDecimal ir, BigDecimal pis) {
        this.retainIss = retainIss;
        this.iss = iss;
        this.cofins = cofins;
        this.csll = csll;
        this.inss = inss;
        this.ir = ir;
        this.pis = pis;
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
