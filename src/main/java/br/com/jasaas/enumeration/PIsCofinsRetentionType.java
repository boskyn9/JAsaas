package br.com.jasaas.enumeration;

/**
 * Tipo de retenção de PIS/COFINS. A partir da NT-007, este valor é calculado automaticamente
 * pelo Asaas e não deve ser enviado nas requisições de emissão de NFS-e.
 *
 * @see <a href="https://docs.asaas.com/page/breaking-changes">Breaking Changes NT-007</a>
 */
public enum PIsCofinsRetentionType {
    PIS_COFINS_CSLL_NOT_WITHHELD,
    /**
     * @deprecated Calculado automaticamente pelo Asaas a partir da NT-007.
     */
    @Deprecated
    WITHHELD,
    /**
     * @deprecated Calculado automaticamente pelo Asaas a partir da NT-007.
     */
    @Deprecated
    NOT_WITHHELD,
    PIS_COFINS_CSLL_WITHHELD,
    PIS_COFINS_WITHHELD_CSLL_NOT_WITHHELD,
    PIS_WITHHELD_COFINS_CSLL_NOT_WITHHELD,
    COFINS_WITHHELD_PIS_CSLL_NOT_WITHHELD,
    PIS_NOT_WITHHELD_COFINS_CSLL_WITHHELD,
    PIS_COFINS_NOT_WITHHELD_CSLL_WITHHELD,
    COFINS_NOT_WITHHELD_PIS_CSLL_WITHHELD
}
