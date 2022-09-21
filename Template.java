public class Template {
    public static void main(String[] args) {
        System.out.println("-----Making Veg Pizza-----");
        PizzaMaker vegPizzaMaker = new VegPizzaMaker();
        vegPizzaMaker.makePizza();
        System.out.println("-----Making Non Veg Pizza-----");
        PizzaMaker nonVegPizzaMaker = new NonVegPizzaMaker();
        nonVegPizzaMaker.makePizza();
    }
}

abstract class PizzaMaker {
    public void makePizza() {
        preparePizzaDough();
        preBakeCrust();
        prepareIngredients();
        addToppings();
        bakePizza();
        if (customerWantsPackedPizza()) {
            packPizza();
        }
    }
    final void preparePizzaDough() {
        System.out.println("Preparing pizza dough.");
    }
    final void preBakeCrust() {
        System.out.println("Pre baking crust.");
    }
    abstract void prepareIngredients();
    abstract void addToppings();
    void bakePizza() {
        System.out.println("Baking pizza.");
    }
    void packPizza() {
        System.out.println("Packing pizza.");
    }
    boolean customerWantsPackedPizza() {
        return true;
    }
}

class VegPizzaMaker extends PizzaMaker {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing tomato slices.");
    }
    @Override
    public void addToppings() {
        System.out.println("Adding mozzerella cheese to crust.");
    }
}

class NonVegPizzaMaker extends PizzaMaker {
    @Override
    public void prepareIngredients() {
        System.out.println("Preparing chicken ham.");
    }
    @Override
    public void addToppings() {
        System.out.println("Adding cheese and BBQ to crust.");
    }
}