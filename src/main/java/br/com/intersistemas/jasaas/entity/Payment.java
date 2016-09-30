package br.com.intersistemas.jasaas.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bosco
 */
public final class Payment {


	public static final String PENDING = "PENDING";
	public static final String CONFIRMED = "CONFIRMED";
	public static final String RECEIVED = "RECEIVED";
	public static final String OVERDUE = "OVERDUE";


	private Integer id;
	private String customer;
	private String subscription;
	private String billingType;
	private BigDecimal value;
	private BigDecimal netValue;
	private BigDecimal originalValue;
	private BigDecimal interestValue;
	private BigDecimal grossValue;
	private Date dueDate;
	private String status;
	private String nossoNumero;
	private String description;
	private String invoiceNumber;
	private String invoiceUrl;
	private String boletoUrl;
	private Integer installment;
	private Integer installmentCount;
	private BigDecimal installmentValue;
	private String creditCardHolderName;
	private String creditCardNumber;
	private String creditCardExpiryMonth;
	private String creditCardExpiryYear;
	private String creditCardCcv;
	private String creditCardHolderFullName;
	private String creditCardHolderEmail;
	private String creditCardHolderCpfCnpj;
	private String creditCardHolderAddress;
	private String creditCardHolderAddressNumber;
	private String creditCardHolderAddressComplement;
	private String creditCardHolderProvince;
	private String creditCardHolderCity;
	private String creditCardHolderUf;
	private String creditCardHolderPostalCode;
	private String creditCardHolderPhone;
	private String creditCardHolderPhoneDDD;
	private String creditCardHolderMobilePhone;
	private String creditCardHolderMobilePhoneDDD;

	/**
	 * @return Identificador único da cobrança (Gerado pelo Asaas)
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Identificador único da cobrança (Gerado pelo Asaas)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Identificador único do cliente
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer Identificador único do cliente
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return Identificador único da assinatura, quando houver.
	 */
	public String getSubscription() {
		return subscription;
	}

	/**
	 * @param subscription Identificador único da assinatura, quando houver.
	 */
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	/**
	 * @return Identificador único do parcelamento, quando a cobrança fizer parte de um.
	 */
	public String getBillingType() {
		return billingType;
	}

	/**
	 * @param billingType Identificador único do parcelamento, quando a cobrança fizer parte de um.
	 */
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	/**
	 * @return Forma de pagamento.. Valores válidos: BOLETO, CREDIT_CARD, TRANSFER, DEPOSIT. Na criação, são aceitos somente BOLETO e CREDIT_CARD.
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * @param value Forma de pagamento.. Valores válidos: BOLETO, CREDIT_CARD, TRANSFER, DEPOSIT. Na criação, são aceitos somente BOLETO e CREDIT_CARD.
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * @return Valor da cobrança
	 */
	public BigDecimal getNetValue() {
		return netValue;
	}

	/**
	 * @param netValue Valor da cobrança
	 */
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	/**
	 * @return Valor líquido (calculado pelo Asaas)
	 */
	public BigDecimal getOriginalValue() {
		return originalValue;
	}

	/**
	 * @param originalValue Valor líquido (calculado pelo Asaas)
	 */
	public void setOriginalValue(BigDecimal originalValue) {
		this.originalValue = originalValue;
	}

	/**
	 * @return Valor original (preenchido somente quando a cobrança é  recebida com valor diferente do cadastrado) (somente leitura)
	 */
	public BigDecimal getInterestValue() {
		return interestValue;
	}

	/**
	 * @param interestValue Valor original (preenchido somente quando a cobrança é  recebida com valor diferente do cadastrado) (somente leitura)
	 */
	public void setInterestValue(BigDecimal interestValue) {
		this.interestValue = interestValue;
	}

	/**
	 * @return Valor de multa e juros, quando houver. (somente leitura)
	 */
	public BigDecimal getGrossValue() {
		return grossValue;
	}

	/**
	 * @param grossValue Valor de multa e juros, quando houver. (somente leitura)
	 */
	public void setGrossValue(BigDecimal grossValue) {
		this.grossValue = grossValue;
	}

	/**
	 * @return Valor bruto da cobrança. É válido somente se a opção de utilização do valor bruto estiver habilitada para a sua conta.
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate Valor bruto da cobrança. É válido somente se a opção de utilização do valor bruto estiver habilitada para a sua conta.
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return Data de vencimento.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status Data de vencimento.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return Data de vencimento original, definida na criação da cobrança.
	 */
	public String getNossoNumero() {
		return nossoNumero;
	}

	/**
	 * @param nossoNumero Data de vencimento original, definida na criação da cobrança.
	 */
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	/**
	 * @return Status da cobrança (Verificar tabela de status) (somente leitura)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description Status da cobrança (Verificar tabela de status) (somente leitura)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Identificador único do boleto bancário (somente leitura)
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber Identificador único do boleto bancário (somente leitura)
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return Descrição da cobrança
	 */
	public String getInvoiceUrl() {
		return invoiceUrl;
	}

