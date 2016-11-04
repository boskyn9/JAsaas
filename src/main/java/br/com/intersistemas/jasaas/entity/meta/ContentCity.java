package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.City;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class ContentCity {

    @Expose private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
