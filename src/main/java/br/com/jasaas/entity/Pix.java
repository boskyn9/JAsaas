package br.com.jasaas.entity;

import br.com.jasaas.enumeration.PixType;
import com.google.gson.annotations.Expose;

import java.util.Date;


/**
 *
 * @author rafael
 */
public final class Pix extends AsaasEntity<String> {
    @Expose(serialize = false)
    private String id;
    @Expose
    private PixType type;
    @Expose(serialize = false)
    private String status;
    @Expose(serialize = false)
    private Date dateCreated;
    @Expose(serialize = false)
    private Boolean canBeDeleted;
    @Expose(serialize = false)
    private String cannotBeDeletedReason;
    @Expose(serialize = false)
    private QrCode qrCode;

    public Pix() {
    }

    public Pix(String id, PixType type, String status, Date dateCreated, Boolean canBeDeleted,
               String cannotBeDeletedReason, QrCode qrCode) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.dateCreated = dateCreated;
        this.canBeDeleted = canBeDeleted;
        this.cannotBeDeletedReason = cannotBeDeletedReason;
        this.qrCode = qrCode;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PixType getType() {
        return type;
    }

    public void setType(PixType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getCanBeDeleted() {
        return canBeDeleted;
    }

    public void setCanBeDeleted(Boolean canBeDeleted) {
        this.canBeDeleted = canBeDeleted;
    }

    public String getCannotBeDeletedReason() {
        return cannotBeDeletedReason;
    }

    public void setCannotBeDeletedReason(String cannotBeDeletedReason) {
        this.cannotBeDeletedReason = cannotBeDeletedReason;
    }

    public QrCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QrCode qrCode) {
        this.qrCode = qrCode;
    }

}
