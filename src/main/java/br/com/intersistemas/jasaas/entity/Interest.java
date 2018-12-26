package br.com.intersistemas.jasaas.entity;

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

    public Interest() {
    }

    public Interest(BigDecimal value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "Interest{" + "value=" + value + '}';
    }

}
