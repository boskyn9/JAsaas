/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.exception.EndpointException;

/**
 *
 * @author bosco
 */
public abstract class AbstractConnection {

    private static final String ENDPOINT_PRODUCAO = "https://www.asaas.com/api/v2";
    private static final String ENDPOINT_HOMOLOGACAO = "http://homolog.asaas.com/api/v2";

    public static final int AMBIENTE_PRODUCAO = 1;
    public static final int AMBIENTE_HOMOLOGACAO = 2;

    public String endpoint;
    private Integer limit;
    private Integer offset;
    private Boolean hasMore;
    
    public AbstractConnection(int abstractConnectionEndpoint) {
        switch (abstractConnectionEndpoint) {
            case AMBIENTE_PRODUCAO:
                this.endpoint = ENDPOINT_PRODUCAO;
                break;
            case AMBIENTE_HOMOLOGACAO:
                this.endpoint = ENDPOINT_HOMOLOGACAO;
                break;
            default:
                throw new EndpointException("Endpoint não mapeando. Valores [1 - produção e 2 - homologação]", abstractConnectionEndpoint);
                
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    
    

}
