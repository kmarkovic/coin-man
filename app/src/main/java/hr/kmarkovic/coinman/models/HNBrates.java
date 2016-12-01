package hr.kmarkovic.coinman.models;

/**
 * Created by Kristian on 1.12.2016..
 */

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class HNBrates {

    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("unit_value")
    @Expose
    private Integer unitValue;
    @SerializedName("selling_rate")
    @Expose
    private String sellingRate;
    @SerializedName("buying_rate")
    @Expose
    private String buyingRate;
    @SerializedName("median_rate")
    @Expose
    private String medianRate;

    /**
     *
     * @return
     * The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     *
     * @param currencyCode
     * The currency_code
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     *
     * @return
     * The unitValue
     */
    public Integer getUnitValue() {
        return unitValue;
    }

    /**
     *
     * @param unitValue
     * The unit_value
     */
    public void setUnitValue(Integer unitValue) {
        this.unitValue = unitValue;
    }

    /**
     *
     * @return
     * The sellingRate
     */
    public String getSellingRate() {
        return sellingRate;
    }

    /**
     *
     * @param sellingRate
     * The selling_rate
     */
    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    /**
     *
     * @return
     * The buyingRate
     */
    public String getBuyingRate() {
        return buyingRate;
    }

    /**
     *
     * @param buyingRate
     * The buying_rate
     */
    public void setBuyingRate(String buyingRate) {
        this.buyingRate = buyingRate;
    }

    /**
     *
     * @return
     * The medianRate
     */
    public String getMedianRate() {
        return medianRate;
    }

    /**
     *
     * @param medianRate
     * The median_rate
     */
    public void setMedianRate(String medianRate) {
        this.medianRate = medianRate;
    }

}