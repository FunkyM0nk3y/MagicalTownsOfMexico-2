package com.FunkyM0nk3y.funkym0nk3y.magicaltownsofmexico;

/**
 * Created by FunkyM0nk3y on 8/29/15.
 */
public class MagicalTown {
    private String magicaltown, state, latitudemt, longitudemt;

    public MagicalTown(String magicaltown, String state, String latitudemt, String longitudemt) {
        super();
        this.magicaltown = magicaltown;
        this.state = state;
        this.latitudemt = latitudemt;
        this.longitudemt = longitudemt;
    }

    public String getMagicaltown() {
        return magicaltown;
    }

    public String getState() {
        return state;
    }

    public String getLatitudeMT() {
        return latitudemt;
    }

    public String getLongitudeMT() {
        return longitudemt;
    }

    public void setMagicaltown(String magicaltown) {
        this.magicaltown = magicaltown;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLatitudeMT(String latitude) {
        this.latitudemt = latitude;
    }

    public void setLongitudeMT(String longitude) {
        this.longitudemt = longitude;
    }

    @Override
    public String toString() {
        return "MagicalTown{" +
                "magicaltown='" + magicaltown + '\'' +
                ", state='" + state + '\'' +
                ", latitude='" + latitudemt + '\'' +
                ", longitude='" + longitudemt + '\'' +
                '}';
    }
}
