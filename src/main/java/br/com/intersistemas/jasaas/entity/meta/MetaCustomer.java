package br.com.intersistemas.jasaas.entity.meta;

import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class MetaCustomer {

    @Expose private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    @Expose private ContentCustomer[] data;

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

    public ContentCustomer[] getData() {
        return data;
    }

    public void setData(ContentCustomer[] data) {
        this.data = data;
    }

}
