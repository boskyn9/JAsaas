package br.com.intersistemas.jasaas.util;

public enum SendType {

    /**
     * O Asaas aguarda a resposta de sucesso (200 OK) do seu servidor antes de enviar o próximo evento.
     * Ideal para garantir a ordem cronológica (ex: Criado -> Pago).
     * Risco: Se seu servidor cair, a fila acumula.
     */
    SEQUENTIALLY,

    /**
     * O Asaas envia os eventos assim que ocorrem, sem aguardar a confirmação do anterior.
     * Ideal para performance e sistemas que tratam concorrência.
     */
    NON_SEQUENTIALLY
}
