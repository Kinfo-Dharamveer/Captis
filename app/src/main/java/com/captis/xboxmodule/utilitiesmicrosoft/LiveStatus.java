

package com.captis.xboxmodule.utilitiesmicrosoft;

/**
 * Specifies the status of an auth operation.
 */
public enum LiveStatus {
    /** The status is not known. */
    UNKNOWN,

    /** The session is connected. */
    CONNECTED,

    /** The user has not consented to the application. */
    NOT_CONNECTED;
}
