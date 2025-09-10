import ObserverPattern.*;
import StrategyPattern.*;
import Datamodels.*;
import DecoratorPattern.*;
import FactoryMethodPattern.*;
import java.util.*;


public class TestRunner {
    public static void main (String[] args) {
        System.out.println("--- E-commerce System Simulation ---");

        // — 1. Setup —
        Product laptop = new Product("P001", "Laptop", 30000.0);
        Product mouse = new Product("P002" , "Mouse", 800.0);
        Order myOrder = new Order ("ORD-001", List.of(laptop, mouse), "customer@example. com");

        OrderCalculator calculator = new OrderCalculator();
        ShipmentFactory shipmentFactory = new ShipmentFactory();
        OrderProcessor orderProcessor = new OrderProcessor () ;

        InventoryService inventory = new InventoryService();
        EmailService emailer = new EmailService();
        orderProcessor. register (inventory);
        orderProcessor.register(emailer);

        System.out.println("\n— 2. Testing Strategy Pattern (Discounts) —");
        double originalPrice = myOrder.getTotalPrice();  // คำนวณราคารวมของคำสั่งซื้อก่อนส่วนลด
        System.out.println("Original Price: " + originalPrice);  // แสดงราคารวม

        DiscountStrategy tenPercentOff = new PercentageDiscount(10);
        double priceAfterPercentage = calculator.calculateFinalPrice(myOrder, tenPercentOff);
        System.out.println("Price with 10% Discount: " + priceAfterPercentage);

        DiscountStrategy fixedHundredOff = new FixedDiscount(500);
        double priceAfterFixed = calculator.calculateFinalPrice(myOrder, fixedHundredOff);
        System.out.println("Price with 500 THB Discount: " + priceAfterFixed);

        System.out.println("\n— 3. Testing Factory and Decorator Patterns (Shipments) —");
        // สร้างการจัดส่งแบบมาตรฐาน
        Shipment standardshipment = shipmentFactory.createShipment("STANDARD");
        System.out.println("Bese Shipment: " + standardshipment.getInfo() + ", Cost: " + standardshipment.getCost());

        // "ห่อ" ด้วยบริการห่อของขวัญ
        Shipment giftWrapped = new GiftWrapDecorator(standardshipment);
        System.out.println("Decorated: " + giftWrapped.getInfo() + ", Cost: " + giftWrapped.getCost());

        // "ห่อ" ด้วยบริการประกันภัยสินค้า
        Shipment fullyLoaded = new InsuranceDecorator(giftWrapped , myOrder);
        System.out.println("Fully Decorated: " + fullyLoaded.getInfo() + ", Cost: " + fullyLoaded.getCost());

        System.out.println("\n— 4. Printing Final Summary —");
        double finalPrice = priceAfterPercentage;
        double totalCost = finalPrice + fullyLoaded.getCost();
        System.out.println("Final Price after Discount: " + finalPrice);
        System.out.println("Final shipment cost: " + fullyLoaded.getCost());
        System.out.println("TOTAL TO PAY: " + totalCost + "\n");

        // — 5. Testing Observer Pattern (Order Processing) —
        orderProcessor.processOrder(myOrder);
    }
}