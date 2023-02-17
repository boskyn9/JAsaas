package br.com.jasaas.enumeration;

/**
 *
 * @author atendimento
 */
public enum SubscriptionStatus {
    ACTIVE, //Ativa (enquanto houver mensalidades a serem geradas)
    EXPIRED //Expirada (quando não há mais mensalidades a serem geradas por ter excedido a data limite ou número de mensalidades)
}
