package br.com.intersistemas.jasaas.exception;

/**
 *
 * @author willian
 */
public class CustomerException extends RuntimeException {

    private int code;

    public CustomerException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
