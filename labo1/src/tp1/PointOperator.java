package tp1;

import java.util.*;

public final class PointOperator {

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void translate(Double[] vector, Double[] translateVector) {
        for (int i = 0; i < vector.length; i++) {
            if (i < translateVector.length) {
                vector[i] += translateVector[i];
            }
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] tempVector = new Double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            tempVector[i] = vector[i];
        }
        for (int i = 0; i < vector.length; i++) {
            double somme = 0;
            for (int j = 0; j < rotationMatrix[0].length; j++) {

                somme += tempVector[j] * rotationMatrix[i][j];
            }
            vector[i] = somme;
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void divide(Double[] vector, Double divider) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= divider;
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void multiply(Double[] vector, Double multiplier) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= multiplier;
        }
    }

    // TODO appliquer la translation sur le vecteur d'entree.
    public static void add(Double[] vector, Double adder) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] += adder;
        }
    }
}