	/**
	 * @param invoiceUrl Descrição da cobrança
	 */
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	/**
	 * @return Link público para a fatura (somente leitura)
	 */
	public String getBoletoUrl() {
		return boletoUrl;
	}

	/**
	 * @param boletoUrl Link público para a fatura (somente leitura)
	 */
	public void setBoletoUrl(String boletoUrl) {
		this.boletoUrl = boletoUrl;
	}

	/**
	 * @return Link público para download do PDF do boleto (somente leitura)
	 */
	public Integer getInstallment() {
		return installment;
	}

	/**
	 * @param installment Link público para download do PDF do boleto (somente leitura)
	 */
	public void setInstallment(Integer installment) {
		this.installment = installment;
	}

	/**
	 * @return Número da fatura (único) (somente leitura)
	 */
	public Integer getInstallmentCount() {
		return installmentCount;
	}

	/**
	 * @param installmentCount Número da fatura (único) (somente leitura)
	 */
	public void setInstallmentCount(Integer installmentCount) {
		this.installmentCount = installmentCount;
	}

	/**
	 * @return Quantia de parcelas (opcional)
	 */
	public BigDecimal getInstallmentValue() {
		return installmentValue;
	}

	/**
	 * @param installmentValue Quantia de parcelas (opcional)
	 */
	public void setInstallmentValue(BigDecimal installmentValue) {
		this.installmentValue = installmentValue;
	}

	/**
	 * @return Valor da parcela (obrigatório quando informado installmentCount > 1)
	 */
	public String getCreditCardHolderName() {
		return creditCardHolderName;
	}

	/**
	 * @param creditCardHolderName Valor da parcela (obrigatório quando informado installmentCount > 1)
	 */
	public void setCreditCardHolderName(String creditCardHolderName) {
		this.creditCardHolderName = creditCardHolderName;
	}

	/**
	 * @return Campo livre, pode ser usado para pesquisa.
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber Campo livre, pode ser usado para pesquisa.
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * @return Nome impresso no cartão de crédito
	 */
	public String getCreditCardExpiryMonth() {
		return creditCardExpiryMonth;
	}

	/**
	 * @param creditCardExpiryMonth Nome impresso no cartão de crédito
	 */
	public void setCreditCardExpiryMonth(String creditCardExpiryMonth) {
		this.creditCardExpiryMonth = creditCardExpiryMonth;
	}

	/**
	 * @return Número do cartão de crédito
	 */
	public String getCreditCardExpiryYear() {
		return creditCardExpiryYear;
	}

	/**
	 * @param creditCardExpiryYear Número do cartão de crédito
	 */
	public void setCreditCardExpiryYear(String creditCardExpiryYear) {
		this.creditCardExpiryYear = creditCardExpiryYear;
	}

	/**
	 * @return Mês de vencimento do cartão (01, 02, 03,..., 12)
	 */
	public String getCreditCardCcv() {
		return creditCardCcv;
	}

	/**
	 * @param creditCardCcv Mês de vencimento do cartão (01, 02, 03,..., 12)
	 */
	public void setCreditCardCcv(String creditCardCcv) {
		this.creditCardCcv = creditCardCcv;
	}

	/**
	 * @return Ano de vencimento do cartão, com 2 dígitos (14, 15, 16, ...)
	 */
	public String getCreditCardHolderFullName() {
		return creditCardHolderFullName;
	}

	/**
	 * @param creditCardHolderFullName Ano de vencimento do cartão, com 2 dígitos (14, 15, 16, ...)
	 */
	public void setCreditCardHolderFullName(String creditCardHolderFullName) {
		this.creditCardHolderFullName = creditCardHolderFullName;
	}

	/**
	 * @return Código de segurança do cartão de crédito
	 */
	public String getCreditCardHolderEmail() {
		return creditCardHolderEmail;
	}

	/**
	 * @param creditCardHolderEmail Código de segurança do cartão de crédito
	 */
	public void setCreditCardHolderEmail(String creditCardHolderEmail) {
		this.creditCardHolderEmail = creditCardHolderEmail;
	}

	/**
	 * @return Nome completo do dono do cartão de crédito
	 */
	public String getCreditCardHolderCpfCnpj() {
		return creditCardHolderCpfCnpj;
	}

	/**
	 * @param creditCardHolderCpfCnpj Nome completo do dono do cartão de crédito
	 */
	public void setCreditCardHolderCpfCnpj(String creditCardHolderCpfCnpj) {
		this.creditCardHolderCpfCnpj = creditCardHolderCpfCnpj;
	}

	/**
	 * @return E-mail do dono do cartão de crédito
	 */
	public String getCreditCardHolderAddress() {
		return creditCardHolderAddress;
	}

