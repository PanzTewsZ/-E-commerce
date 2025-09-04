package StrategyPattern;
import Datamodels.Order;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentagediscount;

    public PercentageDiscount(double percentagediscount) {
        this.percentagediscount = percentagediscount;
    }
   
    public double applyDiscount(Order order) {
        return order.getTotalPrice() - (order.getTotalPrice()*percentagediscount/100);
    } 
}
