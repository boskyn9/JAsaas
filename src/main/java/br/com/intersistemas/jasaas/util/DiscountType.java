package br.com.intersistemas.jasaas.util;

/**
 * Enumeração que representa os diferentes tipos de desconto aplicáveis.
 *
 * Existem dois tipos de desconto:
 * <ul>
 *   <li>{@code FIXED}: Representa um valor fixo de desconto.</li>
 *   <li>{@code PERCENTAGE}: Representa um valor percentual de desconto.</li>
 * </ul>
 *
 *
 * @author willian
 */
public enum DiscountType {
    /**
     * Desconto de valor fixo.
     */
    FIXED, // Valor fixo

    /**
     * Desconto baseado em percentual.
     */
    PERCENTAGE, // Valor percentual
}
