public class Rate {
    private String date;
    private float bid;
    private float ask;
    private float askChange;
    private float bidChange;

    public Rate(String date, float bid, float ask, float askChange, float bidChange) {
        this.date = date;
        this.bid = bid;
        this.ask = ask;
        this.askChange = askChange;
        this.bidChange = bidChange;
    }

    public String getDate() {
        return date;
    }

    public float getBid() {
        return bid;
    }

    public float getAsk() {
        return ask;
    }

    public float getAskChange() {
        return askChange;
    }

    public float getBidChange() {
        return bidChange;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "date='" + date + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", askChange=" + askChange +
                ", bidChange=" + bidChange +
                '}';
    }
}
