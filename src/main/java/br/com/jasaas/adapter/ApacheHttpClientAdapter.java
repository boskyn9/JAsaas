package br.com.jasaas.adapter;

import br.com.jasaas.exception.ConnectionException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author bosco
 */
public class ApacheHttpClientAdapter implements AdapterConnection {

    private final String accessToken;
    private final CloseableHttpClient httpclient;
    private final Logger logger = Logger.getLogger(ApacheHttpClientAdapter.class.getName());

    public ApacheHttpClientAdapter(String acessToken) {
        this.accessToken = acessToken;
        httpclient = HttpClients.createDefault();
    }

    @Override
    public String get(String url) throws ConnectionException {
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpGet);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String retorno = EntityUtils.toString(entity);
            this.logger.log(Level.INFO, retorno);
            return retorno;
        } catch (IOException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    @Override
    public String delete(String url) throws ConnectionException {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpDelete);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entity = response.getEntity();
            String retorno = EntityUtils.toString(entity);
            this.logger.log(Level.INFO, retorno);
            return retorno;
        } catch (IOException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    @Override
    public String post(String url, String contentJSON) throws ConnectionException {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("access_token", accessToken);
            StringEntity entity = new StringEntity(contentJSON);
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200 && status.getStatusCode() != 400) {
                System.out.println(status.getReasonPhrase());
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
            HttpEntity entidade = response.getEntity();
            String retorno = EntityUtils.toString(entidade);
            this.logger.log(Level.INFO, retorno);
            return retorno;
        } catch (IOException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }
}
