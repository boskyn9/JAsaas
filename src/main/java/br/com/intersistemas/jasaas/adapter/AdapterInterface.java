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
     */
    public String get(String url);

    /**
     * DELETE Request
     *
     * @param url
     */
    public void delete(String url);

    /**
     * PUT Request
     *
     * @param url
     * @param contentJSON
     * @return string
     */
    public String put(String url, String contentJSON);
    /**
     * POST Request
     *
     * @param url
     * @param contentJSON
     */
    public void post(String url, String contentJSON);
    /**
     * Get last response headers
     *
     * @return array|null
     */
    public List getLatestResponseHeaders();
}
