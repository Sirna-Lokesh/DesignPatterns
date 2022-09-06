public class Visitor {
    public static void main(String[] args) {
        Offer hoffer=new HotelOffer();
        CreditCard silver = new SilverCreditCard();
        silver.accept(hoffer);
    }
}

interface CreditCard {
    public String getName();

    public void accept(Offer v);
}

interface Offer { // visitor
    public void visitSilverCreditCArd(SilverCreditCard card);

    public void visitGoldCreditCArd(GoldCreditCard card);

    public void visitPlatinumCreditCArd(PlatinumCreditCard card);

}

class SilverCreditCard implements CreditCard {

    @Override
    public String getName() {
        return "Silver Credit Card";
    }

    @Override
    public void accept(Offer v) {
        v.visitSilverCreditCArd(this);

    }

}

class GoldCreditCard implements CreditCard {

    @Override
    public String getName() {
        return "Gold Credit Card";
    }

    @Override
    public void accept(Offer v) {
        v.visitGoldCreditCArd(this);
    }

}

class PlatinumCreditCard implements CreditCard {

    @Override
    public String getName() {
        return "Platinum Credit Card";
    }

    @Override
    public void accept(Offer v) {
        v.visitPlatinumCreditCArd(this);
    }

}

class GasOffer implements Offer {

    @Override
    public void visitSilverCreditCArd(SilverCreditCard card) {
        System.out.println("calculating  discount offer for buying gas via Silver Credit Card");
    }

    @Override
    public void visitGoldCreditCArd(GoldCreditCard card) {
        System.out.println("calculating  discount offer for buying gas via Gold Credit Card");
    }

    @Override
    public void visitPlatinumCreditCArd(PlatinumCreditCard card) {
        System.out.println("calculating  discount offer for buying gas via Platinum Credit Card");
    }

}

class HotelOffer implements Offer {

    @Override
    public void visitSilverCreditCArd(SilverCreditCard card) {
        System.out.println("calculating  discount offer for booking hotel via Silver Credit Card");
    }

    @Override
    public void visitGoldCreditCArd(GoldCreditCard card) {
        System.out.println("calculating  discount offer for booking hotel via Gold Credit Card");
    }

    @Override
    public void visitPlatinumCreditCArd(PlatinumCreditCard card) {
        System.out.println("calculating  discount offer for booking hotel via Platinum Credit Card");
    }

}
