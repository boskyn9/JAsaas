package br.com.jasaas.teste;

import br.com.jasaas.api.Asaas;
import br.com.jasaas.entity.Customer;
import br.com.jasaas.entity.filter.PaymentFilter;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.entity.Payment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {
        String apiKey = System.getenv("API_KEY_ASAAS") ;
        Asaas asaas = new Asaas(Ambiente.SANDBOX, apiKey);
        List<Customer> list = asaas.customer().getByCpfCnpj("31890545929");
        System.out.println(list);
/*
        Customer customer = null;
        if (!list.isEmpty()) {
            for (Customer customer1 : list) {
                asaas.customer().deleteCustomer(customer1.getId());
            }
        }
        //cria um cliente
        Customer customerRequest = new Customer();
        customerRequest.setName("Bosco Filho");
        customerRequest.setEmail("bos@liamg.moc.rb");
        customerRequest.setMobilePhone("8488888888");
        customerRequest.setCpfCnpj("31890545929");
        customerRequest.setPostalCode("59875-400");
        customerRequest.setAddress("Av. paulista");
        customerRequest.setAddressNumber("858");
        customerRequest.setProvince("Pitimbu");
        customerRequest.setCity("3550308");
        customer = asaas.customer().createCustomer(customerRequest);
*/
        Customer customer = list.get(0);

        //cria um pagamento

       /* Payment p = new Payment();
        p.setCustomer(customer.getId());
        p.setBillingType(BillingType.BOLETO);
        p.setValue(new BigDecimal(100));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, 03, 15);
        p.setDueDate(calendar.getTime());
        //p.setDueDate(new Date(2023, 03, 20));
        p.setDescription("Cobrança INTERPLACAS");
        p.setExternalReference("15");
        p.setDiscount(new Discount(BigDecimal.TEN, 1, DiscountType.PERCENTAGE));
        p.setFine(new Fine(new BigDecimal(2)));
        p.setInterest(new Interest(BigDecimal.ONE));
        Payment pCreated = asaas.payment().createPayment(p);
        System.out.println(pCreated);*/

        System.out.println(asaas.city().getAll());

        List<Payment> listaPay = asaas.payment().getAll(new PaymentFilter(null, customer.getId(), null, null, null));
        System.out.println(listaPay);

        // Retorna os dados da cobrança de acordo com o Id
//        PaymentConnection pay = asaas.payment();
//        Payment payment = pay.getById("pay_495842931739");

        // Retorna a listagem de cobranças de acordo com o Id do Cliente
//        PaymentConnection pay = asaas.payment();
//        List<Payment> payments = pay.getByCustomer("cus_wFkaUbylBKNd");

// Retorna a listagem de cobranças de acordo com o Id da Assinaturas
//        PaymentConnection pay = asaas.payment();
//        List<Payment> payments = pay.getBySubscriptions("sub_1cqNggmuHEnE");

// Insere uma nova cobrança




//        String dataJson = "{ \"event\": \"PAYMENT_RECEIVED\", \"payment\": { \"object\": \"payment\", \"id\": \"pay_614896582179\", \"customer\": \"cus_k9c5dkgf82j9\", \"value\": 500.00, \"netValue\": 495.00, \"originalValue\": null, \"nossoNumero\": \"80516081\", \"description\": \"Pedido nr. 10598\", \"billingType\": \"BOLETO\", \"status\": \"RECEIVED\", \"dueDate\": \"07/05/2016\", \"paymentDate\": \"07/05/2016\", \"invoiceUrl\": \"https://www.asaas.com/i/614896582179\", \"boletoUrl\": \"https://www.asaas.com/b/pdf/614896582179\", \"invoiceNumber\": \"00932305\", \"externalReference\": null, \"deleted\": false } }";
//        WebhookPayment whp = Webhook.parseToPayment(dataJson);
//        System.out.println(whp.getEvent());
//        System.out.println(whp.getPayment().toString());      
        //tipos 0 getpayment, 1 payment create, 2 get customer, 3 creat customer
/*        int tipo = 2;

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
//                    Customer custo = conn.getById("cus_000000064959");
//                    CustomerFilter customerFilter = new CustomerFilter();
//                    customerFilter.setCpfCnpj("66998940050");
//                    List<Customer> customerList = conn.getAll(customerFilter);
//
//                    for (Customer customer : customerList) {
//                        System.out.println(customer.getName());
//                    }
                    String json = "{\"object\":\"list\",\"hasMore\":false,\"totalCount\":1,\"limit\":10,\"offset\":0,\"data\":[{\"object\":\"customer\",\"id\":\"cus_000004744494\",\"dateCreated\":\"2021-10-13\",\"name\":\"Cliente de teste\",\"email\":\"pedroheavy87@gmail.com\",\"company\":null,\"phone\":null,\"mobilePhone\":null,\"address\":null,\"addressNumber\":null,\"complement\":null,\"province\":null,\"postalCode\":null,\"cpfCnpj\":\"66998940050\",\"personType\":\"FISICA\",\"deleted\":false,\"additionalEmails\":null,\"externalReference\":null,\"notificationDisabled\":false,\"observations\":null,\"city\":null,\"state\":null,\"country\":\"Brasil\",\"foreignCustomer\":false}]}";
                    MetaCustomer meta = (MetaCustomer) JsonUtil.parse(json, MetaCustomer.class);
                    for(Customer custo: meta.getData()){
                        System.out.println(custo.getId());
                    }

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
        }*/
    }
}
