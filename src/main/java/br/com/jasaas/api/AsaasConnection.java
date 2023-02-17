/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.AsaasEntity;
import br.com.jasaas.entity.meta.DeletedEntityReturn;
import br.com.jasaas.entity.meta.MetaError;
import br.com.jasaas.entity.meta.MetaGeneric;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.HttpParamsUtil;
import br.com.jasaas.util.JsonUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafael
 */
public abstract class AsaasConnection<T extends AsaasEntity, F> {

    protected final Ambiente ambiente;
    protected final String templateGet = "%s/%s%slimit=%d&offset=%d";
    protected final String templateGetById = "%s/%s/%s";
    protected final String templateCreate = "%s/%s/";
    protected final String templateUpdate = "%s/%s/%s";
    protected final String templateDelete = "%s/%s/%s";

    protected final Logger logger = Logger.getLogger(this.getClass().getName());
    protected final AdapterConnection httpClient;
    protected final EndpointEnum endpoint;
    private Class<T> persistentClass;
    protected Class metaGenericClass;
    private Integer limit;
    private Integer offset;
    private Boolean hasMore;
    protected String lastResponseJson;

    public AsaasConnection(Ambiente ambiente, AdapterConnection httpClient, EndpointEnum endpoint) {
        this.ambiente = ambiente;
        this.httpClient = httpClient;
        this.endpoint = endpoint;
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
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


    public List<T> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<T> getAll(F filter) throws ConnectionException {
        return getAll(filter, null, null);
    }

    public List<T> getAll(F filter, Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }
            String params = HttpParamsUtil.parse(filter);
            String url = String.format(this.templateGet, this.ambiente.getEndpoint(), this.endpoint.getEndpoint(), params, limit, offset);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaGeneric<T> meta = (MetaGeneric<T>) JsonUtil.parse(lastResponseJson, this.metaGenericClass);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            return meta.getData();
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public T getById(String id) throws ConnectionException {
        try {
            String url = String.format(this.templateGetById, this.ambiente.getEndpoint(), this.endpoint.getEndpoint(), id);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            return (T) JsonUtil.parse(lastResponseJson, persistentClass.getClass());
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public T create(T entity) throws ConnectionException {
        if (entity.getId() == null) {
            try {
                String json = JsonUtil.toJSON(entity);
                String url = String.format(this.templateCreate, this.ambiente.getEndpoint(), this.endpoint.getEndpoint());
                this.logger.log(Level.INFO, "POST URL: {0}", url);
                this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
                lastResponseJson = httpClient.post(url, json);
                this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
                T created = (T) JsonUtil.parse(lastResponseJson, persistentClass);
                if (created.recordCreated()) {
                    MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                    throw new ConnectionException(500, error.toString());
                }
                return created;
            } catch (Exception ex) {
                this.logger.log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public T update(T entity) throws ConnectionException {
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format(this.templateUpdate, this.ambiente.getEndpoint(), this.endpoint.getEndpoint(), entity.getId());
            this.logger.log(Level.INFO, "PUT URL: {0}", url);
            this.logger.log(Level.INFO, "PUT PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "PUT RESPONSE: {0}", lastResponseJson);
            T updated = (T) JsonUtil.parse(lastResponseJson, persistentClass);
            if (updated.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString());
            }
            return updated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public T restore(String id) throws ConnectionException {
        try {
            String url = String.format(String.format("%s/restore", this.templateUpdate), this.ambiente.getEndpoint(), this.endpoint.getEndpoint(), id);
            this.logger.log(Level.INFO, "RESTORE URL: {0}", url);
            lastResponseJson = httpClient.post(url, "");
            this.logger.log(Level.INFO, "RESTORE RESPONSE: {0}", lastResponseJson);
            T restored = (T) JsonUtil.parse(lastResponseJson, persistentClass);
            if (restored.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString());
            }
            return restored;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean delete(String id) throws ConnectionException {
        try {
            String url = String.format(this.templateDelete, this.ambiente.getEndpoint(), this.endpoint.getEndpoint(), id);
            this.logger.log(Level.INFO, "DELETE URL: {0}", url);
            lastResponseJson = httpClient.delete(url);
            this.logger.log(Level.INFO, "DELETE RESPONSE: {0}", lastResponseJson);
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(lastResponseJson, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }


}
