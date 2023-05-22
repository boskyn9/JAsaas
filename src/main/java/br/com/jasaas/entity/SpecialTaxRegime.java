package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

public class SpecialTaxRegime {
    @Expose(serialize = false)
    private String label;
    @Expose(serialize = false)
    private String value;

    public SpecialTaxRegime() {
    }

    public SpecialTaxRegime(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
