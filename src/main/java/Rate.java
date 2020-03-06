public class Rate {
    private String date;
    private float bid;
    private float ask;

    public Rate(String date, float bid, float ask) {
        this.date = date;
        this.bid = bid;
        this.ask = ask;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Override
    public String toString() {
        return "Rate{" +
                "date='" + date + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
