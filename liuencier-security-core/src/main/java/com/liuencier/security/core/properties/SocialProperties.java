package com.liuencier.security.core.properties;

public class SocialProperties {
    private String filterProcessUrl = "/auth";
    private QQProperties qq = new QQProperties();

    public String getFilterProcessUrl() {
        return filterProcessUrl;
    }

    public void setFilterProcessUrl(String filterProcessUrl) {
        this.filterProcessUrl = filterProcessUrl;
    }

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
