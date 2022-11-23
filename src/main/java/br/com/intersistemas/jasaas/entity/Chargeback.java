package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.ChargebackReason;
import br.com.intersistemas.jasaas.util.ChargebackStatus;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

/**
 * Informações de extorno de pagamento
 *
 * @author willian
 */
public class Chargeback {

    @Expose
    private ChargebackStatus status;
    @Expose
    private ChargebackReason reason;

    public Chargeback() {
    }    

    /**
     *
     * @return Status do chargeback
     */
    public ChargebackStatus getStatus() {
        return status;
    }

    /**
     *
     * @param status Status do chargeback
     */
    public void setStatus(ChargebackStatus status) {
        this.status = status;
    }

    /**
     *
     * @return Motivo do chargeback
     */
    public ChargebackReason getReason() {
        return reason;
    }

    /**
     *
     * @param reason Motivo do chargeback
     */
    public void setReason(ChargebackReason reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Chargeback{" + "status=" + status + ", reason=" + status + '}';
    }

}
