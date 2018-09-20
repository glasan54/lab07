//Pakapol Sanargree

package lab07;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class EditCon {

    private String fileLog = "D:\\Work\\workspace\\lab07\\src\\main\\resources\\Log.txt";
    private String date;



    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;


    @FXML
    public void checkTime(ActionEvent actionEvent) {
        if (checkDate()){
            date = day.getText() + "/" + month.getText() + "/" + year.getText();

            try {
                FileReader fileReader = new FileReader(fileLog);

            }catch(FileNotFoundException ex) {

                System.out.println(
                        "Unable to open file '" + fileLog + "'");

            }
            catch(IOException ex) {

                System.out.println(
                        "Error reading file '" + fileLog + "'");

            }
        }
    }





    private boolean checkDate(){

        boolean check = false;

        if (!day.getText().equals("DD") || !month.getText().equals("MM") || !year.getText().equals("YYYY")){

            if (isNumeric(day.getText()) || isNumeric(month.getText()) || isNumeric(year.getText())){
                return check = true;
            }

        }

        return check;

    }



    private boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }



}
