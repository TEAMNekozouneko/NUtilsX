package com.nekozouneko.nutilsx;

public interface NUtilsXApi {

    /**
     * Get NUtilsX version
     * @return version
     */
    String getVersion();

    /**
     * Get NUtilsX platform
     * @return platform
     */
    Platform getPlatform();

    /**
     * Get NUtilsX Uptime
     * @return Uptime seconds
     */
    long getUptime();

}
