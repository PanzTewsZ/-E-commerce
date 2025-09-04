package DecoratorPattern;
import FactoryMethodPattern.Shipment;

public class GiftWrapDecorator extends ShipmentDecorator{

    public GiftWrapDecorator(Shipment shipment) {
        super(shipment);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "+ Gift Wrapped";
    }

    @Override
    public double getCost() {
       return super.getCost() + 50.0;
    }
    
}
