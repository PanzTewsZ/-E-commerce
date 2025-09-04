package DecoratorPattern;
import Datamodels.Order;
import FactoryMethodPattern.Shipment;

public class InsuranceDecorator extends ShipmentDecorator{
Order order;
    public InsuranceDecorator(Shipment shipment, Order order) {
        super(shipment);
        this.order = order;
    }
    
    public String getInfo(){
        return super.getInfo()+ "+ Insurance";
    }

    public double getCost(){
        return super.getCost() + (order.getTotalPrice()*10)/100.0;
    }
}
