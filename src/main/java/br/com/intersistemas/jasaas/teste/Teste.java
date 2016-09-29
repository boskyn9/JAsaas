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
import br.com.intersistemas.jasaas.entity.City;
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
        
//{
//  "object": "list",
//  "hasMore": true,
//  "limit": 10,
//  "offset": 0,
//  "data": [
//    {
//      "city": {
//        "object": "city",
//        "id": 15873,
//        "ibgeCode": "3550308",
//        "name": "São Paulo",
//        "districtCode": "00",
//        "district": "São Paulo",
//        "state": "SP"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 15718,
//        "ibgeCode": "5200050",
//        "name": "Abadia de Goiás",
//        "districtCode": "05",
//        "district": "Abadia de Goiás",
//        "state": "GO"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 9853,
//        "ibgeCode": "3100104",
//        "name": "Abadia dos Dourados",
//        "districtCode": "05",
//        "district": "Abadia dos Dourados",
//        "state": "MG"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 15749,
//        "ibgeCode": "5200100",
//        "name": "Abadiânia",
//        "districtCode": "05",
//        "district": "Abadiânia",
//        "state": "GO"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 9949,
//        "ibgeCode": "3100203",
//        "name": "Abaeté",
//        "districtCode": "05",
//        "district": "Abaeté",
//        "state": "MG"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 5927,
//        "ibgeCode": "1500107",
//        "name": "Abaetetuba",
//        "districtCode": "05",
//        "district": "Abaetetuba",
//        "state": "PA"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 7525,
//        "ibgeCode": "2300101",
//        "name": "Abaiara",
//        "districtCode": "05",
//        "district": "Abaiara",
//        "state": "CE"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 9090,
//        "ibgeCode": "2900108",
//        "name": "Abaíra",
//        "districtCode": "05",
//        "district": "Abaíra",
//        "state": "BA"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 8671,
//        "ibgeCode": "2900207",
//        "name": "Abaré",
//        "districtCode": "05",
//        "district": "Abaré",
//        "state": "BA"
//      }
//    },
//    {
//      "city": {
//        "object": "city",
//        "id": 12992,
//        "ibgeCode": "4100103",
//        "name": "Abatiá",
//        "districtCode": "05",
//        "district": "Abatiá",
//        "state": "PR"
//      }
//    }
//  ]
//}

//{
//"object": "city"
//"id": 7637
//"ibgeCode": "2400109"
//"name": "Acari"
//"districtCode": "05"
//"district": "Acari"
//"state": "RN"
//}

        Asaas asaas = new Asaas(new HttpAdapter(acessToken), AbstractConnection.AMBIENTE_HOMOLOGACAO);
        CityConnection conn = asaas.city();
        
        City filter = new City();
        filter.setState("RN");
        
        List<City> cities = conn.getAll(null);
        
        System.out.println(conn.getLimit());
        System.out.println(conn.getOffset());
        System.out.println(conn.getHasMore());
//        List<City> cities = conn.getAll(filter);
        
        cities.stream().forEach((city) -> {
            System.out.println(city.getName());
        });
//        City city = conn.getById(7637);
//        System.out.println(city);
    }
}
