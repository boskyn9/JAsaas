/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Pix;
import br.com.jasaas.entity.filter.PixFilter;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;

/**
 *
 * @author rafael
 */
public class PixConnection extends AsaasConnection<Pix, PixFilter> {

    public PixConnection(AdapterConnection httpClient, EnvironmentAsaas environmentAsaas) {
        super(environmentAsaas, httpClient, EndpointEnum.PIX);
        this.metaGenericClass = Pix.class;
    }

}
