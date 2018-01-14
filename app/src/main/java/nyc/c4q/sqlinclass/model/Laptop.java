package nyc.c4q.sqlinclass.model;

/**
 * Created by yokilam on 1/14/18.
 */

public class Laptop {
    private String name;
    private String dateTime;
    private String color;
    private int classnumber;
    private String condition;
    private boolean isBroken;
    private boolean isMac;

    public Laptop(String name, String dateTime, String color, int classnumber, String condition) {
        this.name = name;
        this.dateTime= dateTime;
        this.color = color;
        this.classnumber = classnumber;
        this.condition = condition;
        this.isBroken = isBroken;
        this.isMac = isMac;
    }

    public String getName() {
        return name;
    }

    public Laptop setName(String name) {
        this.name = name;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Laptop setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Laptop setColor(String color) {
        this.color = color;
        return this;
    }

    public int getClassnumber() {
        return classnumber;
    }

    public Laptop setClassnumber(int classnumber) {
        this.classnumber = classnumber;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public Laptop setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public Laptop setBroken(boolean broken) {
        isBroken = broken;
        return this;
    }

    public boolean isMac() {
        return isMac;
    }

    public Laptop setMac(boolean mac) {
        isMac = mac;
        return this;
    }
}
