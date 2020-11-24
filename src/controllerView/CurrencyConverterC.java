package controllerView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Currency;
import model.CurrencyConverter;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Controller für CurrencyConverter
 * @author Simon Sperr
 * @version 2020.1.1, 22.11.2020
 */
public class CurrencyConverterC implements Initializable {
  
  @FXML
  private TextField txtEuro;
  @FXML
  private TextField txtYen;
  @FXML
  private ChoiceBox currencies;

  private CurrencyConverter currencyConverter;
  
  private static final  NumberFormat DEC2FORMAT;
  
  static {
    DEC2FORMAT = NumberFormat.getNumberInstance();
    DEC2FORMAT.setGroupingUsed(true);
    DEC2FORMAT.setMinimumFractionDigits(2);
    DEC2FORMAT.setMaximumFractionDigits(2);
  }
  
  /**
   * Passiert, wenn der Umrechnungs-Button gedrückt wird
   */
  @FXML
  public void btnConvertAction() {
    //  besser in Methode auslagern, weil gleiche Funktionalitäten via GUIs häufig auf verschiedene Weisen aufgerufen werden können.
    convert();
  }
  
  /**
   * Konvertierung Euro -> Currency
   */
  private void convert() {
    try {
      double euro = DEC2FORMAT.parse(txtEuro.getText()).doubleValue();
      double currency = currencyConverter.euroToCurrency((String)currencies.getValue(), euro);
      txtYen.setText(DEC2FORMAT.format(currency));
    }
    catch (ParseException e) {
      System.out.println("Fehler bei der Umwandlung!");
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    currencyConverter = new CurrencyConverter();
    for (Currency c : currencyConverter.getCurrencyList()) {
      currencies.getItems().add(c.getSign());
    }
    currencies.setValue("Zielwährung");
  }
}
