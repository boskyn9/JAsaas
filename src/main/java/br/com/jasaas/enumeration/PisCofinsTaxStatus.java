package br.com.jasaas.enumeration;

/**
 * Situação tributária do PIS/COFINS (CST) conforme NT-007 do padrão nacional de NFS-e.
 *
 * @see <a href="https://docs.asaas.com/page/breaking-changes">Breaking Changes NT-007</a>
 */
public enum PisCofinsTaxStatus {
    NONE("00"),
    STANDARD_TAXABLE_OPERATION("01"),
    DIFFERENTIATED_RATE_TAXABLE_OPERATION("02"),
    TAXABLE_PER_MEASURE_UNIT_OPERATION("03"),
    MONOPHASIC_RESALE_ZERO_RATE_OPERATION("04"),
    TAX_SUBSTITUTION_OPERATION("05"),
    ZERO_RATE_TAXABLE_OPERATION("06"),
    /**
     * @deprecated Substituído por {@link #EXEMPT_CONTRIBUTION_OPERATION}. Mantido para retrocompatibilidade.
     */
    @Deprecated
    TAXABLE_CONTRIBUTION_OPERATION("07"),
    EXEMPT_CONTRIBUTION_OPERATION("07"),
    NON_TAXABLE_OPERATION("08"),
    TAX_SUSPENSION_OPERATION("09");

    private final String code;

    PisCofinsTaxStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static PisCofinsTaxStatus fromCode(String code) {
        if (code == null) {
            return null;
        }
        PisCofinsTaxStatus match = null;
        for (PisCofinsTaxStatus status : values()) {
            if (status.code.equals(code)) {
                if (match == null || status == EXEMPT_CONTRIBUTION_OPERATION) {
                    match = status;
                }
            }
        }
        return match;
    }
}
