package br.com.jasaas.adapter;

import br.com.jasaas.exception.ConnectionException;

/**
 *
 * @author bosco
 */
public interface AdapterConnection {


    /**
     * GET Request
     *
     * @param url
     * @return string
     * @throws ConnectionException
     */
    String get(String url);

    /**
     * DELETE Request
     *
     * @param url
     * @return String contendo JSON com o objeto deletado ou um objeto de erro
     * @throws ConnectionException
     */
    String delete(String url);


    /**
     * POST Request
     *
     * @param url URL do serviço para comunicação
     * @param contentJSON Conteúdo da comunicação
     * @return String contendo JSON com o objeto gerado ou um objeto de erro
     * @throws ConnectionException
     */
    String post(String url, String contentJSON);

    /**
     * PUT Request
     *
     * @param url URL do serviço para comunicação
     * @param contentJSON Conteúdo da comunicação
     * @return String contendo JSON com o objeto gerado ou um objeto de erro
     * @throws ConnectionException
     */
    String put(String url, String contentJSON);

}
