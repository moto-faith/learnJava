package com.itcast.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 程序员工程师
 */
public class Programmer {

    private List<String> cars;
    private Set<String> pats;//宠物
    private Map<String,String> infos;//信息
    private Properties mysqlInfos;//mysql数据连接信息

    private String[] members;//家庭成员
    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Set<String> getPats() {
        return pats;
    }

    public void setPats(Set<String> pats) {
        this.pats = pats;
    }

    public Map<String, String> getInfos() {
        return infos;
    }

    public void setInfos(Map<String, String> infos) {
        this.infos = infos;
    }

    public Properties getMysqlInfos() {
        return mysqlInfos;
    }

    public void setMysqlInfos(Properties mysqlInfos) {
        this.mysqlInfos = mysqlInfos;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }
}
