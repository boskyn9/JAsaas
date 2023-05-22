package br.com.jasaas.entity.filter;

/**
 *
 * @author bosco
 */
public class CityFilter {

    private Integer id;
    private Integer ibgeCode;
    private String name;
    private Integer districtCode;
    private String district;
    private String state;

    public CityFilter() {
    }

    public CityFilter(Integer id, Integer ibgeCode, String name, Integer districtCode, String district, String state) {
        this.id = id;
        this.ibgeCode = ibgeCode;
        this.name = name;
        this.districtCode = districtCode;
        this.district = district;
        this.state = state;
    }

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

    }
