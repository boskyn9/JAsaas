package br.com.jasaas.entity.meta;

import br.com.jasaas.entity.City;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class MetaCity {

    @Expose private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    @Expose private City[] data;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public City[] getData() {
        return data;
    }

    public void setData(City[] data) {
        this.data = data;
    }

}
