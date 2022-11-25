package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.DiscountType;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

/**
 * Informações de multa para pagamento após o vencimento
 *
 * @author willian
 */
public class Fine {

    @Expose
    private BigDecimal value;
    @Expose
    private DiscountType type;

    public Fine() {
    }

    public Fine(BigDecimal value) {
        this.value = value;
    }

    public Fine(BigDecimal value, DiscountType type) {
        this.value = value;
        this.type = type;
    }

    /**
     *
     * @return value Percentual de multa sobre o valor da cobrança para
     * pagamento após o vencimento
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param value Percentual de multa sobre o valor da cobrança para pagamento
     * após o vencimento
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
        return "Fine{" + "value=" + value + ", type=" + type + '}';
    }

}
