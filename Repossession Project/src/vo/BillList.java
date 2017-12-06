package vo;

public class BillList {

	private int bill_No;
	private String bill_Date;
	private String loan_No;
	private String reg_No;
	private int bill_Amount;
	private String finance;
	private String status;
	
	
	
	public int getBill_No() {
		return bill_No;
	}
	public void setBill_No(int bill_No) {
		this.bill_No = bill_No;
	}
	public String getBill_Date() {
		return bill_Date;
	}
	public void setBill_Date(String bill_Date) {
		this.bill_Date = bill_Date;
	}
	public String getLoan_No() {
		return loan_No;
	}
	public void setLoan_No(String loan_No) {
		this.loan_No = loan_No;
	}
	public String getReg_No() {
		return reg_No;
	}
	public void setReg_No(String reg_No) {
		this.reg_No = reg_No;
	}
	public int getBill_Amount() {
		return bill_Amount;
	}
	public void setBill_Amount(int bill_Amount) {
		this.bill_Amount = bill_Amount;
	}
	public String getFinance() {
		return finance;
	}
	public void setFinance(String finance) {
		this.finance = finance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
