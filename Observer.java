import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        ISubscriber sravan=new Subscriber("Sravan");
        ISubscriber sai=new Subscriber("sai");

        IChannel channel1=new Channel("Music");
        IChannel channel2=new Channel("Comedy");
        IChannel channel3=new Channel("Movies");

        channel1.subscribe(sravan);
        channel2.subscribe(sravan);

        channel2.subscribe(sai);
        channel3.subscribe(sai);

        channel1.uplaod("new music video");
        


    }
}

interface ISubscriber{
    public void update(String title);
    public void subscribeChannel(IChannel ch);

}
class Subscriber implements ISubscriber{
    private String name;
    private List<IChannel> channels;

    public Subscriber(String name){
        this.name=name;
        System.out.println("Subscriber  "+this.name+"  created.");
        channels=new ArrayList<>();
    }

    @Override
    public void update(String title){
        System.out.println("hey, "+this.name +" Video uploaded"+"  "+title);
    }

    @Override
    public void subscribeChannel(IChannel ch) {
         channels.add(ch);
    }


}

interface IChannel{
    public void subscribe(ISubscriber sub);
    public void unsubscribe(ISubscriber sub);
    public void uplaod(String title);
    public void notifySub(String title);

}
class Channel implements IChannel{
    private String name;
    private String title;
    private List<ISubscriber> subscribers;
    
    public Channel(String name){
        this.name=name;
        System.out.println("Channel  "+this.name+"  created.");
        subscribers=new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void unsubscribe(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void uplaod(String title) {
        this.title=title;
        notifySub(this.title);
    }

    @Override
    public void notifySub(String title) {
         for(ISubscriber sub: subscribers){
             sub.update(this.title);
         }
    }


}
