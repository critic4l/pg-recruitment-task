import java.util.Date;

public class Rates {
    private Date date;
    private float bid;
    private float ask;

    public Rates(Date date, float bid, float ask) {
        this.date = date;
        this.bid = bid;
        this.ask = ask;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getAsk() {
        return ask;
    }

    public void setAsk(float ask) {
        this.ask = ask;
    }
}
