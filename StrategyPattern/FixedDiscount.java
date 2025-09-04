package StrategyPattern;
import Datamodels.*;
public class FixedDiscount implements DiscountStrategy {
    private final double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }
   
    public double applyDiscount(Order order) {
        return order.getTotalPrice()- amount;
    }
    
}
