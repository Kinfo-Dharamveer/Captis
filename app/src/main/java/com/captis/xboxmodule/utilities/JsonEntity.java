

package com.captis.xboxmodule.utilities;

import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * JsonEntity is an Entity that contains a Json body
 */
public class JsonEntity extends StringEntity {

    public static final String CONTENT_TYPE = "application/json;charset=" + HTTP.UTF_8;

    /**
     * Constructs a new JsonEntity.
     *
     * @param body
     * @throws UnsupportedEncodingException
     */
    public JsonEntity(JSONObject body) throws UnsupportedEncodingException {
        super(body.toString(), HTTP.UTF_8);

        this.setContentType(CONTENT_TYPE);
    }
}
