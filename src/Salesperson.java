import javax.swing.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Represents a salesperson
 * @author Kriti C0776212
 */
public class Salesperson {
    public int employeeId;
    protected String firstName;
    protected String lastName;
    protected Gender gender;
    protected double pay;
    double totalSales;
    double rateOfCommission;
    double totalCommission;
    double advancePayment;

    /**
     * Initializes a Salesperson object
     * @param employeeId int
     * @param firstName String
     * @param lastName String
     * @param gender Gender
     * @param totalSales double
     * @param advancePayment double
     */
    public Salesperson(int employeeId, String firstName, String lastName, Gender gender, double totalSales, double advancePayment) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.totalSales = totalSales;
        this.advancePayment = advancePayment;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getRateOfCommission() {
        return rateOfCommission;
    }

    public void setRateOfCommission(double rateOfCommission) {
        this.rateOfCommission = rateOfCommission;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    /**
     * Overloaded function. Sets the rateOfCommission based on
     * totalSales. Calls calculateCommission() to set the total
     * commission from rateOfCommission.
     */
    public void setRateOfCommission(){

        if(this.totalSales >= 22000){
            this.rateOfCommission = 16;
        }
        else if(this.totalSales >= 18000){
            this.rateOfCommission = 15;
        }
        else if(this.totalSales >= 15000){
            this.rateOfCommission = 12;
        }
        else if(this.totalSales >= 10000){
            this.rateOfCommission = 10;
        }
        else{
            this.rateOfCommission = 5;
        }
        this.calculateCommission();
    }

    /**
     * Calculates totalCommission based on rateOfCommission and totalSales.
     */
    private void calculateCommission(){

        this.totalCommission = this.rateOfCommission/100 * this.totalSales;
    }

    /**
     * Calculates pay by deducting advancePayment from totalCommission.
     */
    public void calculatePay() {

        this.pay = this.totalCommission - this.advancePayment;
    }

    /**
     * Displays salesperson details and gross pay to be deducted or deposited.
     */
    public void displayDetails(){
        Locale canadian = new Locale("en", "CA");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(canadian);

        String employeeDetails = "";
        employeeDetails = employeeDetails.concat("\nHi! ");
        employeeDetails = employeeDetails.concat("\nId: " + this.employeeId);
        employeeDetails = employeeDetails.concat("\nName: " + this.firstName + " " + this.lastName);
        employeeDetails = employeeDetails.concat("\nGender: " + this.gender);
        employeeDetails = employeeDetails.concat("\nAdvance pay: " + numberFormat.format(this.advancePayment));
        employeeDetails = employeeDetails.concat("\nGross pay: " + numberFormat.format(this.pay));

        if(this.pay > 0){
            employeeDetails = employeeDetails.concat("\n\n"+ numberFormat.format(this.pay)
                    + " will be deposited to your account!");
        }
        else{
            employeeDetails = employeeDetails.concat("\n\n"+ numberFormat.format(Math.abs(this.pay))
                    + " will be deducted from your account!");
        }

        JOptionPane.showMessageDialog(null, employeeDetails);
    }
}
