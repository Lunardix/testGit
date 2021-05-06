
import java.io.*;
import java.util.*;


public abstract class Treillis {

    private int id;

    public int getId() {
        return id;
    }


    public abstract void save(Writer w, Numeroteur<Treillis> num) throws IOException;

    public void sauvegarde(File fout) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
        }
    }

    public static Treillis lecture(File fin) throws IOException {
        Numeroteur<Treillis> num = new Numeroteur<Treillis>();
        Treillis derniere = null;
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                if (bouts[0].equals("Point")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Type type = FigureSimple.parseColor(bouts[4], bouts[5], bouts[6]);
                    Point np = new Point(px, py);
                    num.associe(id, np);
                    derniere = np;
                } else if (bouts[0].equals("Barre")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    Type type = Barre.parseType(bouts[4], bouts[5], bouts[6]);
                    Point p1 = (Point) num.getObj(idP1);
                    Point p2 = (Point) num.getObj(idP2);
                    Barre ns = new Barre(p1, p2, type);
                    num.associe(id, ns);
                    derniere = ns;
                } else if (bouts[0].equals("Noeud")) {
                    int id = Integer.parseInt(bouts[1]);
                    num.associe(id, ng);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Treillis fig = num.getObj(idSous);
                        ng.add(fig);
                    }
                    derniere = ng;
                }
            }

        }
        return derniere;
    }
}