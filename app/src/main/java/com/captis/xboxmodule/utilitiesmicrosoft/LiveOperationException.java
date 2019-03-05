

package com.captis.xboxmodule.utilitiesmicrosoft;

/**
 * Represents errors that occur when making requests to the Representational State Transfer
 * (REST) API.
 */
public class LiveOperationException extends Exception {

    private static final long serialVersionUID = 4630383031651156731L;

    public LiveOperationException(String message) {
        super(message);
    }

    public LiveOperationException(String message, Throwable e) {
        super(message, e);
    }
}
