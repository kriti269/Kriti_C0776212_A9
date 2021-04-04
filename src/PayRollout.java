import javax.swing.*;

public class PayRollout {
    public static void main(String[] args){
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


        Salesperson salesperson = new Salesperson(123, "Kriti", "Sharma",
                Gender.FEMALE, totalSales, advancePay);
        salesperson.setRateOfCommission();
        salesperson.calculatePay();
        salesperson.displayDetails();
    }
}
