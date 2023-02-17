package br.com.jasaas.entity.meta;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 *
 * @author rafael
 */
public class MetaGeneric<T> {

    @Expose private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    @Expose private List<T> data;

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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
