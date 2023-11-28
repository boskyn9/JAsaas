package br.com.intersistemas.jasaas.teste;

import br.com.intersistemas.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.intersistemas.jasaas.api.*;
import br.com.intersistemas.jasaas.entity.*;
import br.com.intersistemas.jasaas.entity.meta.MetaCustomer;
import br.com.intersistemas.jasaas.util.BillingType;
import br.com.intersistemas.jasaas.util.Cycle;
import br.com.intersistemas.jasaas.util.DiscountType;
import br.com.intersistemas.jasaas.util.JsonUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, KeyStoreException, NoSuchAlgorithmException, CertificateException {

        String acessToken = "$aact_YTU5YTE0M2M2N2I4MTliNzk0YTI5N2U5MzdjNWZmNDQ6OjAwMDAwMDAwMDAwMDAwMDc3NDc6OiRhYWNoXzIxNTE4OTY2LWY3NWUtNGVjMC05M2U4LTUyMmE4YmUyODI0OA==";
        Asaas asaas = new Asaas(new ApacheHttpClientAdapter(acessToken), Asaas.AMBIENTE_PRODUCAO);
        PaymentConnection connPay = asaas.payment();
        CustomerConnection conn = asaas.customer();
        SubscriptionConnection subscriptionConnection = asaas.subscription();

//        String dataJson = "{ \"event\": \"PAYMENT_RECEIVED\", \"payment\": { \"object\": \"payment\", \"id\": \"pay_614896582179\", \"customer\": \"cus_k9c5dkgf82j9\", \"value\": 500.00, \"netValue\": 495.00, \"originalValue\": null, \"nossoNumero\": \"80516081\", \"description\": \"Pedido nr. 10598\", \"billingType\": \"BOLETO\", \"status\": \"RECEIVED\", \"dueDate\": \"07/05/2016\", \"paymentDate\": \"07/05/2016\", \"invoiceUrl\": \"https://www.asaas.com/i/614896582179\", \"boletoUrl\": \"https://www.asaas.com/b/pdf/614896582179\", \"invoiceNumber\": \"00932305\", \"externalReference\": null, \"deleted\": false } }";
//        WebhookPayment whp = Webhook.parseToPayment(dataJson);
//        System.out.println(whp.getEvent());
//        System.out.println(whp.getPayment().toString());      
        //tipos 0 getpayment, 1 payment create, 2 get customer, 3 creat customer
        int tipo = 5;

        switch (tipo) {
            case 0:
//                try {
//                    Payment pay = connPay.getById("pay_121566863590");
//                    System.out.println(pay);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;

            try {
                Customer customer = conn.getByExternalReference("550e8400e29b41d4a716446655440000");
                System.out.println(customer);
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
                p.setCustomer("cus_000005173845");
                p.setBillingType(BillingType.BOLETO);
                p.setValue(new BigDecimal("100.00"));
                Calendar calendar = Calendar.getInstance();
                p.setDueDate(LocalDate.now());
                p.setDescription("Teste boleto com desconto 20.0");
                p.setDiscount(new Discount(new BigDecimal("20"), 0, DiscountType.FIXED));
                p.setExternalReference("bol_2020");
                try {
                    Payment pCreated = connPay.createPayment(p);

                    LinhaBoleto linhaBoleto = connPay.getLinhaBoletoByIdBoleto(pCreated.getId());
                    QRCodePix qrCodePix = connPay.getQRCodeByIdBoleto(pCreated.getId());

                    System.out.println(pCreated);
                    System.out.println(linhaBoleto);
                    System.out.println(qrCodePix);
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
                    for (Customer custo : meta.getData()) {
                        System.out.println(custo.getId());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Customer customer = new Customer();
                customer.setName("J Willian");
                customer.setCpfCnpj("01353121321");
                customer.setEmail("jwillian@moc.rb");
                Customer cCreated = conn.createCustomer(customer);
                System.out.println("##################################");
                System.out.println(cCreated);
                System.out.println("##################################");
                break;
            case 4:
                Tokenize tokenize = new Tokenize();
                tokenize.setCustomer("cus_000072931275");
                tokenize.setCreditCard(
                        new CreditCard(
                                "Joao B",
                                "151515415",
                                "52",
                                "58",
                                "888"
                        ));
                tokenize.setCreditCardHolderInfo(
                        new CreditCardHolderInfo(
                                "Joao Bosco",
                                "bos@gmail.com",
                                "01354555321",
                                "58585855",
                                "12515",
                                "4848484849"
                        )
                );
                tokenize.setRemoteIp("189.124.215.62");
                TokenizeConnection tokenizeConn = asaas.tokenize();
                TokenizeResponse response = tokenizeConn.createTokenize(tokenize);
                System.out.println(response);
                break;
            case 5:
                Subscription subscription = new Subscription();
                subscription.setCustomer("cus_000072931275");
                subscription.setBillingType(BillingType.CREDIT_CARD);
                subscription.setValue(new BigDecimal(5));
                subscription.setNextDueDate(LocalDate.now().plusDays(20));
                subscription.setCycle(Cycle.MONTHLY);
                subscription.setCreditCard(
                        new CreditCard(
                                "Joao B",
                                "151515415",
                                "52",
                                "58",
                                "888"
                        )
                );
                subscription.setCreditCardHolderInfo(
                        new CreditCardHolderInfo(
                                "Joao Bosco",
                                "bos@gmail.com",
                                "01354555321",
                                "58585855",
                                "12515",
                                "4848484849"
                        )
                );
                subscription.setRemoteIp("4848484848");

                Subscription sCreated = subscriptionConnection.createSubscription(subscription);
                System.out.println(sCreated);
                break;
            default:
                break;
        }
    }
}
