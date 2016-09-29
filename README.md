# JAsaas [EM DESENVOLVIMENTO]

Asaas.com JAVA-SDK
=================

SDK não-oficial de integração à API do serviço www.asaas.com

Instalação
----------

Adicione o jar no classhpath da aplicação.

Endpoint
--------

Caso queira usar a API em modo teste basta especificar o `ambiente` no momento em que o cliente é instanciado.

```java
Asaas asaas = new Asaas(new HttpAdapter(acessToken), AbstractConnection.AMBIENTE_HOMOLOGACAO);
ou
Asaas asaas = new Asaas(new HttpAdapter(acessToken), AbstractConnection.AMBIENTE_PRODUCAO);
```


Clientes
--------

```java
// Retorna a listagem de clientes
CustomerConnection conn = asaas.customer();
List<Customer> customers = conn.getAll();

// Retorna os dados do cliente de acordo com o Id

// Retorna os dados do cliente de acordo com o Email

// Insere um novo cliente
CustomerConnection conn = asaas.customer();

Customer customer = new Customer();
customer.setName("Bosco Filho");
customer.setEmail("bos@liamg.moc.rb");
customer.setMobilePhone("8488888888");
customer.setCpfCnpj("31890545929");
customer.setPostalCode("59875-400");
customer.setAddress("Av. paulista");
customer.setAddressNumber("858");
customer.setProvince("Pitimbu");
customer.setCity("3550308");

conn.createCustomer(customer);

// Atualiza os dados do cliente

// Deleta uma cliente
```


Cobranças
------------

```java
// Retorna a listagem de cobranças

// Retorna os dados da cobrança de acordo com o Id

// Retorna a listagem de cobranças de acordo com o Id do Cliente

// Retorna a listagem de cobranças de acordo com o Id da Assinaturas

// Insere uma nova cobrança

// Atualiza os dados da cobrança

// Deleta uma cobrança
```


Assinaturas
------------

```java
// Retorna a listagem de assinaturas

// Retorna os dados da assinatura de acordo com o Id

// Retorna a listagem de assinaturas de acordo com o Id do Cliente

// Insere uma nova assinatura

// Atualiza os dados da assinatura

// Deleta uma assinatura
```


Notificações
------------

```java
// Retorna a listagem de notificações

// Retorna os dados da notificação de acordo com o Id

// Retorna a listagem de notificações de acordo com o Id do Cliente

// Insere uma nova notificação

// Atualiza os dados da notificação

// Deleta uma notificação
```


Cidades
------

```java
// Retorna a listagem de cidades
CityConnection conn = asaas.city();
List<City> cities = conn.getAll();
        
// Retorna os dados da cidade de acordo com o Id
CityConnection conn = asaas.city();
List<City> cities = conn.getyId(7637);

```

Documentação Oficial
--------------------

Obs.: Esta é uma API não oficial. Foi feita com base na documentação disponibilizada [neste link](https://docs.google.com/document/d/1XUJRHY_0nd45CzFK5EmjDK92qgaQJGMxT0rjZriTk-g).


Creditos
--------



Suporte
-------


Licença
-------

