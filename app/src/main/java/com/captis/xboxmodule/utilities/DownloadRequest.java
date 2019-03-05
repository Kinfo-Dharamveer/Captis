

package com.captis.xboxmodule.utilities;

import com.captis.xboxmodule.utilitiesmicrosoft.LiveConnectSession;
import com.captis.xboxmodule.utilitiesmicrosoft.LiveOperationException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.InputStream;

public class DownloadRequest extends ApiRequest<InputStream> {

    public static final String METHOD = HttpGet.METHOD_NAME;

    public DownloadRequest(LiveConnectSession session, HttpClient client, String path) {
        super(session,
              client,
              InputStreamResponseHandler.INSTANCE,
              path,
              ResponseCodes.UNSUPPRESSED,
              Redirects.UNSUPPRESSED);
    }

    @Override
    public String getMethod() {
        return METHOD;
    }

    @Override
    protected HttpUriRequest createHttpRequest() throws LiveOperationException {
        return new HttpGet(this.requestUri.toString());
    }
}
