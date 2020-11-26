
/**
 * @author axl
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConfigurationFile {
  String FILE = "resources/config.txt";
  BufferedReader objReader;
  BufferedWriter outWriter;
  FileReader fr;
  FileWriter fw;
  String strCurrentLine, strNoLeftbrackets, strNoRightBrackets;
  String[] strFinal = null;

  public void saveConfiguration(ArrayList<String> selected_list) {
    try {
      fw = new FileWriter(FILE);
      outWriter = new BufferedWriter(fw);
      outWriter.write(selected_list.toString());
      outWriter.close();
    } catch (Exception e) {
      errorMessage(e);
    }
  }

  public String[] readElements() {
    try {
      fr = new FileReader(FILE);
      objReader = new BufferedReader(fr);
      strCurrentLine = objReader.readLine();
      strNoLeftbrackets = strCurrentLine.replace("[", "");
      strNoRightBrackets = strNoLeftbrackets.replace("]", "");
      strFinal = strNoRightBrackets.split(",");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      errorMessage(e);
    }

    return strFinal;
  }

  public void errorMessage(Exception e) {
    System.err.println("Error: " + e.getMessage());
  }
}
