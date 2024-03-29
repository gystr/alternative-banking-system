package core.entities;

import core.dtos.AdminLoanDTO;
import core.dtos.SingleLoanDTO;
import core.utils.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loan implements Comparable{




    public enum LoanStatus {NEW,ACTIVE,PENDING,RISK,FINISHED}

    String id;
    int startDate;
    int endDate;
    double amount;
    double remainingAmount;
    Customer borrower;
    ArrayList<Customer> lenders;
    Map<String,Double> lenderAmounts;
    LoanStatus status;
    String category;
    int interestRate;
    String ownerName;
    int lengthOfTime;
    int timeBetweenPayments;
    int timeNextPayment;
    double unpaidDebt;
    double paymentPerYaz ;
    double singlePayment;
    double singlePaymentTotal ;
    double completeAmountToBePaid;
    double amountPaidUntilNow;
    List<Transaction> payments;
    boolean paidThisYaz = false;

    public Loan(String id, int startData, int amount, Customer borrower, ArrayList<Customer> lenders, LoanStatus status,
                String category, int interestRate,String ownerName,int lengthOfTime,int timeBetweenPayments) {
        this.id = id;
        this.startDate = startData;
        this.amount = amount;
        this.remainingAmount = amount;
        this.borrower = borrower;
        this.lenders = lenders;
        this.status = status;
        this.category = category;
        this.interestRate = interestRate;
        this.ownerName = ownerName;
        this.lengthOfTime = lengthOfTime;
        this.timeBetweenPayments = timeBetweenPayments;
        this.lenderAmounts = new HashMap<>();
        this.timeNextPayment = timeBetweenPayments;

        this.paymentPerYaz = amount / lengthOfTime;
        this.singlePayment = paymentPerYaz * timeBetweenPayments;
        this.singlePaymentTotal = singlePayment + (singlePayment * interestRate / 100);
        this.completeAmountToBePaid = singlePaymentTotal * (lengthOfTime / timeBetweenPayments);
        this.amountPaidUntilNow = 0.0;
        this.payments = new ArrayList<>();
    }

    public Loan(SingleLoanDTO loanDTO,String userName){
        this.id = loanDTO.getId();
        this.startDate = 1;
        this.amount = loanDTO.getAbsCapital();
        this.remainingAmount = amount;
        this.borrower = new Customer(userName,false);
        this.lenders = new ArrayList<>();
        this.status = loanDTO.status;
        this.category = loanDTO.getAbsCategory();
        this.interestRate = loanDTO.getAbsIntristPerPayment();
        this.ownerName = userName;
        this.lengthOfTime = loanDTO.getAbsTotalYazTime();
        this.timeBetweenPayments = loanDTO.getAbsPaysEveryYaz();
        this.lenderAmounts = new HashMap<>();
        this.timeNextPayment = timeBetweenPayments;

        this.paymentPerYaz = amount / lengthOfTime;
        this.singlePayment = paymentPerYaz * timeBetweenPayments;
        this.singlePaymentTotal = singlePayment + (singlePayment * interestRate / 100);
        this.completeAmountToBePaid = singlePaymentTotal * (lengthOfTime / timeBetweenPayments);
        this.amountPaidUntilNow = 0.0;
        this.payments = new ArrayList<>();
    }
    public Loan(AdminLoanDTO loanDTO){

        this.id = loanDTO.getId();
        this.startDate = 1;
        this.amount = loanDTO.getAmount();
        this.remainingAmount = loanDTO.getRemainingAmount();
        this.borrower = new Customer(loanDTO.getOwnerName(),false);
        this.lenders = new ArrayList<>();
        this.status = LoanStatus.valueOf(loanDTO.getStatus());
        this.category = loanDTO.getCategory();
        this.interestRate = loanDTO.getInterestRate();
        this.ownerName = loanDTO.getOwnerName();
        this.lengthOfTime = loanDTO.getLengthOfTime();
        this.timeBetweenPayments = loanDTO.getTimeBetweenPayments();
        this.lenderAmounts = new HashMap<>();
        this.timeNextPayment = loanDTO.getTimeNextPayment();

        this.paymentPerYaz = amount / lengthOfTime;
        this.singlePayment = paymentPerYaz * timeBetweenPayments;
        this.singlePaymentTotal = singlePayment + (singlePayment * interestRate / 100);
        this.completeAmountToBePaid = singlePaymentTotal * (lengthOfTime / timeBetweenPayments);
        this.amountPaidUntilNow = 0.0;
        this.payments = new ArrayList<>();
    }

    public Loan(Loan loan){
        this.id = loan.id;
        this.startDate = loan.getStartDate();
        this.amount = loan.getAmount();
        this.remainingAmount = loan.getRemainingAmount();
        this.borrower = loan.borrower;
        this.lenders = loan.lenders;
        this.status = loan.getStatus();
        this.category = loan.getCategory();
        this.interestRate = loan.getInterestRate();
        this.ownerName = loan.getOwnerName();
        this.lengthOfTime = loan.getLengthOfTime();
        this.timeBetweenPayments = loan.getTimeBetweenPayments();
        this.lenderAmounts = new HashMap<>();
        this.timeNextPayment = loan.getTimeNextPayment();

        this.paymentPerYaz = amount / lengthOfTime;
        this.singlePayment = paymentPerYaz * timeBetweenPayments;
        this.singlePaymentTotal = singlePayment + (singlePayment * interestRate / 100);
        this.completeAmountToBePaid = singlePaymentTotal * (lengthOfTime / timeBetweenPayments);
        this.amountPaidUntilNow = loan.getAmountPaidUntilNow();
        this.payments = new ArrayList<>(loan.getPayments());
    }

    @Override
    public int compareTo(Object o) {
        int compareData=((Loan)o).getStartDate();
        /* For Ascending order*/
        return this.startDate-compareData;
    }

    public boolean isPaidThisYaz() {
        return paidThisYaz;
    }

    public void setPaidThisYaz(boolean paidThisYaz) {
        this.paidThisYaz = paidThisYaz;
    }

    public double getCompleteAmountToBePaid() {
        return completeAmountToBePaid;
    }

    public double getAmountPaidUntilNow() {
        return amountPaidUntilNow;
    }

    public void setAmountPaidUntilNow(double amountPaidUntilNow) {
        this.amountPaidUntilNow = amountPaidUntilNow;
    }

    public void setBorrower(Customer borrower) {
        this.borrower = borrower;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getSinglePayment() {
        return singlePayment;
    }

    public int getTimeNextPayment() {
        return timeNextPayment;
    }

    public double getSinglePaymentTotal() {
        return singlePaymentTotal;
    }

    @Override
    public String toString() {
        return  "Id=" + id;
    }

    public Customer getBorrower() {
        return borrower;
    }

    public int getEndDate() {
        return endDate;
    }

    public void addLender(Customer customer, double lendAmount){

        for (int i = 0; i < lenders.size(); i++) {
            if (lenders.get(i).getId().equals(customer.getId())) {
                double temp = lenderAmounts.get(customer.getId());
                lenderAmounts.put(customer.getId(),lendAmount+temp);
                return;
            }

        }

        lenders.add(customer);
        lenderAmounts.put(customer.getId(),lendAmount);
    }
    public void updateStatus(){
        if(lenders.size() > 0 &&status.equals(LoanStatus.NEW) ){
            status = LoanStatus.PENDING;
        }
        if (remainingAmount == 0 && status.equals(LoanStatus.PENDING)){
            status = LoanStatus.ACTIVE;
        }
    }

    public int getStartDate() {
        return startDate;
    }



    public ArrayList<Customer> getLenders() {
        return lenders;
    }

    public Map<String, Double> getLenderAmounts() {
        return lenderAmounts;
    }

    public int getTimeBetweenPayments() {
        return timeBetweenPayments;
    }

    public double getUnpaidDebt() {
        return unpaidDebt;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }


    public double getRemainingAmount() {
        return remainingAmount;
    }

    public String stringForConsole(){
        String loanId = this.id;
        String loanOwnerName = this.ownerName;
        String cat = this.category;

        return "\nLoan ID: " + loanId + "\n" +
                                "Loan Owner: " + loanOwnerName + "\n" +
                                "Loan Category: " + cat + "\n" +
                                "Loan Amount: " + amount + "\n" +
                                "Original length of time: " + this.lengthOfTime + "\n" +
                                "Loan Interest: " + this.interestRate + "\n" +
                                "Pays every: " + this.timeBetweenPayments + "\n" +
                                "Loan Status: " + this.status + "\n" +
                                 generateInfoBasedOnStatus() + "\n";

    }



    public String generateInfoBasedOnStatus(){
        String res;
        if (status.equals(LoanStatus.PENDING)){
            res = "Lenders: ";
            for (Customer c : lenders){
                res += c.getId() +" loaned : " + lenderAmounts.get(c.getId()) +" ,";
            }
            res+= "\nAmount raised by Investors: " + (utils.round(amount - remainingAmount));
            res+= "\nAmount Needed to become active: " + (remainingAmount);
        }else if(status.equals(LoanStatus.ACTIVE)){
            res = "Lenders: ";
            for (Customer c : lenders){
                res += c.getId() +" loaned : " + lenderAmounts.get(c.getId()) +" ,";
            }
            res+= "\nYaz Became active: " + startDate + '\n';
            res+= generatePaymentInfoString();

        }else if(status.equals(LoanStatus.RISK)){
            res = "Lenders: ";
            for (Customer c : lenders){
                res += c.getId() +" loaned : " + lenderAmounts.get(c.getId()) +" ,";
            }
            res+= "\nYaz Became active: " + startDate + '\n';
            res+= generatePaymentInfoString();
            res+= "The Loan is at RISK\n";
            res+= "The amount of unpaid debt is: " + unpaidDebt+ "\n";


        }else if(status.equals(LoanStatus.FINISHED)){
            res = "Lenders: ";
            for (Customer c : lenders){
                res += c.getId() +" loaned : " + lenderAmounts.get(c.getId()) +" ,";
            }
            res+= "\nYaz Became active: " + startDate;
            res+= "\nYaz Loan Finished: " + endDate +"\n";
            res+= generatePaymentInfoString();
        }else{
            res = "";
        }
        return res;
    }

    public String generatePaymentInfoString(){

        String res = "Repayments Given:\n";
        for (int i = 0; i < payments.size(); i++) {
            res+= "\nPayment #" + i + "\n";
            res+= "Date: " + payments.get(i).getDate() + "\n";
            res+= "Keren: " + this.singlePayment + "\n";
            res+= "Interest component: " + (singlePayment * interestRate / 100) + "\n";
            res+= "Total Payment: " + payments.get(i).amount;
        }
        return res;
    }
    public String getId() {
        return id;
    }


    public double getAmount() {
        return amount;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public int getLengthOfTime() {
        return lengthOfTime;
    }


    public String getCategory() {
        return category;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }


    public List<Transaction> getPayments() {
        return payments;
    }

    public void setTimeNextPayment(int timeNextPayment) {
        this.timeNextPayment = timeNextPayment;
    }

    public void setUnpaidDebt(double unpaidDebt) {
        this.unpaidDebt = unpaidDebt;
    }


    public String getInvestorString() {
        StringBuilder res = new StringBuilder();

        for (String name : lenderAmounts.keySet()){
            res.append(name).append(",").append(lenderAmounts.get(name)).append("$");
            res.append(" |");
        }

        return res.toString();
    }

    public void setLenderAmounts(Map<String, Double> lenderAmounts) {
        this.lenderAmounts = lenderAmounts;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
