package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 *
 * @author willian
 */
public class Split {

    @Expose
    private String walletId;
    @Expose
    private BigDecimal fixedValue;
    @Expose
    private BigDecimal percentualValue;

    @Expose(serialize = false)
    private String status;
    @Expose(serialize = false)
    private String refusalReason;

    /**
     *
     * @return Identificador da carteira (retornado no momento da criação da
     * conta)
     */
    public String getWalletId() {
        return walletId;
    }

    /**
     *
     * @param walletId Identificador da carteira (retornado no momento da
     * criação da conta)
     */
    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    /**
     *
     * @return Valor fixo a ser transferido para a conta quando a cobrança for
     * recebida
     */
    public BigDecimal getFixedValue() {
        return fixedValue;
    }

    /**
     *
     * @param fixedValue Valor fixo a ser transferido para a conta quando a
     * cobrança for recebida
     */
    public void setFixedValue(BigDecimal fixedValue) {
        this.fixedValue = fixedValue;
    }

    /**
     *
     * @return Percentual sobre o valor líquido da cobrança a ser transferido
     * quando for recebida
     */
    public BigDecimal getPercentualValue() {
        return percentualValue;
    }

    /**
     *
     * @param percentualValue Percentual sobre o valor líquido da cobrança a ser
     * transferido quando for recebida
     */
    public void setPercentualValue(BigDecimal percentualValue) {
        this.percentualValue = percentualValue;
    }

    public String getStatus() {
        return status;
    }

    public String getRefusalReason() {
        return refusalReason;
    }
}
