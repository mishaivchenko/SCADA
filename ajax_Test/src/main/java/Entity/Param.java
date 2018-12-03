package Entity;

import java.util.Date;

public class Param {
    private String value;
    private Date date;

    public Param(String value, Date date){
        this.date=date;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
