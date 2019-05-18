package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    private BigDecimal subTotal;
    private BigDecimal grandTotal;
    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;
    public PriceCaculator(){

    }
    public PriceCaculator(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax){
        this.orderLineItemList = orderLineItemList;
        this.discounts = discounts;
        this.tax = tax;
        subTotal = new BigDecimal(0);
    }

    public BigDecimal newCalculate() {

        // Total up line items
        totalUpLineItems();
        // Subtract discounts
        subtractDiscounts();
        // calculate tax
        calculateTax();
        // calculate GrandTotal
        calculateGrandTotal();
        return grandTotal;
    }

    private void totalUpLineItems(){
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }

    private void subtractDiscounts(){
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }

    private void calculateTax(){
        tax = subTotal.multiply(tax);
    }

    private void calculateGrandTotal(){
        grandTotal = subTotal.add(tax);
    }
}
