package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Customer;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class ContentCustomer {

    @Expose
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
