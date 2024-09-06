package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Representa uma entidade de erro que contém um código e uma descrição do erro.
 * Essa classe pode ser usada para capturar e manipular informações sobre erros que
 * ocorrem durante operações do sistema, como exceções ou falhas em requisições.
 * <p>
 * Os atributos code e description são expostos para serialização e desserialização
 * usando a biblioteca Gson através da anotação {@link Expose}.
 * </p>
 *
 * @author willian
 */
public class Erro {

    @Expose
    private String code;

    @Expose
    private String description;

    /**
     * Obtém o código do erro.
     *
     * @return code Código do erro
     */
    public String getCode() {
        return code;
    }

    /**
     * Define o código do erro.
     *
     * @param code Código do erro
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtém a descrição do erro.
     *
     * @return description Descrição do erro
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do erro.
     *
     * @param description Descrição do erro
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna uma representação em string do objeto de erro.
     *
     * @return Uma string contendo o código e a descrição do erro
     */
    @Override
    public String toString() {
        return "Erro{" + "code=" + code + ", description=" + description + '}';
    }
}
