/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.enumeration.Ambiente;

/**
 *
 * @author bosco
 */
public abstract class AbstractConnection {

    protected final Ambiente ambiente;
    protected final String templateGet = "%s/%s%slimit=%d&offset=%d";
    protected final String templateGetById = "%s/%s/%d";
    protected final String templateCreate = "%s/%s/";
    protected final String templateUpdate = "%s/%s/%d";
    protected final String templateDelete = "%s/%s/%d";

    private Integer limit;
    private Integer offset;
    private Boolean hasMore;
    protected String lastResponseJson;
    
    public AbstractConnection(Ambiente ambiente) {
        this.ambiente = ambiente;
    }
    
    public String getLastResponseJson() {
        return lastResponseJson;
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
