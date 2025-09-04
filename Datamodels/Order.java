package Datamodels;
import java.util.*;

public record Order(String orderId, List<Product> products, String customerEmail) { 
    public double getTotalPrice() {
        double Total = 0;
        for (Product p : products) {
            Total = Total + p.price();
        }
        return Total;
        
    }
}
