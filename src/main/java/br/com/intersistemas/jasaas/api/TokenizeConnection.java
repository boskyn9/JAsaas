package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Tokenize;
import br.com.intersistemas.jasaas.entity.TokenizeResponse;
import br.com.intersistemas.jasaas.entity.meta.MetaError;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.JsonUtil;

/**
 * @author bosco
 */
public class TokenizeConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public TokenizeConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public TokenizeResponse createTokenize(Tokenize tokenize) throws ConnectionException {
        String tokenizeJSON = JsonUtil.toJSON(tokenize);
        try {
            System.out.println("createTokenize");
            String data = adapter.post((endpoint + "/creditCard/tokenize"), tokenizeJSON);
            TokenizeResponse tokenizeResponse = (TokenizeResponse) JsonUtil.parse(data, TokenizeResponse.class);
            if (tokenizeResponse.getCreditCardToken() == null) {
                MetaError error = (MetaError) JsonUtil.parse(data, MetaError.class);
                throw new ConnectionException(500, error.toString());
            }
            return tokenizeResponse;
        } catch (Exception ex) {
            throw new ConnectionException(500, ex.getMessage());
        }

    }

}
