package com.wenhua.svr.domain.base;

public class BaseStatArea extends BaseStatAreaKey {
    private Integer online;

    private Integer offline;

    private Integer login;

    private String rankno;

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public String getRankno() {
        return rankno;
    }

    public void setRankno(String rankno) {
        this.rankno = rankno;
    }
}