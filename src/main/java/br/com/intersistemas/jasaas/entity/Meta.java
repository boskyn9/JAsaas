package br.com.intersistemas.jasaas.entity;

/**
 *
 * @author bosco
 */
public class Meta {
    
    private Integer limit;
    private Integer offset;
    private Boolean hasMore;
    
    private Content[] data;

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

    public Content[] getData() {
        return data;
    }

    public void setData(Content[] data) {
        this.data = data;
    }

    
    
}
