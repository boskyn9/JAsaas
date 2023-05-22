package br.com.jasaas.entity;

import br.com.jasaas.enumeration.RefundStatus;
import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Estornos realizados
 *
 * @author willian
 */
public class Refund {

	@Expose(serialize = false)
	Date dateCreated;

	@Expose(serialize = false)
	String value;
	@Expose(serialize = false)
	String description;
	@Expose(serialize = false)
	String transactionReceiptUrl;
	@Expose(serialize = false)
	RefundStatus status;

	public Date getDateCreated() {
		return dateCreated;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	public String getTransactionReceiptUrl() {
		return transactionReceiptUrl;
	}

	public RefundStatus getStatus() {
		return status;
	}
}
