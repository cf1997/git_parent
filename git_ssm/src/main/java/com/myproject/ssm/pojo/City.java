package com.myproject.ssm.pojo;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {


    private String id;
    private String name;
    private String ishot;

    private List<City> countyList;

    public City() {
    }

    public City(String id, String name, String ishot) {
        this.id = id;
        this.name = name;
        this.ishot = ishot;
    }

    public List<City> getCountyList() {
        return countyList;
    }

    public void setCountyList(List<City> countyList) {
        this.countyList = countyList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIshot() {
        return ishot;
    }

    public void setIshot(String ishot) {
        this.ishot = ishot;
    }
}
