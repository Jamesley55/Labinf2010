package tp1;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    // TODO creer un point en 2d avec 2 donnees
    public Point2d(Double x, Double y) {
        super(new Double[]{x, y});
    }

    // TODO creer un point a partir d'un vecteur de donnees
    public Point2d(Double[] vector) {
        super(vector.clone());
    }

    public Double X() { return vector[X];}
    public Double Y() { return vector[Y];}

    // TODO appliquer la transalation sur la classe courrante et retourner la reference
    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(vector, translateVector);
        return new Point2d(vector);
    }

    // TODO appliquer la transalation sur la classe courrante et retourner la reference
    public Point2d translate(Point2d translateVector) {
        PointOperator.translate(vector, new Double[]{translateVector.X(), translateVector.Y()});
        return new Point2d(vector);
    }

    // TODO appliquer la rotation sur la classe courrante et retourner la reference
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(vector, rotationMatrix);
        return new Point2d(vector);
    }

    // TODO appliquer la rotation sur la classe courrante et retourner la reference
    public Point2d rotate(Double angle) {
        PointOperator.rotate(vector, new Double[][]{{Math.cos(angle), -Math.sin(angle)}, {Math.sin(angle), Math.cos(angle)}});

        return new Point2d(vector);
    }

    // TODO appliquer la division sur la classe courrante et retourner la reference
    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(vector, divider);
        return new Point2d(vector);
    }

    // TODO appliquer la multiplication sur la classe courrante et retourner la reference
    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(vector, multiplier);
        return new Point2d(vector);
    }

    // TODO appliquer la addition sur la classe courrante et retourner la reference
    @Override
    public Point2d add(Double adder) {
        PointOperator.add(vector, adder);
        return new Point2d(vector);
    }

    // TODO creer un nouveau point.
    @Override
    public Point2d clone() {
        return new Point2d(vector);
    }
}
