

package com.captis.xboxmodule.utilities;

/**
 * The type of the device is used to determine the display query parameter for login.live.com.
 * Phones have a display parameter of android_phone.
 * Tablets have a display parameter of android_tablet.
 */
enum DeviceType {
    PHONE {
        @Override
        public OAuth.DisplayType getDisplayParameter() {
            return OAuth.DisplayType.ANDROID_PHONE;
        }
    },
    TABLET {
        @Override
        public OAuth.DisplayType getDisplayParameter() {
            return OAuth.DisplayType.ANDROID_TABLET;
        }
    };

    abstract public OAuth.DisplayType getDisplayParameter();
}
