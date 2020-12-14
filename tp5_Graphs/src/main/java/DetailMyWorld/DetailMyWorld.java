package DetailMyWorld;

import java.util.*;
import java.util.stream.Collectors;

public class DetailMyWorld {

    private static int indexContinent(Pixel pixel, List<Set<Integer>> Continents){
        int  indexOfContinent = -1;
        for (Set<Integer> listOfCountry : Continents) {
            indexOfContinent++;
            for (Integer adj : pixel.adjacentPixel) {
                if (listOfCountry.contains(adj)) {
                    return indexOfContinent;
                }
            }
        }
        return -1;
    }
    private static void addToContinent(Pixel pixel, List<Set<Integer>> Continents){
        // si ce pixel ne represente pas de l'eau
        if(!pixel.equals(0)) {
            if (Continents.size() < 0) {
                Continents.add(new HashSet<>());
                Continents.get(0).add(pixel.value);
            } else {
                int continentIndex =  indexContinent(pixel,Continents);
                if ( continentIndex == -1) {
                    Continents.add(new HashSet<>());
                    Continents.get(Continents.size() - 1).add(pixel.value);

                } else{
                    Continents.get(continentIndex).add(pixel.value);
                }
            }
        }
    }

    private static void breathFirstSearch(List<Pixel> graph, List<Set<Integer>> Continents){
        boolean visited[] = new boolean[graph.size()];
        Queue<Pixel> queue = new LinkedList<>();
        Pixel currentPixel;

        visited[0] = true;
        queue.add(graph.get(0));
        while (queue.size() > 0){
            currentPixel  = queue.poll();
            addToContinent(currentPixel, Continents);
            for(Integer i: currentPixel.adjacentPixel){
                int index = graph.indexOf(new Pixel(i));
                if(!visited[index]){
                    visited[index] = true;
                    queue.add(graph.get(index));
                }
            }
        }

    }
    private static void depthFirstSearch(Pixel start, List<Set<Integer>> Continents, boolean[] visited, List<Pixel> graph){
        visited[graph.indexOf(start)] = true;
        addToContinent(start, Continents);
        for( Integer i :start.adjacentPixel){
            int index = graph.indexOf(new Pixel(i));
            if(!visited[index]){
                depthFirstSearch(graph.get(index), Continents, visited, graph);
            }
        }
    }




    /** TODO
     * Returns a list of all continents with their respective countries within `world`
     * @param world 2D table of shape M x N representing the world
     *                  0 : Water Region
     *                  Positive non-null value : Country region for country of that specific value
     * @param isBreadthFirstSearch
     *              If true, algorithm used should be Breadth-First Search
     *              If false, algorithm used should be Depth-First Search
     * @return List of all continents with their respective countries
     *              Continents should be in order from left to right, top to bottom
     *              Each continent should have its countries in order
     */
    public static List<Set<Integer>> findContinents(ArrayList<ArrayList<Integer>> world, boolean isBreadthFirstSearch) {

        List<Pixel> pathways = new ArrayList<>();
        // create the map
        for(int i = 0; i < world.size(); i++ ){
            for (int j = 0; j < world.get(0).size(); j++){
                // try to find the index of the pixel inside the pathways
                int index = pathways.indexOf(new Pixel(world.get(i).get(j)));
                // if you dont find the pixel inside the pathways create  a new one
                if (index == -1) {
                    pathways.add(new Pixel(world.get(i).get(j)));
                    index = pathways.size() - 1;
                }
                Pixel currentPixel = pathways.get(index);
                currentPixel.addAdjacentPixel(world,i,j);
            }
        }

        List<Set<Integer>> Continents = new ArrayList<>();
        if(isBreadthFirstSearch){
            breathFirstSearch(pathways, Continents);
        }
        else {
            boolean visited[] = new boolean[pathways.size()];
            depthFirstSearch(pathways.get(0), Continents, visited, pathways);
        }

        return Continents;

    }

    public static void printWorld(ArrayList<ArrayList<Integer>> world) {
        for (ArrayList<Integer> row : world) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}


  class Pixel implements Comparable{
    Integer value;
    ArrayList<Integer> adjacentPixel;

    Pixel(Integer value){
        this.value = value;
        adjacentPixel = new ArrayList<>();
    }

    void addAdjacentPixel(ArrayList<ArrayList<Integer>> world, int i, int j){
        // left pixel
        if (i - 1 > 0)
            this.addAdjacent(world.get(i - 1).get(j));
        // right pixel
        if (i + 1 < world.size())
            this.addAdjacent(world.get(i + 1).get(j));
        // top pixel
        if (j + 1 < world.get(i).size())
            this.addAdjacent(world.get(i).get(j + 1));
        // bottom pixel
        if (j - 1 > 0)
            this.addAdjacent(world.get(i).get(j - 1));
    }

    void addAdjacent(Integer adj){
        if(!adjacentPixel.contains(adj) && !adj.equals(value)){
            adjacentPixel.add(adj);
        }
    }


    @Override
    public int compareTo(Object object){
        if(!(object instanceof Pixel) && !(object instanceof Integer))
            throw new IllegalArgumentException("this object is not  of type Pixel nor Integer");
        if(object instanceof Pixel){
            Pixel pixel = (Pixel) object;
            return this.value.compareTo(pixel.value);
        }
        else {
            Integer objectValue = (Integer) object;
            return this.value.compareTo(objectValue);
        }
    }

    @Override
    public boolean equals(Object object ) {
        if(!(object instanceof Pixel) && !(object instanceof Integer))
            throw new IllegalArgumentException("this object is not  of type Pixel nor Integer");

        if(object instanceof Pixel){
            Pixel pixel = (Pixel) object;
            return this.value.compareTo(pixel.value) == 0;
        }
        else {
            Integer objectValue = (Integer) object;
            return this.value.compareTo(objectValue) == 0;
        }
    }

}
