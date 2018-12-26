package br.com.intersistemas.jasaas.teste;

import br.com.intersistemas.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.intersistemas.jasaas.api.Asaas;
import br.com.intersistemas.jasaas.api.CustomerConnection;
import br.com.intersistemas.jasaas.api.PaymentConnection;
import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.Discount;
import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.entity.meta.WebhookPayment;
import br.com.intersistemas.jasaas.util.BillingType;
import br.com.intersistemas.jasaas.util.DiscountType;
import br.com.intersistemas.jasaas.util.Webhook;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Calendar;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {

        String acessToken = "";
        Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_HOMOLOGACAO);
        PaymentConnection connPay = asaas.payment();
        CustomerConnection conn = asaas.customer();

//        String dataJson = "{ \"event\": \"PAYMENT_RECEIVED\", \"payment\": { \"object\": \"payment\", \"id\": \"pay_614896582179\", \"customer\": \"cus_k9c5dkgf82j9\", \"value\": 500.00, \"netValue\": 495.00, \"originalValue\": null, \"nossoNumero\": \"80516081\", \"description\": \"Pedido nr. 10598\", \"billingType\": \"BOLETO\", \"status\": \"RECEIVED\", \"dueDate\": \"07/05/2016\", \"paymentDate\": \"07/05/2016\", \"invoiceUrl\": \"https://www.asaas.com/i/614896582179\", \"boletoUrl\": \"https://www.asaas.com/b/pdf/614896582179\", \"invoiceNumber\": \"00932305\", \"externalReference\": null, \"deleted\": false } }";
//        WebhookPayment whp = Webhook.parseToPayment(dataJson);
//        System.out.println(whp.getEvent());
//        System.out.println(whp.getPayment().toString());      
        //tipos 0 getpayment, 1 payment create, 2 get customer, 3 creat customer
        int tipo = 1;

        switch (tipo) {
            case 0:
                try {
                    Payment pay = connPay.getById("pay_121566863590");
                    System.out.println(pay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // Atualiza os dados do cliente
//        cCreated.setEmail("bosc@liamg.moc.rb");
//        Customer cUpdated = conn.updateCustomer(cCreated);
//        System.out.println(cUpdated);
            // Deleta uma cliente
//        if (conn.deleteCustomer("cus_CwSGC4iu24GE")) {
//            System.out.println("apagou");
//        } else {
//            System.out.println("não apagou");
//        }
//        PaymentConnection connPay = asaas.payment();
//        System.out.println(connPay.getById("pay_035228980021"));
//        
//        if (connPay.deletePayment("pay_035228980021")) {
//            System.out.println("apagou");
//        } else {
//            System.out.println("não apagou");
//        }
//        String dataJson = "{ \"event\": \"PAYMENT_RECEIVED\", \"payment\": { \"object\": \"payment\", \"id\": \"pay_614896582179\", \"customer\": \"cus_k9c5dkgf82j9\", \"value\": 500.00, \"netValue\": 495.00, \"originalValue\": null, \"nossoNumero\": \"80516081\", \"description\": \"Pedido nr. 10598\", \"billingType\": \"BOLETO\", \"status\": \"RECEIVED\", \"dueDate\": \"07/05/2016\", \"paymentDate\": \"07/05/2016\", \"invoiceUrl\": \"https://www.asaas.com/i/614896582179\", \"boletoUrl\": \"https://www.asaas.com/b/pdf/614896582179\", \"invoiceNumber\": \"00932305\", \"externalReference\": null, \"deleted\": false } }";
//        WebhookPayment whp = Webhook.parseToPayment(dataJson);
//        System.out.println(whp.getPayment().toString());      
//        Payment p = connPay.getById("pay_681221591809");
//        p.setDescription("Cobrança GILPLACAS 2");
//        Payment pUpdated = connPay.updatePayment(p);
//        System.out.println(pUpdated);
//        if (connPay.deletePayment("pay_460610752937")) {
//            System.out.println("apagou");
//        } else {
//            System.out.println("não apagou");
//        }
            case 1:
                Payment p = new Payment();
                p.setCustomer("cus_000000064959");
                p.setBillingType(BillingType.BOLETO);
                p.setValue(new BigDecimal("100.00"));
                Calendar calendar = Calendar.getInstance();
                //        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        calendar.set(Calendar.DAY_OF_MONTH, 04);
                p.setDueDate(calendar.getTime());
                p.setDescription("Teste boleto com desconto 20.0");
                p.setDiscount(new Discount(new BigDecimal("20"), 0, DiscountType.FIXED));
                p.setExternalReference("bol_2020");
                try {
                    Payment pCreated = connPay.createPayment(p);
                    System.out.println(pCreated);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Customer custo = conn.getById("cus_000000064959");
                    System.out.println(custo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Customer customer = new Customer();
                customer.setName("J Willian");
                customer.setCpfCnpj("99999999999");
                customer.setEmail("jwillian@liamg.moc.rb");
                Customer cCreated = conn.createCustomer(customer);
                System.out.println("##################################");
                System.out.println(cCreated);
                System.out.println("##################################");
                break;
            default:
                break;
        }
    }
}
