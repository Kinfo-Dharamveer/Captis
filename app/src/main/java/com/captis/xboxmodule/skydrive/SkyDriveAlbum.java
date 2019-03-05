

package com.captis.xboxmodule.skydrive;

import org.json.JSONObject;

public class SkyDriveAlbum extends SkyDriveObject {

    public static final String TYPE = "album";

    public SkyDriveAlbum(JSONObject object) {
        super(object);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getCount() {
        return mObject.optInt("count");
    }
}
