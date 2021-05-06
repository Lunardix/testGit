
import java.util.*;
import javafx.scene.paint.Color;

public class Type {


    public Type(double cout,Color color,double Lmin,double Lmax,double Rtension,double Rcompression) {
        this.cout = cout;
        this.color = color;
        this.Lmin = Lmin;
        this.Lmax = Lmax;
        this.Rtension = Rtension;
        this.Rcompression = Rcompression;
    }
    public Type(){
        this.cout = 0;
        this.color = color.BLACK;
        this.Lmin = 0;
        this.Lmax = 1000;
        this.Rtension = 1000;
        this.Rcompression = 1000;
    }
    

    private int id;
    
    private Color color;

    private double cout;

    private double Lmin;

    private double Lmax;

    private double Rtension;

    private double Rcompression;

    public int getId(){
        return id;
    }
    
    public Color getColor(){
        return color;
    }

    public double getCout() {
        return cout;
    }

    public double getLmax() {
        return Lmax;
    }

    public double getLmin() {
        return Lmin;
    }

    public double getRcompression() {
        return Rcompression;
    }

    public double getRtension() {
        return Rtension;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setCout(double cout) {
        this.cout = cout;
    }

    public void setLmax(double lmax) {
        Lmax = lmax;
    }

    public void setLmin(double lmin) {
        Lmin = lmin;
    }

    public void setRcompression(double rcompression) {
        Rcompression = rcompression;
    }

    public void setRtension(double rtension) {
        Rtension = rtension;
    }
    
     @Override
    public String toString() {
        return "[" + this.color + "," + this.cout +"," + this.Lmax +"," + this.Lmin +"," + this.Rcompression +"," + this.Rtension + ']';
    }
}