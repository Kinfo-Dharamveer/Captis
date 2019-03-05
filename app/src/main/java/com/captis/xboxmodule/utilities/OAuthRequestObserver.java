

package com.captis.xboxmodule.utilities;

import com.captis.xboxmodule.utilitiesmicrosoft.LiveAuthException;

/**
 * An observer of an OAuth Request. It will be notified of an Exception or of a Response.
 */
public interface OAuthRequestObserver {
    /**
     * Callback used on an exception.
     *
     * @param exception
     */
    public void onException(LiveAuthException exception);

    /**
     * Callback used on a response.
     *
     * @param response
     */
    public void onResponse(OAuthResponse response);
}
