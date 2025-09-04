package ObserverPattern;
import Datamodels.Order;

public interface OrderObserver {
    public void update(Order order);
}
