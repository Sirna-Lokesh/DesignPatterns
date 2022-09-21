public class State {
    public static void main(String[] args) {
       ATMMachine machine=new ATMMachine();
       machine.insertCard();
       machine.insertPin(1234);
       machine.requestCash(2000);
    }
}

interface ATMState{
    public void insertCard();
    public void ejectCard();
    public void enterPin(int pin);
    public void requestCash(int cash);
}


class ATMMachine{
    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState outOfMoney;
    ATMState atmstate;

    public int cash=2000;
    public boolean correctPinEntered=false;


    public ATMMachine(){
        hasCard=new HasCard(this);
        noCard=new NoCard(this);
        hasCorrectPin=new HasCorrectPin(this);
        outOfMoney=new ATMOutofMoney(this);
        atmstate=noCard;

        if(cash<=0){
            atmstate=outOfMoney;
        }
    }

    public void setATMState(ATMState state){
        atmstate=state;
    }

    public void setCash(int cash){
        this.cash=cash;
    }

    public void insertCard(){
        atmstate.insertCard();
    }

    public void ejectCard(){
        atmstate.ejectCard();
    }

    public void requestCash(int cash){
        atmstate.requestCash(cash);
    }

    public void insertPin(int pin){
        atmstate.enterPin(pin);
    }

    public ATMState gethasCard() { return hasCard; }
    public ATMState getnoCard() { return noCard; }
    public ATMState gethasCorrectPin() { return hasCorrectPin; }
    public ATMState getoutOfMoney() { return outOfMoney; }

}

class HasCard implements ATMState {
	
	ATMMachine atmMachine;
	
	public HasCard(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("You can only insert one card at a time");
		
	}

	public void ejectCard() {
		
		System.out.println("Your card is ejected");
		atmMachine.setATMState(atmMachine.getnoCard());
		
	}

	public void requestCash(int cashToWithdraw) {
		
		System.out.println("You have not entered your PIN");
		
		
	}

	public void enterPin(int pinEntered) {
		
		if(pinEntered == 1234){
			
			System.out.println("You entered the correct PIN");
			atmMachine.correctPinEntered = true;
			atmMachine.setATMState(atmMachine.gethasCorrectPin());
			
		} else {
			
			System.out.println("You entered the wrong PIN");
			atmMachine.correctPinEntered = false;
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getnoCard());
			
		}	
	}	
}

class NoCard implements ATMState {
	
	ATMMachine atmMachine;
	
	public NoCard(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("Please enter your pin");
		atmMachine.setATMState(atmMachine.gethasCard());
		
	}

	public void ejectCard() {
		
		System.out.println("You didn't enter a card");
		
	}

	public void requestCash(int cashToWithdraw) {
		
		System.out.println("You have not entered your card");
		
	}

	public void enterPin(int pinEntered) {
		
		System.out.println("You have not entered your card");
		
	}
}

class HasCorrectPin implements ATMState {
	
	ATMMachine atmMachine;
	
	public HasCorrectPin(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("You already entered a card");
		
	}

	public void ejectCard() {
		
		System.out.println("Your card is ejected");
		atmMachine.setATMState(atmMachine.getnoCard());
		
	}

	public void requestCash(int cashToWithdraw) {
		
		if(cashToWithdraw > atmMachine.cash){
			
			System.out.println("You don't have that much cash available");
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getnoCard());
			
		} else {
			
			System.out.println(cashToWithdraw + " is provided by the machine");
			atmMachine.setCash(atmMachine.cash - cashToWithdraw);
			
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getnoCard());
			
			if(atmMachine.cash <= 0){ 
				
				atmMachine.setATMState(atmMachine.getoutOfMoney());
				
			}
		} 
	}

	public void enterPin(int pinEntered) {
		
		System.out.println("You already entered a PIN");
		
	}	
}


class ATMOutofMoney implements ATMState {
	
	ATMMachine atmMachine;
	
	public ATMOutofMoney(ATMMachine newATMMachine){
		
		atmMachine = newATMMachine;
		
	}

	public void insertCard() {
		
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
		
	}

	public void ejectCard() {
		
		System.out.println("We don't have any money");
		System.out.println("There is no card to eject");
		
	}

	public void requestCash(int cashToWithdraw) {
		
		System.out.println("We don't have any money");
		
	}

	public void enterPin(int pinEntered) {
		
		System.out.println("We don't have any money");
		
	}	
}
