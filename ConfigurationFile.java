
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

  BufferedReader objReader;
  String strCurrentLine, strNoLeftbrackets, strNoRightBrackets;
  String[] strFinal, configurationString;

  public void saveConfiguration(ArrayList<String> selected_list) {
    try {
      FileWriter fstream = new FileWriter("resources/config.txt");
      BufferedWriter out = new BufferedWriter(fstream);
      out.write(selected_list.toString());
      out.close();
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  public String[] readElements() {
    try {
      objReader = new BufferedReader(new FileReader("resources/config.txt"));
      strCurrentLine = objReader.readLine();
      strNoLeftbrackets = strCurrentLine.replace("[", "");
      strNoRightBrackets = strNoLeftbrackets.replace("]", "");
      strFinal = strNoRightBrackets.split(",");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    return strFinal;
  }
}
