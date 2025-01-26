package AssignmentFinal;

import java.util.Date;

public class Visit extends Customer{
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(String name, Date date) {
        super(name);
        this.date = date;
        this.customer = new Customer(name);
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        if (!this.customer.isMember()){
            return this.serviceExpense + this.productExpense;
        }
        else {
            double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
            double productDiscount = DiscountRate.getProductDiscountRate(customer.getMemberType());
            double discountedServiceExpense = serviceExpense * (1 - serviceDiscount);
            double discountedProductExpense = productExpense * (1 - productDiscount);
            return discountedServiceExpense + discountedProductExpense;
        }
    }

    @Override
    public String toString() {
        return "Visit by " + customer + "on "+ date +
                "\n ServiceExpense=" + serviceExpense +
                "\n ProductExpense=" + productExpense +
                "\n Total Expense after Discount: " + getTotalExpense();
    }

    @Override
    public String getName() {
        return this.customer.getName();
    }

    @Override
    public void setMember(boolean member) {
        this.customer.setMember(member);
    }

    @Override
    public String getMemberType() {
        return this.customer.getMemberType();
    }

    @Override
    public void setMemberType(String memberType) {
        this.customer.setMemberType(memberType);
    }
}