	/**
	 * @param creditCardHolderAddress E-mail do dono do cartão de crédito
	 */
	public void setCreditCardHolderAddress(String creditCardHolderAddress) {
		this.creditCardHolderAddress = creditCardHolderAddress;
	}

	/**
	 * @return CPF ou CNPJ do dono do cartão de crédito
	 */
	public String getCreditCardHolderAddressNumber() {
		return creditCardHolderAddressNumber;
	}

	/**
	 * @param creditCardHolderAddressNumber CPF ou CNPJ do dono do cartão de crédito
	 */
	public void setCreditCardHolderAddressNumber(String creditCardHolderAddressNumber) {
		this.creditCardHolderAddressNumber = creditCardHolderAddressNumber;
	}

	/**
	 * @return Endereço do dono do cartão de crédito (Ex.: Rua, Av.)
	 */
	public String getCreditCardHolderAddressComplement() {
		return creditCardHolderAddressComplement;
	}

	/**
	 * @param creditCardHolderAddressComplement Endereço do dono do cartão de crédito (Ex.: Rua, Av.)
	 */
	public void setCreditCardHolderAddressComplement(String creditCardHolderAddressComplement) {
		this.creditCardHolderAddressComplement = creditCardHolderAddressComplement;
	}

	/**
	 * @return Número do endereço do dono do cartão de crédito
	 */
	public String getCreditCardHolderProvince() {
		return creditCardHolderProvince;
	}

	/**
	 * @param creditCardHolderProvince Número do endereço do dono do cartão de crédito
	 */
	public void setCreditCardHolderProvince(String creditCardHolderProvince) {
		this.creditCardHolderProvince = creditCardHolderProvince;
	}

	/**
	 * @return Complemento do endereço do dono do cartão de crédito
	 */
	public String getCreditCardHolderCity() {
		return creditCardHolderCity;
	}

	/**
	 * @param creditCardHolderCity Complemento do endereço do dono do cartão de crédito
	 */
	public void setCreditCardHolderCity(String creditCardHolderCity) {
		this.creditCardHolderCity = creditCardHolderCity;
	}

	/**
	 * @return Bairro do dono do cartão de crédito
	 */
	public String getCreditCardHolderUf() {
		return creditCardHolderUf;
	}

	/**
	 * @param creditCardHolderUf Bairro do dono do cartão de crédito
	 */
	public void setCreditCardHolderUf(String creditCardHolderUf) {
		this.creditCardHolderUf = creditCardHolderUf;
	}

	/**
	 * @return Cidade do dono do cartão de crédito
	 */
	public String getCreditCardHolderPostalCode() {
		return creditCardHolderPostalCode;
	}

	/**
	 * @param creditCardHolderPostalCode Cidade do dono do cartão de crédito
	 */
	public void setCreditCardHolderPostalCode(String creditCardHolderPostalCode) {
		this.creditCardHolderPostalCode = creditCardHolderPostalCode;
	}

	/**
	 * @return UF do dono do cartão de crédito. (Ex: SC, SP, RJ)
	 */
	public String getCreditCardHolderPhone() {
		return creditCardHolderPhone;
	}

	/**
	 * @param creditCardHolderPhone UF do dono do cartão de crédito. (Ex: SC, SP, RJ)
	 */
	public void setCreditCardHolderPhone(String creditCardHolderPhone) {
		this.creditCardHolderPhone = creditCardHolderPhone;
	}

	/**
	 * @return CEP do dono do cartão de crédito
	 */
	public String getCreditCardHolderPhoneDDD() {
		return creditCardHolderPhoneDDD;
	}

	/**
	 * @param creditCardHolderPhoneDDD CEP do dono do cartão de crédito
	 */
	public void setCreditCardHolderPhoneDDD(String creditCardHolderPhoneDDD) {
		this.creditCardHolderPhoneDDD = creditCardHolderPhoneDDD;
	}

	/**
	 * @return Telefone do dono do cartão de crédito
	 */
	public String getCreditCardHolderMobilePhone() {
		return creditCardHolderMobilePhone;
	}

	/**
	 * @param creditCardHolderMobilePhone Telefone do dono do cartão de crédito
	 */
	public void setCreditCardHolderMobilePhone(String creditCardHolderMobilePhone) {
		this.creditCardHolderMobilePhone = creditCardHolderMobilePhone;
	}

	/**
	 * @return DDD do telefone do dono do cartão de crédito
	 */
	public String getCreditCardHolderMobilePhoneDDD() {
		return creditCardHolderMobilePhoneDDD;
	}

	/**
	 * @param creditCardHolderMobilePhoneDDD DDD do telefone do dono do cartão de crédito
	 */
	public void setCreditCardHolderMobilePhoneDDD(String creditCardHolderMobilePhoneDDD) {
		this.creditCardHolderMobilePhoneDDD = creditCardHolderMobilePhoneDDD;
	}



}
