package abstractfactory;

public class MacOSButton implements Button{
    @Override
    public void paint(){
        System.out.println("Rendering macos button");
    }
}
