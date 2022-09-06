interface Pizza{
    public void prepare();
    public void bake();
    public void cut();
}

class VegPizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veg Pizza");  
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veg Pizza"); 
    }

}
class CheesePizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Pizza");  
    }

    @Override
    public void cut() {
        System.out.println("Cutting Cheese Pizza"); 
    }

}

class ChickenPizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza");  
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicken Pizza"); 
    }

}

class PizzaStore{
    public Pizza order(String type){
        Pizza p=PizzaFactory.createPizza(type);
        p.prepare();
        p.bake();
        p.cut();
        return p;
    }
}
class PizzaFactory{
    public static Pizza createPizza(String type){
        Pizza p=null;
        if(type.equals("cheese")){
            p=new CheesePizza();
        }
        else if(type.equals("chicken")){
            p=new ChickenPizza();
        }
        else if(type.equals("veg")){
            p=new VegPizza();
        }
        return p;
    }
}

public class Factory{
    public static void main(String[] args) {
        PizzaStore store=new PizzaStore();
        Pizza p=store.order("cheese");
        System.out.println(p);
    }
}