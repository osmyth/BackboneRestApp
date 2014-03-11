package com.backbonerestapp.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IMSI_MAPPING")
public class User {

    @Id
    @Column(name = "IMSI_ID")
    private String imsi;

    @Column(name = "MSISDN")
    private String msisdn;

    @Column(name = "USER_LABEL")
    private String userLabel;

    @Column(name = "SUBSCRIBER_NAME")
    private String subscriberName;

    @Column(name = "LAST_UPDATED")
    private long lastUpdated;

    @Column(name = "DROP_ALLOWED")
    private boolean dropAllowed;

    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @Column(name = "RESTRICTED_ACCESS")
    private boolean restrictedAccess;

    @Column(name = "PROVISIONED")
    private boolean provisioned;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isDropAllowed() {
        return dropAllowed;
    }

    public void setDropAllowed(boolean dropAllowed) {
        this.dropAllowed = dropAllowed;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isRestrictedAccess() {
        return restrictedAccess;
    }

    public void setRestrictedAccess(boolean restrictedAccess) {
        this.restrictedAccess = restrictedAccess;
    }

    public boolean isProvisioned() {
        return provisioned;
    }

    public void setProvisioned(boolean provisioned) {
        this.provisioned = provisioned;
    }
}
