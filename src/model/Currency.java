package model;
/**
 *@author Simon Sperr
 *@version 2020.1.1, 22.11.2020
 */
public class Currency {

    private String sign;
    private double value;

    Currency(String sign, double value)
    {
        this.setSign(sign);
        this.setValue(value);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getValue() {
        return value;
    }

    public String getSign() {
        return sign;
    }
}
