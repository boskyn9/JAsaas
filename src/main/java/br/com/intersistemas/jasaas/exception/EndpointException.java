package br.com.intersistemas.jasaas.exception;

/**
 * Exceção personalizada que é lançada quando ocorre um erro relacionado a um endpoint específico.
 * Esta classe estende a {@link RuntimeException}, permitindo que seja usada em tempo de execução
 * sem a necessidade de ser capturada explicitamente.
 * <p>
 * A classe contém um valor final {@code endpointValue} que representa o valor específico do endpoint
 * associado ao erro.
 * </p>
 *
 * @author bosco
 */
public class EndpointException extends RuntimeException {

    /**
     * Valor específico do endpoint relacionado à exceção.
     */
    final int endpointValue;

    /**
     * Constrói uma nova {@code EndpointException} com a mensagem de erro fornecida
     * e o valor do endpoint associado.
     *
     * @param message        A mensagem de erro detalhando a causa da exceção.
     * @param endpointValue  O valor específico do endpoint associado ao erro.
     */
    public EndpointException(String message, int endpointValue) {
        super(message);
        this.endpointValue = endpointValue;
    }
}
