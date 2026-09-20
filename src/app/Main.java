package app;
import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter delivery mode: ");
        String deliveryMode=scanner.nextLine().trim().toUpperCase();
        Logistics logistics;
        switch (deliveryMode){
            case "ROAD":
                logistics=new RoadLogistics();
                break;
            case "SEA":
                logistics=new SeaLogistics();
                break;
            default:
                System.out.println("Unstopped delivery mode:"+deliveryMode);
                System.out.println("Supported values: ROAD, SEA.");
                scanner.close();
                return;
        }
        System.out.println("Enter UI platform (WINDOWS or MACOS): ");
        String platform=scanner.nextLine().trim().toUpperCase();
        GUIFactory factory;
        switch (platform){
            case "WINDOWS":
                factory =new WindowsFactory();
                break;
            case "MACOS":
                factory=new MacOSFactory();
                break;
            default:
                System.out.println("Unsupported UI platform"+ platform);
                System.out.println("Supported value: WINDOWS, MACOS.");
                scanner.close();
                return;
        }
        String cargo="laboratory equipment";
        String destination="Aktau warehouse";
        System.out.println();
        System.out.println("Delivery mode: "+deliveryMode);
        System.out.println("UI platform: "+platform);
        DeliveryApplication application=new DeliveryApplication(factory,logistics);
        application.run(cargo,destination);
        scanner.close();
    }
}
