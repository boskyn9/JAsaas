package br.com.jasaas.enumeration;

public enum EnvironmentAsaas {
    SANDBOX("https://sandbox.asaas.com/api/v3"),
    PRODUCTION("https://www.asaas.com/api/v3");

    private String endpoint;

    EnvironmentAsaas(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
