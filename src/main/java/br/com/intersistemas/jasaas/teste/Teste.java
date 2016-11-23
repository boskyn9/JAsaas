package br.com.intersistemas.jasaas.teste;

import br.com.intersistemas.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.intersistemas.jasaas.api.Asaas;
import br.com.intersistemas.jasaas.api.CityConnection;
import br.com.intersistemas.jasaas.api.CustomerConnection;
import br.com.intersistemas.jasaas.api.PaymentConnection;
import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.entity.filter.CityFilter;
import br.com.intersistemas.jasaas.entity.filter.PaymentFilter;
import br.com.intersistemas.jasaas.entity.meta.WebhookPayment;
import br.com.intersistemas.jasaas.util.Webhook;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {

        String acessToken = "0ebde6de3835057f42291b64c21a0449f4aec2674b5ea28e748df298425370e4";
        Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_HOMOLOGACAO);

        CustomerConnection conn = asaas.customer();        
//        List<Customer> lista = conn.getAll();
//        for (Customer customer : lista) {
//            System.out.println(customer.getId());
//            System.out.println(customer.getName());
//        }

        // Insere um novo cliente
//        Customer customer = new Customer();
//        customer.setName("Bosco Filho");
//        customer.setEmail("bos@liamg.moc.rb");
//        customer.setMobilePhone("8488888888");
//        customer.setCpfCnpj("31890545929");
//        customer.setPostalCode("59875-400");
//        customer.setAddress("Av. paulista");
//        customer.setAddressNumber("858");
//        customer.setProvince("Pitimbu");
//        customer.setCity("3550308");
//
//        Customer cCreated = conn.createCustomer(customer);
//        System.out.println("##################################");
//        System.out.println(cCreated);
//        System.out.println("##################################");
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

//        
        //PaymentConnection connPay = asaas.payment();
//        List<Payment> listaPay = connPay.getAll();
//        for (Payment payment : listaPay) {
//            System.out.println("-------------------------");
//            System.out.println(payment.getId());
//            System.out.println(payment.getDueDate());
//            System.out.println(payment.getDescription());
//            System.out.println(payment.getExternalReference());
//        }
//        String dataJson = "{ \"event\": \"PAYMENT_RECEIVED\", \"payment\": { \"object\": \"payment\", \"id\": \"pay_614896582179\", \"customer\": \"cus_k9c5dkgf82j9\", \"value\": 500.00, \"netValue\": 495.00, \"originalValue\": null, \"nossoNumero\": \"80516081\", \"description\": \"Pedido nr. 10598\", \"billingType\": \"BOLETO\", \"status\": \"RECEIVED\", \"dueDate\": \"07/05/2016\", \"paymentDate\": \"07/05/2016\", \"invoiceUrl\": \"https://www.asaas.com/i/614896582179\", \"boletoUrl\": \"https://www.asaas.com/b/pdf/614896582179\", \"invoiceNumber\": \"00932305\", \"externalReference\": null, \"deleted\": false } }";
//        WebhookPayment whp = Webhook.parseToPayment(dataJson);
//        System.out.println(whp.getPayment().toString());
//        Payment p = new Payment();
//        p.setCustomer("cus_vy3J7OMs0kZf");
//        p.setBillingType(Payment.BILLINGTYPE_BOLETO);
//        p.setValue(new BigDecimal("404.35"));
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        calendar.set(Calendar.DAY_OF_MONTH, 23);
//        p.setDueDate(calendar.getTime());
//        p.setDescription("Cobrança GILPLACAS");
//        p.setExternalReference("bol_8657");
//
//        Payment pCreated = connPay.createPayment(p);
//        System.out.println(pCreated);
//        Payment p = connPay.getById("pay_681221591809");
//        p.setDescription("Cobrança GILPLACAS 2");
//        Payment pUpdated = connPay.updatePayment(p);
//        System.out.println(pUpdated);
//        if (connPay.deletePayment("pay_460610752937")) {
//            System.out.println("apagou");
//        } else {
//            System.out.println("não apagou");
//        }
    }
}
