package tp4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;



public final class Interview {
    /**
     * @param circleSize le nombre d'amis que l'on doit inclure dans le cercle
     * @param centers    les indices des centres dans "points"
     * @param points     la liste des individus
     * @return les indices dans "points" qui creent l'intersection de deux cercles d'amis.
     * <p>
     * On veut que vous indiquiez la complexite sur chaque ligne en fonction de:
     * - circleSize -> O(a) a est pour le nombre d' "amis" communs
     * - centers -> O(c) c est pour le nombre de "centres"
     * - points -> O(n) n est simplement le nombre de d'individus dans la population
     * Vous n'avez pas besoin d'indiquer la complexite des lignes etant en O(1)
     * Lorsque vous avez des boucles, indiquez clairement la complexite de la boucle, par exemple:
     * for (Integer p1 : points) { // O(n) * O(n^2*log(n)) -> O(n^3*log(n))
     * for (Integer p2 : points) { // O(n) * O(n*log(n) -> O(n^2*log(n))
     * Collections.sort(points); // O(n*log(n)
     * }
     * }
     * Ceci est un exemple, on voit clairement que la boucle sur "p2" est en O(n) et puisque son interieur est
     * en O(n*log(n), la complexite totale sera la multiplication, O(n^2*log(n)).
     * <p>
     * O(n^2 * log(n)): ceci est la complexite en "worst case" ou 'a' et 'c' tendent vers 'n'
     * Il est peut etre possible d'avoir une meilleure complexite, soyez clair dans vos explications si vous croyez
     * avoir trouve :)
     */
    public static List<Integer> getFriendsToRemove(Integer circleSize, List<Integer> centers, List<Point> points) {
        // TODO

        int map[][] = new int [points.size()][points.size()];
        for(int center: centers){
            Point point = points.get(center);
            List<Integer> distanceToCenter = new ArrayList<>();
            for(Point pointAComparer: points) {
                distanceToCenter.add(point.compareTo(pointAComparer));
            }
            Collections.sort(distanceToCenter);
        }

        List<Integer> amiProblematique = new ArrayList<>();

        for(int j = 0; j < map[0].length; j++ ){ //o(n²)
            int sum = 0;
            for(int i = 0; i < map.length; i++){
                sum += map[i][j];
            }
            if(sum > 1){
                amiProblematique.add(j);
            }
        }


        return amiProblematique;
    }
}
