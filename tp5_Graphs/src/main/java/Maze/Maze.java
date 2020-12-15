package Maze;

import java.util.*;
import java.util.stream.Collectors;


public class Maze {
    /** TODO
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */
    public static ArrayList<ArrayList<Tile>> maze;

    public static Integer findShortestPath(ArrayList<ArrayList<Tile>> maze) {
        Maze.maze = maze;
        Pixel Entrance = null;
        Pixel Exit = null;

        // find entrance and exit
        for (int i = 0; i < maze.size();i++){
            for(int j = 0; j < maze.get(i).size(); j++){
                Tile tile = maze.get(i).get(j);
                if(Entrance == null && tile == Tile.Exit){
                    Entrance= new Pixel(j,i,tile);
                }
                if(Entrance != null && tile == Tile.Exit){
                    Exit = new Pixel(j,i, tile);
                }
            }
        }
        // si on a pas trouver d'entree ou de sortie on return null
        if(Entrance == null || Exit == null)
            return null;

        // on trouve les chemin possible a l'interieur du labyrinth
        ArrayList<Pixel> pathways = new ArrayList<>();
        Entrance.findPath(pathways);
        Entrance.distance = 0;

        // on utilise l'algorithm Dijkstra pour trouver les chemin possible
        ArrayList<Pixel> visitedPath = new ArrayList<>();
        while(!visitedPath.contains(Exit)){
            Pixel min = Collections.min(pathways);
            pathways.remove(min);
            visitedPath.add(min);

            for(Pixel adjacent : min.adjacentPixel){

                if(adjacent.distance > min.distance + 1){
                    adjacent.distance = min.distance + 1;
                }
            }
        }

        return visitedPath.get(visitedPath.indexOf(Exit)).distance;



    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }

}


 class Pixel implements Comparable{
    Tile tileType;
    int posX;
    int posY;
    int distance = Integer.MAX_VALUE;
    ArrayList<Pixel> adjacentPixel = new ArrayList<>();

    Pixel(int posX, int posY, Tile tileType){
        this.posX = posX;
        this.posY = posY;
        this.tileType = tileType;
    }

    // return false if the pixel is a wall or pathways already contain that path
    // and add the path in the list of pathways  and return true
    boolean findPath(ArrayList<Pixel> pathways){
        if(pathways.contains(this) || tileType == Tile.Wall){
            return false;
        }
        pathways.add(this);

        // find the left pixel
        findAdjacent(posX-1,posY,pathways);
        // find the right pixel
        findAdjacent(posX+1,posY,pathways);
        // find the bottom pixel
        findAdjacent(posX,posY-1,pathways);
        // find  the top pixel
        findAdjacent(posX,posY+1,pathways);
        return true;
    }

    // trouve le voisin a la position demander
    void findAdjacent(int x, int y, ArrayList<Pixel> pathways){
        if(y >= 0 && x >= 0 &&  x < Maze.maze.size() && y < Maze.maze.get(0).size()){

            Pixel adjacent = new Pixel(x, y, Maze.maze.get(y).get(x));
            if(pathways.contains(adjacent)){
                adjacent = pathways.get(pathways.indexOf(adjacent));
            }
            // recursive call in if statement to find all pathways
            // of  all possible  pathways of the maze
            if(adjacent.findPath(pathways) || adjacent.tileType != Tile.Wall){
                adjacentPixel.add(adjacent);
            }
        }
    }

    @Override
    public int compareTo(Object object) {
        if (!(object  instanceof Pixel)) {
            throw new IllegalArgumentException("This object is not of the type Pixel");
        }
        Pixel pixel = (Pixel) object;
        return this.distance - pixel.distance;
    }
    @Override
    public boolean equals(Object object){
        if (!(object instanceof Pixel)) {
            return false;
        }
        Pixel pixel = (Pixel) object;
        return this.posX == pixel.posX && this.posY == pixel.posY;
    }

}
