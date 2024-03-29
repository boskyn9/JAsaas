package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Subscription;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class MetaSubscription {

    @Expose private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    @Expose private Subscription[] data;

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

    public Subscription[] getData() {
        return data;
    }

    public void setData(Subscription[] data) {
        this.data = data;
    }

}
