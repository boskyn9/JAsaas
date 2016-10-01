package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;


/**
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
     * @return id Identificador único da cidade
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id Identificador único da cidade
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ibgeCode Código do IBGE da cidade
     */
    public Integer getIbgeCode() {
        return ibgeCode;
    }

    /**
     * @param ibgeCode Código do IBGE da cidade
     */
    public void setIbgeCode(Integer ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    /**
     * @return name Nome do município
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Nome do município
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return districtCode Código do distrito
     */
    public Integer getDistrictCode() {
        return districtCode;
    }

    /**
     * @param districtCode Código do distrito
     */
    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * @return district Nome do distrito
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district Nome do distrito
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return state Sigla do estado da cidade
     */
    public String getState() {
        return state;
    }

    /**
     * @param state Sigla do estado da cidade
     */
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", ibgeCode=" + ibgeCode + ", name=" + name + ", districtCode=" + districtCode + ", district=" + district + ", state=" + state + '}';
    }

}
