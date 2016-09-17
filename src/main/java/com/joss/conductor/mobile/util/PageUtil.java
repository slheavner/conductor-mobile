package com.joss.conductor.mobile.util;

import com.joss.conductor.mobile.Config;
import org.openqa.selenium.By;

/**
 * Created on 9/2/16.
 */
public class PageUtil {

    private static final String ANDROID_APP_PACKAGE_NAME_ID = "%s:id/%s";
    private static final String IOS_XPATH_LABEL = "//*[@label='%s']";

    public static String buildId(Config config, String id) {
        switch (config.platformName()) {
            case ANDROID:
                return String.format(ANDROID_APP_PACKAGE_NAME_ID, config.appPackageName(), id);
            case IOS:
                return id; // TODO
            default:
                System.err.println("Unknown platform: " + config.platformName());
                System.exit(1);
        }
        return null;
    }

    public static By buildBy(Config config, String identifier) {
        switch (config.platformName()) {
            case ANDROID:
                return By.id(String.format(ANDROID_APP_PACKAGE_NAME_ID, config.appPackageName(), identifier));
            case IOS:
                return By.xpath(String.format(IOS_XPATH_LABEL, identifier));
            default:
                System.err.println("Unknown platform: " + config.platformName());
                System.exit(1);
        }
        return null;
    }

}
