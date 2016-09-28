package br.com.intersistemas.jasaas.adapter;

import java.util.List;

/**
 *
 * @author bosco
 */
public interface AdapterInterface {

    /**
     * GET Request
     *
     * @param string url Request Url
     * @throws HttpException
     * @return string
     */
    public String get(String url);

    /**
     * DELETE Request
     *
     * @param string url Request Url
     * @throws HttpException
     */
    public void delete(String url);

    /**
     * PUT Request
     *
     * @param string url Request Url
     * @param mixed content Request Content
     * @throws HttpException
     * @return string
     */
    public String put(String url, String content);
    /**
     * POST Request
     *
     * @param   string  $url      Request Url
     * @param   mixed   $content  Request Content
     * @throws  HttpException
     * @return  string
     */
    public void post(String url, String content);
    /**
     * Get last response headers
     *
     * @return array|null
     */
    public List getLatestResponseHeaders();
}
