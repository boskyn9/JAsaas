package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Representa uma entidade cidade com detalhes como seu ID, código IBGE, nome, distrito e estado.
 * Esta classe é usada para armazenar e manipular informações sobre uma cidade.
 * Ela é marcada como final, o que significa que não pode ser subclassificada.
 * <p>
 * Inclui métodos getters e setters para os campos: id, ibgeCode, name, districtCode, district e state.
 * A anotação {@link Expose} é usada para controlar a serialização e desserialização com Gson.
 * </p>
 *
 * @author bosco
 */
public final class City {

    @Expose private Integer id;
    @Expose private Integer ibgeCode;
    @Expose private String name;
    @Expose private Integer districtCode;
    @Expose private String district;
    @Expose private String state;

    /**
     * Obtém o identificador único da cidade.
     *
     * @return id Identificador único da cidade
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador único da cidade.
     *
     * @param id Identificador único da cidade
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o código IBGE da cidade.
     *
     * @return ibgeCode Código do IBGE da cidade
     */
    public Integer getIbgeCode() {
        return ibgeCode;
    }

    /**
     * Define o código IBGE da cidade.
     *
     * @param ibgeCode Código do IBGE da cidade
     */
    public void setIbgeCode(Integer ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    /**
     * Obtém o nome do município.
     *
     * @return name Nome do município
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do município.
     *
     * @param name Nome do município
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o código do distrito da cidade.
     *
     * @return districtCode Código do distrito
     */
    public Integer getDistrictCode() {
        return districtCode;
    }

    /**
     * Define o código do distrito da cidade.
     *
     * @param districtCode Código do distrito
     */
    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * Obtém o nome do distrito ao qual a cidade pertence.
     *
     * @return district Nome do distrito
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Define o nome do distrito ao qual a cidade pertence.
     *
     * @param district Nome do distrito
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Obtém a sigla do estado (por exemplo, SP, RJ) da cidade.
     *
     * @return state Sigla do estado da cidade
     */
    public String getState() {
        return state;
    }

    /**
     * Define a sigla do estado (por exemplo, SP, RJ) da cidade.
     *
     * @param state Sigla do estado da cidade
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retorna uma representação em string do objeto cidade, incluindo todos os seus campos.
     *
     * @return String Uma string representando a cidade
     */
    @Override
    public String toString() {
        return "City{" + "id=" + id + ", ibgeCode=" + ibgeCode + ", name=" + name + ", districtCode=" + districtCode + ", district=" + district + ", state=" + state + '}';
    }

}
