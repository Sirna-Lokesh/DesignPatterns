public class CommandExample {
    public static void main(String[] args) {
        IDevice tv=TVRemote.getTelevision();
        TurnTVOn oncmd=new TurnTVOn(tv);
        TurnTVOff offcmd=new TurnTVOff(tv);
        TurnVolumeUp upcmd=new TurnVolumeUp(tv);
        TurnVolumeDown downcmd=new TurnVolumeDown(tv);

        TVButton onbutton=new TVButton(oncmd);
        TVButton offbutton=new TVButton(offcmd);
        TVButton upbutton=new TVButton(upcmd);
        TVButton downbutton=new TVButton(downcmd);

        onbutton.press();
        offbutton.press();

        onbutton.press();
        upbutton.press();
        upbutton.press();
        downbutton.press();

        offbutton.press();

    }
}

interface IDevice{
    public void on();
    public void off();
    public void volumeUp();
    public void volumeDown();
}

class Television implements IDevice{
    private int volume=0;

    @Override
    public void on() {
        System.out.println("TV is on");     
    }
    @Override
    public void off() {
        System.out.println("TV is off");      
    }
    @Override
    public void volumeUp() {
        volume++;
        System.out.println("TV volume is at:"+ volume); 
    }
    @Override
    public void volumeDown() {
        volume--;
        System.out.println("TV volume is at:"+ volume); 
         
    }
    
}

interface Command{
    public void execute();
    public void undo();
}

class TurnTVOn implements Command{
    IDevice television;
    public TurnTVOn(IDevice television){
        this.television=television;
    }

    @Override
    public void execute() {
        this.television.on();
    }

    @Override
    public void undo() {
        this.television.off();
    }


}

class TurnTVOff implements Command{
    IDevice television;
    public TurnTVOff(IDevice television){
        this.television=television;
    }

    @Override
    public void execute() {
        this.television.off();
    }

    @Override
    public void undo() {
       this.television.on(); 
    }

}

class TurnVolumeUp implements Command{
    IDevice television;
    public TurnVolumeUp(IDevice television){
        this.television=television;
    }

    @Override
    public void execute() {
        this.television.volumeUp();
    }

    @Override
    public void undo() {
       this.television.volumeDown(); 
    }

}

class TurnVolumeDown implements Command{
    IDevice television;
    public TurnVolumeDown(IDevice television){
        this.television=television;
    }

    @Override
    public void execute() {
        this.television.volumeDown();
    }

    @Override
    public void undo() {
       this.television.volumeUp(); 
    }

}

class TVButton{
    Command command;
    public TVButton(Command command){
        this.command=command;
    }

    public void press(){
        this.command.execute();
    }

    public void pressUndo(){
        this.command.undo();
    }
}

class TVRemote{
    public static IDevice getTelevision(){
        return new Television();
    }
}

