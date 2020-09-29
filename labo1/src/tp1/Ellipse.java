package tp1;

import java.util.Collection;

public class Ellipse extends BaseShape {
    // TODO creer une ellipse avec une largeur et une longueur.
    public Ellipse(Double widthRadius, Double heightRadius) {
        Double a = widthRadius;
         Double b = heightRadius;
        for(int i = 0; i < a; i++ ) {
            //
            this.add(new Point2d((-(a/2)+i), -Math.sqrt(((1-(Math.pow((-a/2+i),2)/(Math.pow(a/2, 2))))*Math.pow(b/2, 2)))));
        }
        for(int j = 0; j < a; j++ ) {
            this.add(new Point2d((-(a/2)+j), Math.sqrt(((1-(Math.pow((-a/2+j),2)/(Math.pow(a/2, 2))))*Math.pow(b/2, 2)))));
        }
        for(int k = 0; k < b; k++) {
            this.add(new Point2d((Math.sqrt(((1-(Math.pow((-b/2+k),2)/(Math.pow(b/2, 2))))*Math.pow(a/2, 2)))),-(b/2)+k));
        }
        for(int l = 0; l < b; l++) {
            this.add(new Point2d((-Math.sqrt(((1-(Math.pow((-b/2+l),2)/(Math.pow(b/2, 2))))*Math.pow(a/2, 2)))),-(heightRadius/2)+l));
        }

    }

    // TODO creer une ellipse avec les dimensions contenu dans un Point.
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
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
        return new Ellipse(getCoordsDeepCopy());
    }
}
