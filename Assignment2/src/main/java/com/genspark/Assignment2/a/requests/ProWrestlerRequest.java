package com.genspark.Assignment2.a.requests;

public class ProWrestlerRequest {

    private String ringName;
    private String realName;
    private String finisher;
    private boolean active;

    public ProWrestlerRequest() {}

    public ProWrestlerRequest(String ringName, String realName, String finisher) {
        this.ringName = ringName;
        this.realName = realName;
        this.finisher = finisher;
        this.active = true;
    }

    public ProWrestlerRequest(String ringName, String realName, String finisher, boolean active) {
        this.ringName = ringName;
        this.realName = realName;
        this.finisher = finisher;
        this.active = active;
    }

    public String getRingName() {
        return ringName;
    }

    public String getRealName() {
        return realName;
    }

    public String getFinisher() {
        return finisher;
    }

    public boolean isActive() {
        return active;
    }

}
