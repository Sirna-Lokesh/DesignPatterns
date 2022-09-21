public class ChainOfResponsibility {
    public static void main(String[] args) {
      AbstractSupportHandler handler=RequestorClient.getHandlerChain();
      handler.receiveRequest(AbstractSupportHandler.TECHNICAL, " Technical Issue");
      handler.receiveRequest(AbstractSupportHandler.BILLING, "Billing Issue");
      handler.receiveRequest(AbstractSupportHandler.GENERAL, "General Issue");
    }
}

abstract class AbstractSupportHandler {
 
    public static int TECHNICAL = 1;
    public static int BILLING = 2;
    public static int GENERAL = 3;
    public int level;
    private AbstractSupportHandler nextHandler;
    public void setNextHandler(AbstractSupportHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    public void receiveRequest(int level, String message){
        if(this.level <= level){
            handleRequest(message);
        }
        if(nextHandler !=null){
            nextHandler.receiveRequest(level, message);
        }
    }
    public abstract void handleRequest(String message);
 
}

class TechnicalSupportHandler extends AbstractSupportHandler { 
    public TechnicalSupportHandler(int level){
        this.level = level;
    } 
    @Override
    public void handleRequest(String message) {
        System.out.println("TechnicalSupportHandler: Processing request " + message);
 
    }
}

class BillingSupportHandler extends AbstractSupportHandler { 
    public BillingSupportHandler(int level){
        this.level = level;
    } 
        @Override
        public void handleRequest (String message){
        System.out.println("BillingSupportHandler: Processing request. " + message);
    }
 
}

class GeneralSupportHandler extends AbstractSupportHandler {
    public GeneralSupportHandler(int level){
        this.level = level;
    }
    @Override
    public void handleRequest(String message) {
        System.out.println("GeneralSupportHandler: Processing request. " + message);
 
    }
}

class RequestorClient {
    public static AbstractSupportHandler getHandlerChain(){
        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler( AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(  AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);
 
        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);
 
        return technicalSupportHandler;
    }
 
}