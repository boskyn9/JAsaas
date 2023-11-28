package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.RefundStatus;
import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

/**
 * Estornos realizados
 *
 * @author willian
 */
public class Refund {

	@Expose(serialize = false)
	LocalDateTime dateCreated;
	@Expose(serialize = false)
	String value;
	@Expose(serialize = false)
	String description;
	@Expose(serialize = false)
	String transactionReceiptUrl;
	@Expose(serialize = false)
	RefundStatus status;

}
