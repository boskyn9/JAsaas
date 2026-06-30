package br.com.jasaas;

import br.com.jasaas.entity.Taxes;
import br.com.jasaas.enumeration.PIsCofinsRetentionType;
import br.com.jasaas.enumeration.PisCofinsTaxStatus;
import br.com.jasaas.util.JsonUtil;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxesTest {

    @Test
    public void serializeNt007StandardTaxableOperation() {
        Taxes taxes = new Taxes();
        taxes.setUseTaxSystemReformNT007(true);
        taxes.setPisCofinsTaxStatus(PisCofinsTaxStatus.STANDARD_TAXABLE_OPERATION);
        taxes.setOperationPis(new BigDecimal("0.65"));
        taxes.setOperationCofins(new BigDecimal("3.00"));
        taxes.setPis(new BigDecimal("0.65"));
        taxes.setCofins(new BigDecimal("3.00"));
        taxes.setCsll(new BigDecimal("1.00"));
        taxes.setPisCofinsRetentionType(PIsCofinsRetentionType.WITHHELD);

        String json = JsonUtil.toJSON(taxes);

        Assert.assertTrue(json.contains("\"useTaxSystemReformNT007\":true"));
        Assert.assertTrue(json.contains("\"pisCofinsTaxStatus\":\"STANDARD_TAXABLE_OPERATION\""));
        Assert.assertTrue(json.contains("\"operationPis\":0.65"));
        Assert.assertTrue(json.contains("\"operationCofins\":3"));
        Assert.assertFalse(json.contains("pisCofinsRetentionType"));
    }

    @Test
    public void serializeNt007ZeroRateOperation() {
        Taxes taxes = new Taxes();
        taxes.setUseTaxSystemReformNT007(true);
        taxes.setPisCofinsTaxStatus(PisCofinsTaxStatus.ZERO_RATE_TAXABLE_OPERATION);
        taxes.setOperationPis(BigDecimal.ZERO);
        taxes.setOperationCofins(BigDecimal.ZERO);

        String json = JsonUtil.toJSON(taxes);

        Assert.assertTrue(json.contains("\"operationPis\":0"));
        Assert.assertTrue(json.contains("\"operationCofins\":0"));
    }

    @Test
    public void serializeNt007NonTaxableOperationOmitsNullOperationRates() {
        Taxes taxes = new Taxes();
        taxes.setUseTaxSystemReformNT007(true);
        taxes.setPisCofinsTaxStatus(PisCofinsTaxStatus.NON_TAXABLE_OPERATION);

        String json = JsonUtil.toJSON(taxes);

        Assert.assertFalse(json.contains("operationPis"));
        Assert.assertFalse(json.contains("operationCofins"));
    }

    @Test
    public void deserializeNt007ResponseWithCalculatedRetentionType() {
        String json = "{"
                + "\"pisCofinsTaxStatus\":\"STANDARD_TAXABLE_OPERATION\","
                + "\"operationPis\":0.65,"
                + "\"operationCofins\":3.00,"
                + "\"pisCofinsRetentionType\":\"PIS_COFINS_WITHHELD_CSLL_NOT_WITHHELD\","
                + "\"pis\":0.65,"
                + "\"cofins\":3.00,"
                + "\"csll\":1.00"
                + "}";

        Taxes taxes = (Taxes) JsonUtil.parse(json, Taxes.class);

        Assert.assertEquals(PisCofinsTaxStatus.STANDARD_TAXABLE_OPERATION, taxes.getPisCofinsTaxStatus());
        Assert.assertEquals(new BigDecimal("0.65"), taxes.getOperationPis());
        Assert.assertEquals(new BigDecimal("3.00"), taxes.getOperationCofins());
        Assert.assertEquals(PIsCofinsRetentionType.PIS_COFINS_WITHHELD_CSLL_NOT_WITHHELD, taxes.getPisCofinsRetentionType());
    }

    @Test
    public void pisCofinsTaxStatusFromCode() {
        Assert.assertEquals(PisCofinsTaxStatus.STANDARD_TAXABLE_OPERATION, PisCofinsTaxStatus.fromCode("01"));
        Assert.assertEquals(PisCofinsTaxStatus.ZERO_RATE_TAXABLE_OPERATION, PisCofinsTaxStatus.fromCode("06"));
        Assert.assertEquals(PisCofinsTaxStatus.NON_TAXABLE_OPERATION, PisCofinsTaxStatus.fromCode("08"));
        Assert.assertEquals(PisCofinsTaxStatus.EXEMPT_CONTRIBUTION_OPERATION, PisCofinsTaxStatus.fromCode("07"));
        Assert.assertEquals("01", PisCofinsTaxStatus.STANDARD_TAXABLE_OPERATION.getCode());
    }
}
