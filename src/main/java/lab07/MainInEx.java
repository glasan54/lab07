//Pakapol Sanarge 5810405223

package lab07;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class MainInEx implements Runnable {

    private String fileLog = "D:\\Work\\workspace\\lab07\\src\\main\\resources\\Log.txt";
    private String fileTotal = "D:\\Work\\workspace\\lab07\\src\\main\\resources\\Total.txt";

    private String log;
    private int totalMoney;
    private String type;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField incomeField;

    @FXML
    private TextField  expenseField;

    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    public void onIncomeHandler(ActionEvent actionEvent) {

        type = "income";

        if (!incomeField.getText().equals("Add Income")){

            if (checkDate()) {
                if (incomeField.getText().equals("")) {

                    addText("Please fill all blank field.");

                } else if (isNumeric(incomeField.getText())) {

                    printLine(type,incomeField.getText());
                    startThread();

                }

            }else{
                addText("Please fill the date.");
            }

        }else{
            addText("Wow.");
        }


        addLineSeparator();
    }


    @FXML
    public void addExpenseHandler(ActionEvent actionEvent) {

        type = "expense";

        if (!expenseField.getText().equals("Add Expense")){

            if (checkDate()) {

                if (expenseField.getText().equals("")) {

                    addText("Please fill all blank field");

                } else if (isNumeric(expenseField.getText())) {

                    printLine(type,expenseField.getText());
                    startThread();


                } else {

                    addText("Add numberic please.");

                }

            }else{

                addText("Please fill the date.");
            }

        }else{
            addText("Wow.");
        }



        addLineSeparator();

    }



    @FXML
    public void checkTotalBtn(ActionEvent actionEvent) {
        addText("Your total is "+ totalMoney+".");
        addLineSeparator();
    }






    @FXML
    public void editBtn(ActionEvent actionEvent) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("editUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("แก้ไข");
            stage.setScene(new Scene(root, 536, 350));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void startThread() {
        Thread t = new Thread(this);
        t.start();
        t.interrupt();
    }


    @Override
    public void run() {
        //open file

        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileWriter fileWriter = new FileWriter(fileLog);

            // Always wrap FileReader in BufferedReader.
            PrintWriter writer = new PrintWriter(fileWriter);

            writer.print(log);

            // Always close files.
            writer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileLog + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileLog + "'");
        }
    }









    private void printLine(String type,String amount){

        totalMoney += toNum(amount);
        this.log = type + " = " + amount + ". date " + day.getText() + "/" + month.getText() + "/" + year.getText() + ".";
        addText(log);
        addText("Your total money = " + totalMoney + ".");

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

    private int toNum(String come){
        return (Integer.valueOf(come));
    }

    private void addText(String line) {
        textArea.appendText(line+'\n');
    }




    private void addLineSeparator() {
        textArea.appendText("--------------------------------\n");
    }



}

