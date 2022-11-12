package com.nekozouneko.nutilsx;

/**
 * A NUtilsX Api interface
 * @author Taitaitatata
 * @version 2.0.1
 */
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
