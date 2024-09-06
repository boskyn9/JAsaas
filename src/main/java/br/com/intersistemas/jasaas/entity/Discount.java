package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.DiscountType;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

/**
 * Representa as informações de desconto aplicadas em uma transação ou cobrança.
 * <p>
 * Esta classe contém os detalhes sobre o valor do desconto, o número de dias limite para a data de vencimento
 * e o tipo de desconto (fixo ou percentual).
 * </p>
 *
 * <p>
 * A anotação {@link Expose} da biblioteca Gson é usada para controlar a serialização e a desserialização
 * dos campos.
 * </p>
 *
 * @author willian
 */
public class Discount {

    @Expose
    private BigDecimal value;  // Valor do desconto

    @Expose
    private Integer dueDateLimitDays;  // Número de dias limite até a data de vencimento para aplicar o desconto

    @Expose
    private DiscountType type;  // Tipo de desconto (fixo ou percentual)

    /**
     * Construtor para inicializar todas as propriedades do desconto.
     *
     * @param value O valor do desconto
     * @param dueDateLimitDays O número de dias limite até a data de vencimento
     * @param type O tipo de desconto
     */
    public Discount(BigDecimal value, Integer dueDateLimitDays, DiscountType type) {
        this.value = value;
        this.dueDateLimitDays = dueDateLimitDays;
        this.type = type;
    }

    /**
     * Construtor padrão sem argumentos.
     */
    public Discount() {
    }

    /**
     * Obtém o valor do desconto.
     *
     * @return O valor do desconto
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Define o valor do desconto.
     *
     * @param value O valor do desconto
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Obtém o número de dias limite até a data de vencimento para aplicar o desconto.
     *
     * @return O número de dias limite
     */
    public Integer getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    /**
     * Define o número de dias limite até a data de vencimento para aplicar o desconto.
     *
     * @param dueDateLimitDays O número de dias limite
     */
    public void setDueDateLimitDays(Integer dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
    }

    /**
     * Obtém o tipo de desconto.
     *
     * @return O tipo de desconto (fixo ou percentual)
     */
    public DiscountType getType() {
        return type;
    }

    /**
     * Define o tipo de desconto.
     *
     * @param type O tipo de desconto (fixo ou percentual)
     */
    public void setType(DiscountType type) {
        this.type = type;
    }

    /**
     * Retorna uma string representando o objeto de desconto, incluindo todas as suas propriedades.
     *
     * @return Uma string representando o desconto
     */
    @Override
    public String toString() {
        return "Discount{" + "value=" + value + ", dueDateLimitDays=" + dueDateLimitDays + ", type=" + type + '}';
    }
}
