public class Strategy {
    public static void main(String[] args) {
        Data data=new Data();
        RenderData obj=new RenderData(data);
        obj.render("pie chart", data);

    }
}


interface IRenderer{
    public void render(Data data);
}

class Data{
}

class BarGraphRenderer implements IRenderer{
    @Override
    public void render(Data data) {
        System.out.println("Rendering the bar graph with given data");
    }

}


class PieChartRenderer implements IRenderer{
    @Override
    public void render(Data data) {
        System.out.println("Rendering the pie chart with given data");
    }

}

class RenderData{
    public Data data;
    IRenderer renderer=null;
    public RenderData(Data data){
        this.data=data;
    }

    public void render(String type, Data data){
         if(type.equals("bar graph")){
             renderer=new BarGraphRenderer();
         }
         else if(type.equals("pie chart")){
             renderer=new PieChartRenderer();
         }
         renderer.render(data);
    }
}


