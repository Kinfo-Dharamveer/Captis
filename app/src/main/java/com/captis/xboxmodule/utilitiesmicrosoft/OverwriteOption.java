

package com.captis.xboxmodule.utilitiesmicrosoft;

import com.captis.xboxmodule.utilities.QueryParameters;
import com.captis.xboxmodule.utilities.UriBuilder;

/**
 * Enum that specifies what to do during a naming conflict during an upload.
 */
public enum OverwriteOption {

    /** Overwrite the existing file. */
    Overwrite {
        @Override
        protected String overwriteQueryParamValue() {
            return "true";
        }
    },

    /** Do Not Overwrite the existing file and cancel the upload. */
    DoNotOverwrite {
        @Override
        protected String overwriteQueryParamValue() {
            return "false";
        }
    },

    /** Rename the current file to avoid a name conflict. */
    Rename {
        @Override
        protected String overwriteQueryParamValue() {
            return "choosenewname";
        }
    };

    /**
     * Leaves any existing overwrite query parameter on appends this overwrite
     * to the given UriBuilder.
     */
    public void appendQueryParameterOnTo(UriBuilder uri) {
        uri.appendQueryParameter(QueryParameters.OVERWRITE, this.overwriteQueryParamValue());
    }

    abstract protected String overwriteQueryParamValue();
}
