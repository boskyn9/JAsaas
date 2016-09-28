package br.com.intersistemas.jasaas.entity;

import java.lang.reflect.Method;

/**
 *
 * @author bosco
 */
public final class City {

    /**
     * @var int
     */
    private Integer id;
    /**
     * @var int
     */
    private Integer ibgeCode;
    /**
     * @var string
     */
    private String name;
    /**
     * @var int
     */
    private Integer districtCode;
    /**
     * @var string
     */
    private String district;
    /**
     * @var string
     */
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(Integer ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", ibgeCode=" + ibgeCode + ", name=" + name + ", districtCode=" + districtCode + ", district=" + district + ", state=" + state + '}';
    }
    
  
}
