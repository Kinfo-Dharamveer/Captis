

package com.captis.xboxmodule.utilitiesmicrosoft;

/**
 * Called when an operation finishes or has an error.
 */
public interface LiveOperationListener {

    /**
     * Called when the associated Representational State Transfer (REST) API operation call
     * completes.
     * @param operation The {@link LiveOperation} object.
     */
    public void onComplete(LiveOperation operation);

    /**
     * Called when the associated Representational State Transfer (REST) operation call fails.
     * @param exception The error returned by the REST operation call.
     * @param operation The {@link LiveOperation} object.
     */
    public void onError(LiveOperationException exception, LiveOperation operation);
}
