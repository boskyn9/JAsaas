package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Payment;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class MetaPayment {

    @Expose private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    // Na homologação foi identificado que o content não possue um objeto payment
    @Expose private Payment[] data;

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

    public Payment[] getData() {
        return data;
    }

    public void setData(Payment[] data) {
        this.data = data;
    }

}
