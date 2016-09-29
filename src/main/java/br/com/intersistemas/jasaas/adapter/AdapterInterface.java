package br.com.intersistemas.jasaas.adapter;

import br.com.intersistemas.jasaas.exception.ConnectionException;
import java.util.List;

/**
 *
 * @author bosco
 */
public interface AdapterInterface {

    /**
     * GET Request
     *
     * @param url
     * @return string
     * @throws ConnectionException
     */
    public String get(String url);

    /**
     * DELETE Request
     *
     * @param url
     * @throws ConnectionException
     */
    public void delete(String url);

    /**
     * PUT Request
     *
     * @param url URL do serviço para comunicação
     * @param contentJSON Conteúdo da comunicação
     * @throws ConnectionException     
     * @return string
     */
    public String put(String url, String contentJSON);
    /**
     * POST Request
     *
     * @param url URL do serviço para comunicação
     * @param contentJSON Conteúdo da comunicação
     * @throws ConnectionException
     */
    public void post(String url, String contentJSON);
    /**
     * Get last response headers
     *
     * @return List
     * @throws ConnectionException
     */
    public List getLatestResponseHeaders();
}
