package id.putraprima.mygoldtracker.api.models;

public class Price {
    private String priceId;
    private float sell_price;
    private float buy_price;
    private String date;
    private float partner_sell_price;
    private float tokopedia_sell_percentage;
    private float is_future;


    public Price(String priceId, float sell_price, float buy_price, String date, float partner_sell_price, float tokopedia_sell_percentage, float is_future) {
        this.priceId = priceId;
        this.sell_price = sell_price;
        this.buy_price = buy_price;
        this.date = date;
        this.partner_sell_price = partner_sell_price;
        this.tokopedia_sell_percentage = tokopedia_sell_percentage;
        this.is_future = is_future;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public float getSell_price() {
        return sell_price;
    }

    public void setSell_price(float sell_price) {
        this.sell_price = sell_price;
    }

    public float getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(float buy_price) {
        this.buy_price = buy_price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPartner_sell_price() {
        return partner_sell_price;
    }

    public void setPartner_sell_price(float partner_sell_price) {
        this.partner_sell_price = partner_sell_price;
    }

    public float getTokopedia_sell_percentage() {
        return tokopedia_sell_percentage;
    }

    public void setTokopedia_sell_percentage(float tokopedia_sell_percentage) {
        this.tokopedia_sell_percentage = tokopedia_sell_percentage;
    }

    public float getIs_future() {
        return is_future;
    }

    public void setIs_future(float is_future) {
        this.is_future = is_future;
    }
}
