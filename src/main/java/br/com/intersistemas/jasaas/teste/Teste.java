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
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.List;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
       
        String acessToken = "0ebde6de3835057f42291b64c21a0449f4aec2674b5ea28e748df298425370e4";

        Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_HOMOLOGACAO);
        
        
//        CustomerConnection conn = asaas.customer();        
//        List<Customer> lista = conn.getAll();
//        for (Customer customer : lista) {
//            System.out.println(customer);
//        }
//        PaymentFilter filter = new PaymentFilter();
//        filter.setExternalReference("15");
//        List<Payment> listaPay = connPay.getAll(filter);
//        for (Payment payment : listaPay) {
//            System.out.println(payment.getId());
//        }
//        
//        Payment p = new Payment();
//        p.setCustomer("cus_wFkaUbylBKNd");
//        p.setBillingType(Payment.BILLINGTYPE_BOLETO);
//        p.setValue(new BigDecimal(100));
//        p.setDueDate(new Date());
//        p.setDescription("Cobrança INTERPLACAS");
//        
//        p.setExternalReference("15");
//        
//        connPay.createPayment(p);
        
       
    }
}
