package br.com.intersistemas.jasaas.util;

/**
 * Enumeração que define a periodicidade da cobrança.
 * Cada valor representa uma frequência específica de cobrança.
 *
 * <ul>
 *   <li>{@code WEEKLY} - Cobrança semanal.</li>
 *   <li>{@code BIWEEKLY} - Cobrança quinzenal (a cada 2 semanas).</li>
 *   <li>{@code MONTHLY} - Cobrança mensal.</li>
 *   <li>{@code QUARTERLY} - Cobrança trimestral.</li>
 *   <li>{@code SEMIANNUALLY} - Cobrança semestral.</li>
 *   <li>{@code YEARLY} - Cobrança anual.</li>
 * </ul>
 *
 * @author willian
 */
public enum Cycle {
    /**
     * Cobrança semanal.
     */
    WEEKLY,

    /**
     * Cobrança quinzenal (a cada 2 semanas).
     */
    BIWEEKLY,

    /**
     * Cobrança mensal.
     */
    MONTHLY,

    /**
     * Cobrança trimestral.
     */
    QUARTERLY,

    /**
     * Cobrança semestral.
     */
    SEMIANNUALLY,

    /**
     * Cobrança anual.
     */
    YEARLY
}
