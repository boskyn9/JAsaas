package br.com.intersistemas.jasaas.teste;


import br.com.intersistemas.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.intersistemas.jasaas.api.Asaas;
import br.com.intersistemas.jasaas.api.CustomerConnection;
import br.com.intersistemas.jasaas.entity.Customer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
       
        String acessToken = "0ebde6de3835057f42291b64c21a0449f4aec2674b5ea28e748df298425370e4";

        Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_HOMOLOGACAO);
        CustomerConnection conn = asaas.customer();
       
       for (Customer customer : conn.getAll()) {
           System.out.println(customer);
       }
    }
}
