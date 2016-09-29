/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.teste;

import br.com.intersistemas.jasaas.adapter.HttpAdapter;
import br.com.intersistemas.jasaas.api.AbstractConnection;
import br.com.intersistemas.jasaas.api.Asaas;
import br.com.intersistemas.jasaas.api.CityConnection;
import br.com.intersistemas.jasaas.api.CustomerConnection;
import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.entity.Customer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author bosco
 */
public class Teste {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, IOException, ClassNotFoundException {
        String acessToken = "0ebde6de3835057f42291b64c21a0449f4aec2674b5ea28e748df298425370e4";
        
        Asaas asaas = new Asaas(new HttpAdapter(acessToken), AbstractConnection.AMBIENTE_HOMOLOGACAO);
//        Asaas asaas = new Asaas(new HttpAdapter(acessToken), AbstractConnection.AMBIENTE_PRODUCAO);

//        {
//            "name": "Marcelo Almeida",
//            "email": "marcelo.almeida@gmail.com",
//            "mobilePhone": "11 998768814",
//            "cpfCnpj": "50482783729",
//            "postalCode": "01310-000",
//            "address": "Av. Paulista",
//            "addressNumber": "150",
//            "complement": "Sala 201",
//            "province": "Centro",
//            "city": "3550308"
//        }

//        Customer customer = new Customer();
//        customer.setName("Bosco Filho");
//        customer.setEmail("bos@liamg.moc.rb");
//        customer.setMobilePhone("8436669855");
//        customer.setCpfCnpj("31890545929");
//        customer.setPostalCode("59875-400");
//        customer.setAddress("Av. paulista");
//        customer.setAddressNumber("858");
//        customer.setProvince("Pitimbu");
//        customer.setCity("3550308");
//
        CustomerConnection conn = asaas.customer();

//        conn.createCustomer(customer);
        List<Customer> clientes = conn.getAll();
//        
        clientes.stream().forEach((customer) -> {
            System.out.println(customer);            
        });
        
//        CityConnection conn = asaas.city();
//        
//        City filter = new City();
//        filter.setState("RN");
//        
//        List<City> cities = conn.getAll(filter, null, null);
////        List<City> cities = conn.getAll(filter);
//        cities.stream().forEach((city) -> {
//            System.out.println(city.getName());
//        });
////        City city = conn.getById(7637);
////        System.out.println(city);
//        System.out.println(conn.getLimit());
//        System.out.println(conn.getOffset());
//        System.out.println(conn.getHasMore());
        
    }
}
