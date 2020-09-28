package tp1;

import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        Double a = widthRadius;
        Double b = heightRadius;
        for (int i = 0; i < widthRadius.intValue(); i++) {
            for (int j = 0; j < heightRadius.intValue(); j++) {
                add(new Point2d(Math.sqrt((1 - (Math.pow(i, 2)) / Math.pow(a, 2)) * Math.pow(b, 2)),
                        Math.sqrt((1 - (Math.pow(j, 2)) / Math.pow(b, 2)) * Math.pow(a, 2))));
            }
            //a--;
            //b--;

        }
        //for(int i = 0; i < widthRadius.intValue(); i++){
        //    for(int j = 0; j < heightRadius.intValue(); j++) {
        //        double formula = (Math.pow(i,2)/Math.pow(a,2)) +(Math.pow(j,2)/Math.pow(b,2));
        //        if(formula <= 1){
        //            add(new Point2d((double)i,(double)j));
        //        }
        //    }
        //}

    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
        //Double a  = dimensions.X();
        //Double b = dimensions.Y();
        //for(int i = 0; i < dimensions.X().intValue(); i++){
        //    for(int j = 0; j < dimensions.Y().intValue(); j++) {
        //        double formula = (Math.pow(i,2)/Math.pow(a,2)) +(Math.pow(j,2)/Math.pow(b,2));
        //        if(formula <= 1){
        //            add(new Point2d((double)i,(double)j));
        //        }
        //    }
        //}
    }

    // TODO initialiser le parent.
    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    // TODO appliquer la translation sur la forme.
    @Override
    public Ellipse translate(Point2d point) {
        super.translate(point);
        return this;
    }

    // TODO appliquer la rotation sur la forme.
    @Override
    public Ellipse rotate(Double angle) {
        super.rotate(angle);
        return this;
    }

    // TODO retourner une nouvelle forme.
    @Override
    public Ellipse clone() {
        return (Ellipse) super.clone();
        //return this;
        //new Ellipse(getCoordsDeepCopy());
    }
}
