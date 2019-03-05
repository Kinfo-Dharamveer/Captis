

package com.captis.xboxmodule.utilities;

/**
 * OAuthResponseVisitor is used to visit various OAuthResponse.
 */
public interface OAuthResponseVisitor {

    /**
     * Called when an OAuthSuccessfulResponse is visited.
     *
     * @param response being visited
     */
    public void visit(OAuthSuccessfulResponse response);

    /**
     * Called when an OAuthErrorResponse is being visited.
     *
     * @param response being visited
     */
    public void visit(OAuthErrorResponse response);
}
