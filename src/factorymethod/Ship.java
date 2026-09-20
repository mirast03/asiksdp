package factorymethod;

public class Ship implements Transport {
    @Override
    public void deliver(String cargo,String detination){
        System.out.println("Ship delivers"+cargo+"to"+detination);
    }
}