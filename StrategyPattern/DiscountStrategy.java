package StrategyPattern;
import Datamodels.*;

// Interface ส่วนลด
public interface DiscountStrategy {
    double applyDiscount(Order order);
}
