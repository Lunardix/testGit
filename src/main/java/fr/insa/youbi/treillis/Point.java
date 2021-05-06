
import java.util.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.io.Writer;


public class Point extends Noeud {

    public static double RAYON_IN_DRAW = 5;
    
    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }
    public Point(){
        this.px = 0;
        this.py = 0;
    }

    private double px;

    public double getPx() {
        return px;
    }

    public void setPx(double px) {
        this.px = px;
    }

    private double py;

    public double getPy() {
        return py;
    }

    public void setPy(double py) {
        this.py = py;
    }

    public String toString() {
        return "(" + this.px + "," + this.py + ')';
    }
    public static Point creerPoint() {
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonnée : ");
        double py = Lire.d();
        return new Point(px, py);
    }

    @Override
    public double maxX() {
        return this.px;
    }

    @Override
    public double minX() {
        return this.px;
    }

    @Override
    public double maxY() {
        return this.py;
    }

    @Override
    public double minY() {
        return this.py;
    }

    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(color.BLACK);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    public static Point demandePoint() {
        System.out.println("abscisse : ");
        double px = Lire.d();
        System.out.println("ordonnée : ");
        double py = Lire.d();
        return new Point(px, py);
    }

    @Override
    public void save(Writer w, Numeroteur<Treillis> num) throws IOException {
        if(! num.objExist(this)) {
            int id = num.creeID(this);
            w.append("Point;"+id+";"+this.px+";"+this.py+
                    ";" + color.BLACK + "\n");
        }
    }
}