package br.com.jasaas.enumeration;

public enum Ambiente {
    SANDBOX("https://sandbox.asaas.com/api/v3"),
    PRODUCTION("https://www.asaas.com/api/v3");

    private String endpoint;

    Ambiente(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
