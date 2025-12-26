package br.com.intersistemas.jasaas.teste;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.intersistemas.jasaas.api.AbstractConnection;
import br.com.intersistemas.jasaas.api.WebhookConfigConnection;
import br.com.intersistemas.jasaas.entity.WebhookConfig;
import br.com.intersistemas.jasaas.util.PaymentEvent;
import br.com.intersistemas.jasaas.util.SendType;

import java.util.Arrays;
import java.util.List;

public class TesteWebhook {
    public static void main(String[] args) {
        try {
            //Configura a conexão (troque pela sua API Key de Sandbox)
            AdapterConnection adapter = new ApacheHttpClientAdapter("$aact_hmlg_000MzkwODA2MWY2OGM3MWRlMDU2NWM3MzJlNzZmNGZhZGY6OjE1ZjIyYmZmLWM2ZDctNGE4MC1iN2RkLTY4NTkwZWVmNDRjMDo6JGFhY2hfZjI3NTRiMzctMmZkYS00OTlmLWE0ODQtMjhiM2M0Y2IyMGNj");
            WebhookConfigConnection conn = new WebhookConfigConnection(adapter, AbstractConnection.AMBIENTE_HOMOLOGACAO);

            // -----------------------------------------------------------------
            // BUSCA OU CRIA (Prepara o terreno)
            // -----------------------------------------------------------------
            System.out.println("Buscando webhooks...");
            WebhookConfig alvo = null;
            List<WebhookConfig> lista = conn.getAll();

            // Filtra para não mexer em webhooks que não sejam de teste
            for (WebhookConfig w : lista) {
                if (w.getName().contains("Teste") || w.getName().contains("Controle Mais")) {
                    alvo = w;
                    break;
                }
            }

            if (alvo == null) {
                System.out.println("Nenhum webhook encontrado. Criando um novo...");
                // Cria um novo se não existir
                WebhookConfig novo = new WebhookConfig();
                novo.setName("Webhook Controle Mais");
                novo.setUrl("https://controlemais.com.br/boletoAsaas/wsNotificationAsaas");
                novo.setEmail("joelnandes02@gmail.com");

                // CONFIGURAÇÕES OBRIGATÓRIAS
                novo.setEnabled(true);
                novo.setInterrupted(false); // <--- ADICIONE ISSO AQUI!
                novo.setApiVersion(3);      // Garanta que está enviando a versão 3

                novo.setAuthToken("*");
                novo.setSendType(SendType.SEQUENTIALLY);
                novo.setEvents(Arrays.asList(PaymentEvent.PAYMENT_RECEIVED, PaymentEvent.PAYMENT_OVERDUE));

                WebhookConfig criado = conn.createWebhookConfig(novo);
                System.out.println("Webhook criado com ID: " + criado.getId());
            } else {
                System.out.println("Usando webhook existente: " + alvo.getName() + " (ID: " + alvo.getId() + ")");
            }

            // -----------------------------------------------------------------
            // TESTE DE UPDATE
            // -----------------------------------------------------------------
            System.out.println("\n>>> 2. TESTANDO UPDATE <<<");

            // Vamos mudar o nome e adicionar um evento
            String novoNome = "Webhook Atualizado " + System.currentTimeMillis();
            alvo.setName(novoNome);
            alvo.getEvents().add(PaymentEvent.PAYMENT_CONFIRMED); // Adiciona mais um evento

            WebhookConfig atualizado = conn.updateWebhookConfig(alvo);

            if (atualizado.getName().equals(novoNome)) {
                System.out.println("SUCESSO: Nome atualizado para: " + atualizado.getName());
            } else {
                System.err.println("ERRO: O nome não foi atualizado corretamente.");
            }

            // -----------------------------------------------------------------
            // TESTE DE DELETE
            // -----------------------------------------------------------------
            System.out.println("\n>>> 3. TESTANDO DELETE <<<");
            System.out.println("Apagando o webhook ID: " + alvo.getId());

            boolean removeu = conn.deleteWebhookConfig(alvo.getId());

            if (removeu) {
                System.out.println("SUCESSO: Webhook removido.");

                // Validação extra: tenta buscar de novo para ter certeza que sumiu
                try {
                    conn.getById(alvo.getId());
                    System.err.println("AVISO: O webhook ainda foi encontrado no getById (pode ser cache ou erro).");
                } catch (Exception e) {
                    System.out.println("Confirmação: Tentar buscar o ID falhou (como esperado), pois não existe mais.");
                }

            } else {
                System.err.println("ERRO: Falha ao remover o webhook.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
