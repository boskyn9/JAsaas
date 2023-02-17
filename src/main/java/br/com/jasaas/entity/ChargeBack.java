package br.com.jasaas.entity;

import br.com.jasaas.enumeration.ChargeBackStatus;
import com.google.gson.annotations.Expose;

/**
 * Informações de chargeback caso possuir
 *
 * @author willian
 */
public class ChargeBack {

    @Expose(serialize = false)
    ChargeBackStatus status;
    @Expose(serialize = false)
    ChargeBackStatus reason;
}
