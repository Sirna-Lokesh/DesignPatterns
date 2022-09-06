import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    public static void main(String[] args) {
        Component mouse=new Leaf(400,"mouse");
        Component keyboard=new Leaf(300,"keyboard");
        Component RAM=new Leaf(4000,"RAM");
        Component harddrive=new Leaf(4500,"HDD");
        Component monitor=new Leaf(9000,"Monitor");
        Component cpu=new Leaf(12000,"cpu");

        Composite peripherals=new Composite("Peripherals");
        Composite cabinet=new Composite("Cabinet");
        Composite motherboard=new Composite("motherboard");
        Composite Computer=new Composite("Computer");

        motherboard.addComponent(cpu);

        peripherals.addComponent(mouse);
        peripherals.addComponent(monitor);
        peripherals.addComponent(keyboard);

        cabinet.addComponent(harddrive);
        cabinet.addComponent(motherboard);
        cabinet.addComponent(RAM);

        Computer.addComponent(peripherals);
        Computer.addComponent(cabinet);
        Computer.addComponent(motherboard);
        

        peripherals.showPrice();
    }
}

interface Component{
    public void showPrice();
}

class Leaf implements Component{
    int price; 
    String name;
    
    public Leaf(int price, String name) {
        this.price = price;
        this.name = name;
    }


    @Override
    public void showPrice() {
        System.out.println(name +"  :  "+ price);
    }

}

class Composite implements Component{
    String name;
    List<Component> components;

    
    public Composite(String name) {
        this.name = name;
        components=new ArrayList<>();
    }

    public void addComponent(Component com){
        components.add(com);
    }

    @Override
    public void showPrice() {
        for(Component c: components){
            c.showPrice();
        }
        
    }

}
