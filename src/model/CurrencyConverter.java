package model;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *@author Simon Sperr
 *@version 2020.1.1, 22.11.2020
 */
public class CurrencyConverter {

    public CurrencyConverter()
    {
        currencyList.add(new Currency("Yen", 124));
        currencyList.add(new Currency("US Dollar", 1.19));
        currencyList.add(new Currency("Canadian Dollar", 1.55));
    }

    private ArrayList<Currency> currencyList = new ArrayList<Currency>();

    public ArrayList<Currency> getCurrencyList() {
        return currencyList;
    }

    public void addCurrency(Currency c) {
        this.currencyList.add(c);
    }

    public double euroToCurrency(String sign, double euro)
    {
        double currency = 0;
        for (Currency c: currencyList) {
            if(sign.equals(c.getSign())) {
                currency = euro * c.getValue();
            }
        }
        return currency;
    }
}
