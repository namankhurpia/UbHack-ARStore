package com.namankhurpia.arstore;

public class Store {
    public String appname;
    public String appiconpath;
    public String appurl;
    public String stars;

    @Override
    public String toString() {
        return "Store{" +
                "appname='" + appname + '\'' +
                ", appiconpath='" + appiconpath + '\'' +
                ", appurl='" + appurl + '\'' +
                ", stars='" + stars + '\'' +
                ", ownername='" + ownername + '\'' +
                '}';
    }

    public String ownername;

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppiconpath() {
        return appiconpath;
    }

    public void setAppiconpath(String appiconpath) {
        this.appiconpath = appiconpath;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Store(String appname, String appiconpath, String appurl, String stars, String ownername) {
        this.appname = appname;
        this.appiconpath = appiconpath;
        this.appurl = appurl;
        this.stars = stars;
        this.ownername = ownername;
    }
}
