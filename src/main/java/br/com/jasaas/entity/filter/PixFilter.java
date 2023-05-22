package br.com.jasaas.entity.filter;

/**
 *
 * @author rafael
 */
public class PixFilter {

    private String status;
    private String statusList;

    public PixFilter() {
    }

    public PixFilter(String status, String statusList) {
        this.status = status;
        this.statusList = statusList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusList() {
        return statusList;
    }

    public void setStatusList(String statusList) {
        this.statusList = statusList;
    }
}
