package com.genspark.Assignment2.a.entity;

import javax.persistence.*;

@Entity
@Table(name = "pro_wrestlers")
public class ProWrestler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ring_name")
    private String ringName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "finisher")
    private String finisher;

    @Column(name = "active")
    private boolean active;

    public ProWrestler() {}

    public ProWrestler(String realName, String finisher, boolean active) {
        this.realName = realName;
        this.finisher = finisher;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRingName() {
        return ringName;
    }

    public void setRingName(String ringName) {
        this.ringName = ringName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProWrestler{" +
                "id=" + id +
                ", ringName='" + ringName + '\'' +
                ", realName='" + realName + '\'' +
                ", finisher='" + finisher + '\'' +
                ", active=" + active +
                '}';
    }
}
