package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class MunicipalService {
    @Expose(serialize = false)
    private String id;
    @Expose(serialize = false)
    private String description;
    @Expose(serialize = false)
    private BigDecimal iss;

    public MunicipalService() {
    }

    public MunicipalService(String id, String description, BigDecimal iss) {
        this.id = id;
        this.description = description;
        this.iss = iss;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }
}
