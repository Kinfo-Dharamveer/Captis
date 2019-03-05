

package com.captis.xboxmodule.utilities;

import android.text.TextUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * RefreshAccessTokenRequest performs a refresh access token request. Most of the work
 * is done by the parent class, TokenRequest. This class adds in the required body parameters via
 * TokenRequest's hook method, constructBody().
 */
public class RefreshAccessTokenRequest extends TokenRequest {

    /** REQUIRED. Value MUST be set to "refresh_token". */
    private final OAuth.GrantType grantType = OAuth.GrantType.REFRESH_TOKEN;

    /**  REQUIRED. The refresh token issued to the client. */
    private final String refreshToken;

    private final String scope;

    public RefreshAccessTokenRequest(HttpClient client,
                                     String clientId,
                                     String refreshToken,
                                     String scope) {
        super(client, clientId);

        assert refreshToken != null;
        assert !TextUtils.isEmpty(refreshToken);
        assert scope != null;
        assert !TextUtils.isEmpty(scope);

        this.refreshToken = refreshToken;
        this.scope = scope;
    }

    @Override
    protected void constructBody(List<NameValuePair> body) {
        body.add(new BasicNameValuePair(OAuth.REFRESH_TOKEN, this.refreshToken));
        body.add(new BasicNameValuePair(OAuth.SCOPE, this.scope));
        body.add(new BasicNameValuePair(OAuth.GRANT_TYPE, this.grantType.toString()));
    }
}
