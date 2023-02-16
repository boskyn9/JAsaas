package br.com.jasaas.enumeration;

public enum EndpointEnum {
    CITY("cities"),
    CUSTOMER("customers"),
    CUSTOMER_NOTIFICATION("customers/{id}/notifications"),
    CUSTOMER_PAYMENT("customers/{id}/payments"),
    CUSTOMER_SUBSCRIPTION("customers/{id}/subscriptions"),
    NOTIFICATION("notifications"),
    PAYMENT("payments"),
    SUBSCRIPTION("subscriptions"),
    SUBSCRIPTION_PAYMENT("subscriptions/{id}/payments"),
    WEBHOOK("webhook");

    private String endpoint;

    EndpointEnum(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
