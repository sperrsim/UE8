package controllerView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
   * Konvertierung Euro -> Yen
   */
  private void convert() {
    try {
//    double euro = Double.parseDouble(txtEuro.getText());
      double euro = DEC2FORMAT.parse(txtEuro.getText()).doubleValue();
      double yen = currencyConverter.euroToYen(euro);
//    txtYen.setText(String.valueOf(yen));
      txtYen.setText(DEC2FORMAT.format(yen));
    }
    catch (ParseException e) {
      System.out.println(e.getMessage());
//    txtMsg.setText(e.GetMessage);
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    currencyConverter = new CurrencyConverter();
  }
}
