

package com.captis.xboxmodule;

public final class Config {
	// Check out http://go.microsoft.com/fwlink/p/?LinkId=193157 to get your own client id
    public static final String CLIENT_ID = "0000000048122D4E"; 

    // Available options to determine security level of access
    public static final String[] SCOPES = {
        "wl.signin",
        "wl.basic",
        "wl.offline_access",
        "wl.skydrive_update",
        "wl.contacts_create",
    };

    private Config() {
        throw new AssertionError("Unable to create Config object.");
    }
}
