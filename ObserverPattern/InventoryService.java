package ObserverPattern;

import Datamodels.Order;

public class InventoryService implements OrderObserver {
    public void update(Order order){
        System.out.println("Inventory updated for order " + order.orderId());
    }
}
