package br.com.intersistemas.jasaas.adapter;

import br.com.intersistemas.jasaas.exception.ConnectionException;
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

            return retorno;
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClientAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
        //return null;
    }

    @Override
    public void delete(String url) throws ConnectionException {
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.addHeader("access_token", accessToken);
            CloseableHttpResponse response = httpclient.execute(httpDelete);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() != 200) {
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClientAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    /*@Override
    public String put(String url, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public void post(String url, String contentJSON) throws ConnectionException {
        try {
            System.out.println(url);
            System.out.println(contentJSON);
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("access_token", accessToken);

            StringEntity entity = new StringEntity(contentJSON);
            httpPost.setEntity(entity);

            CloseableHttpResponse response = httpclient.execute(httpPost);
            System.out.println("CloseableHttpResponse");
            for (int i = 0; i < response.getAllHeaders().length; i++) {
                System.out.println(response.getAllHeaders()[i].toString());
            }
            StatusLine status = response.getStatusLine();
            System.out.println(status.getStatusCode());
            if (status.getStatusCode() != 200) {
                System.out.println(status.getReasonPhrase());
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
            }
        } catch (IOException ex) {
            Logger.getLogger(ApacheHttpClientAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
