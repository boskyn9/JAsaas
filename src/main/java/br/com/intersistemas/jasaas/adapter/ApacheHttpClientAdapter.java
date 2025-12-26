package br.com.intersistemas.jasaas.adapter;

import br.com.intersistemas.jasaas.exception.ConnectionException;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
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

            return EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    @Override
    public String delete(String url) throws ConnectionException, IOException {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.addHeader("access_token", accessToken);
        CloseableHttpResponse response = httpclient.execute(httpDelete);
        StatusLine status = response.getStatusLine();
        if (status.getStatusCode() != 200) {
            throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase());
        }
        return EntityUtils.toString(response.getEntity());
    }

    @Override
    public String put(String url, String content) throws ConnectionException {
        try {
            HttpPut httpPut = new HttpPut(url);
            httpPut.addHeader("access_token", accessToken);

            // Configura o corpo (JSON + UTF-8)
            StringEntity entity = new StringEntity(content, "UTF-8");
            entity.setContentType("application/json");
            httpPut.setEntity(entity);

            CloseableHttpResponse response = httpclient.execute(httpPut);
            StatusLine status = response.getStatusLine();

            // Sucesso geralmente é 200. Erro pode ser 400, 404, 500.
            if (status.getStatusCode() != 200) {
                String errorBody = EntityUtils.toString(response.getEntity());
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase() + " - " + errorBody);
            }

            return EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    @Override
    public String post(String url, String contentJSON) throws ConnectionException {
        // --- ADICIONE ESTA LINHA ---
        System.out.println(">>> POST URL: " + url);
        System.out.println(">>> BODY: " + contentJSON);
        // --
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("access_token", accessToken);

            // --- CORREÇÃO AQUI ---
            // Define explicitamente que é JSON e UTF-8
            StringEntity entity = new StringEntity(contentJSON, "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            // ---------------------

            CloseableHttpResponse response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();

            // Asaas retorna 200 (OK) ou 201 (Created) para sucesso
            if (status.getStatusCode() != 200 && status.getStatusCode() != 201) {
                // Se der erro 400 ou 500, o corpo da mensagem tem o detalhe do erro
                String errorBody = EntityUtils.toString(response.getEntity());
                throw new ConnectionException(status.getStatusCode(), status.getReasonPhrase() + " - " + errorBody);
            }
            return EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
