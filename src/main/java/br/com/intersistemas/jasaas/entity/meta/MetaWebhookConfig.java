package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.WebhookConfig;
import com.google.gson.annotations.Expose;

/**
 * Classe espelho para paginação de WebhookConfig
 */
public class MetaWebhookConfig {

    @Expose
    private Integer limit;
    @Expose private Integer offset;
    @Expose private Boolean hasMore;

    // O pulo do gato: Aqui usamos o array da sua entidade nova
    @Expose private WebhookConfig[] data;

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

    public WebhookConfig[] getData() {
        return data;
    }

    public void setData(WebhookConfig[] data) {
        this.data = data;
    }
}
