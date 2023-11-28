package br.com.intersistemas.jasaas.exception;

import br.com.intersistemas.jasaas.entity.meta.MetaError;

import java.io.IOException;

/**
 * @author bosco
 */
public class ConnectionException extends RuntimeException {

    private int code;
    private MetaError metaError;

    public ConnectionException(int code, String message, MetaError metaError) {
        super(message);
        this.code = code;
        this.metaError = metaError;
    }

    public ConnectionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public MetaError getMetaError() {
        return metaError;
    }

    public void setMetaError(MetaError metaError) {
        this.metaError = metaError;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
