

package com.captis.xboxmodule.utilities;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * HttpMove represents an HTTP MOVE operation.
 * HTTP MOVE is not a standard HTTP method and this adds it
 * to the HTTP library.
 */
class HttpMove extends HttpEntityEnclosingRequestBase {

    public static final String METHOD_NAME = "MOVE";

    /**
     * Constructs a new HttpMove with the given uri and initializes its member variables.
     *
     * @param uri of the request
     */
    public HttpMove(String uri) {
        try {
            this.setURI(new URI(uri));
        } catch (URISyntaxException e) {
            final String message = String.format(ErrorMessages.INVALID_URI, "uri");
            throw new IllegalArgumentException(message);
        }
    }

    /** @return the string "MOVE" */
    @Override
    public String getMethod() {
        return METHOD_NAME;
    }
}
