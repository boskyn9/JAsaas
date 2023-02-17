package br.com.jasaas.entity;

public abstract class AsaasEntity<T> {
    public abstract T getId();

    public abstract boolean recordCreated();
}
