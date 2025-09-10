package ObserverPattern;
import Datamodels.*;
import java.util.*;

public class OrderProcessor {
   private  ArrayList<OrderObserver> observers = new ArrayList<>();

   public void register(OrderObserver observer) {
      observers.add(observer);
   }
   
   public void unregister(OrderObserver observer){
      observers.remove(observer);
    }
    private void notifyObservers(Order order){
      for(OrderObserver observer : observers){
         observer.update(order);
      }
    }
    public void processOrder(Order order){
      System.out.println("\nProcessing order " + order.orderId());
      System.out.println("Order processed successfully.");
      notifyObservers(order);
   }
}
