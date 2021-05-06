import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Barre extends Treillis{


    public Barre(Point p1, Point p2, Type type) {
        this.p1 = p1;
        this.p2 = p2;
        this.type = type;
    }
    public Barre(Point p1, Point p2) {
        Type t = new Type();
        this.p1 = p1;
        this.p2 = p2;
        this.type = t;
    }

    private int id;

    public int getId(){
        return id;
    }

    private Point p1;

    private Point p2;
    
    private Type type;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }
    public Type getType(){
        return type;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    public void setType(Type type){
        this.type = type;
    }
    
     @Override
    public String toString() {
        return "[" + this.p1 + "," + this.p2 + ']';
    }
    
    public static Barre demandeSegment() {
        System.out.println("point début : ");
        Point deb = Point.demandePoint();
        System.out.println("point fin : ");
        Point fin = Point.demandePoint();
        return new Barre(deb, fin);
    }
    @Override
    public void dessine(GraphicsContext context) {
        context.setStroke(this.getType().getColor());
        context.strokeLine(this.p1.getPx(), this.p1.getPy(), this.p2.getPx(), this.p2.getPy());
    }
    @Override
    public void save(Writer w, Numeroteur<Treillis> num) throws IOException {
        if (!num.objExist(this)) {
            int id = num.creeID(this);
            this.p1.save(w, num);
            this.p2.save(w, num);
            w.append("Segment;" + id + ";" +
                    num.getID(this.p1) + ";" + num.getID(this.p2) +
                    ";" + this.getType().getColor()+"\n");
        }
    }
}