package ObserverPattern;
import Datamodels.*;
import java.util.*;

public class OrderProcessor {
   private  ArrayList<OrderObserver> observers = new ArrayList<>();

   public void register(OrderObserver observer) {
      observers.add(observer);
   }
   
   public void unregister(OrderObserver observer) {
      observers.remove(observer);
   }
}
