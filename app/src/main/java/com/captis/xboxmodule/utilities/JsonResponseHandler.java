

package com.captis.xboxmodule.utilities;

import android.text.TextUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * JsonResponseHandler returns a JSONObject from an HttpResponse.
 * Singleton--use INSTANCE.
 */
enum JsonResponseHandler implements ResponseHandler<JSONObject> {
    INSTANCE;

    @Override
    public JSONObject handleResponse(HttpResponse response)
            throws ClientProtocolException, IOException {
        final HttpEntity entity = response.getEntity();
        final String stringResponse;
        if (entity != null) {
            stringResponse = EntityUtils.toString(entity);
        } else {
            return null;
        }

        if (TextUtils.isEmpty(stringResponse)) {
            return new JSONObject();
        }

        try {
           return new JSONObject(stringResponse);
        } catch (JSONException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }
}
