package com.samples.ta.driver;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebDriverProperties {
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("driver.version")
    private String driverVersion;
    @JsonProperty("implicit.wait")
    private Long implicitWait;
    @JsonProperty("page.load.timeout")
    private Long pageLoadTimeout;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public Long getImplicitWait() {
        return implicitWait;
    }

    public void setImplicitWait(Long implicitWait) {
        this.implicitWait = implicitWait;
    }

    public Long getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Long pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }
}
