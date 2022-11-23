package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.DiscountType;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

/**
 * Informações de juros para pagamento após o vencimento
 *
 * @author willian
 */
public class Interest {

    @Expose
    private BigDecimal value;
    @Expose
    private DiscountType type;

    public Interest() {
    }

    public Interest(BigDecimal value) {
        this.value = value;
    }

    public Interest(BigDecimal value, DiscountType type) {
        this.value = value;
        this.type = type;
    }
    /**
     *
     * @return value Percentual de juros ao mês sobre o valor da cobrança para
     * pagamento após o vencimento
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param value Percentual de juros ao mês sobre o valor da cobrança para
     * pagamento após o vencimento
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public DiscountType getType() {
        return type;
    }

    public void setType(DiscountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Interest{" + "value=" + value + ", type=" + type + '}';
    }

}
