package br.com.jasaas.entity;

import br.com.jasaas.enumeration.DiscountType;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 *
 * Informações de desconto
 *
 * @author willian
 */
public class Discount {

    @Expose
    private BigDecimal value;
    @Expose
    private Integer dueDateLimitDays;
    @Expose
    private DiscountType type;

    public Discount(BigDecimal value, Integer dueDateLimitDays, DiscountType type) {
        this.value = value;
        this.dueDateLimitDays = dueDateLimitDays;
        this.type = type;
    }

    public Discount() {
    }
    
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public void setDueDateLimitDays(Integer dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
    }

    public DiscountType getType() {
        return type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Discount{" + "value=" + value + ", dueDateLimitDays=" + dueDateLimitDays + ", type=" + type + '}';
    }
    
    
}
