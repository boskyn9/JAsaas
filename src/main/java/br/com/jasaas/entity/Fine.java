package br.com.jasaas.entity;

import br.com.jasaas.enumeration.TypeValue;
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
    @Expose(serialize = false)
    private TypeValue type;

    public Fine() {
    }

    public Fine(BigDecimal value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "Fine{" + "value=" + value + '}';
    }

}
