import javax.swing.*;

/**
 * Represents a pay rollout functionality that
 * calculates pay and displays employee details.
 * @author Kriti C0776212
 */

public class PayRollout {
    public static void main(String[] args){
        //Taking total sales and advance payment as input from user
        double totalSales=0, advancePay=0;
        boolean inputCheck = false;
        do{
            try {
                totalSales = Double.parseDouble(JOptionPane.showInputDialog("Please enter total sales: "));
                inputCheck = true;
            }
            catch (Exception ex){
                inputCheck = false;
            }

        }while(!inputCheck || totalSales<=0);

        do{
            try{
                advancePay = Double.parseDouble(JOptionPane.showInputDialog("Please enter advance pay: "));
                inputCheck = true;
            }
            catch (Exception ex){
                inputCheck = false;
            }

        }while(!inputCheck || advancePay<=0);

        // Creating a salesperson object
        Salesperson salesperson = new Salesperson(123, "Kriti", "Sharma",
                Gender.FEMALE, totalSales, advancePay);
        // Calculating and displaying details.
        salesperson.setRateOfCommission();
        salesperson.calculatePay();
        salesperson.displayDetails();
    }
}
