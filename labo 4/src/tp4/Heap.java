package tp4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Heap<ValueType extends Comparable<? super ValueType>> implements Iterable<ValueType> {
    private ArrayList<ValueType> data;
    private boolean isMin;

    // O(1)
    public Heap() {
        this(true);
    }

    // O(1): construction sans donnees initiales
    public Heap(boolean isMin) {
        // TODO
        this.isMin = isMin;
        data = new ArrayList<ValueType>();
    }

    // O(n)
    public Heap(Collection<ValueType> data) {
        this(true, data);
    }

    // O(n): construction avec donnees initiales, allez voir le lien dans la description pour vous aider
    public Heap(boolean isMin, Collection<ValueType> data) {
        // TODO
        this.isMin = isMin;
        ArrayList<ValueType> tempData = new ArrayList<ValueType>(data.size());
        int idx =0;
        for(ValueType i: data){
            tempData.add(i);
            idx++;
        }
        data = tempData;
        build();

    }

    // O(1): on retourne le nombre d'elements dans la liste
    public int size() {
        // TODO
        return data.size();
    }

    // O(1): on compare deux elements en fonction du type de monceau
    private boolean compare(ValueType first, ValueType second) {
        // TODO
        return first.compareTo(second) > 0 ? true: false;
    }

    // O(1): on donne l'indice du parent
    private int parentIdx(int idx) {
        // TODO
        if (idx == 0)
            return 0;

        return (idx - 1) / 2;
    }

    // O(1): on donne l'indice de l'enfant de gauche
    private int leftChildIdx(int idx) {
        // TODO
        return (2 * idx + 1);
    }

    // O(1): on donne l'indice de l'enfant de droite
    private int rightChildIdx(int idx) {
        // TODO
        return (2 * idx + 2);
    }

    // O(1): on echange deux elements dans le tableau
    private void swap(int firstIdx, int secondIdx) {
        // TODO
        ValueType tmp = data.get(firstIdx);
        data.set(firstIdx, data.get(secondIdx));
        data.set(secondIdx, tmp);

    }

    // O(log(n)): l'index courant represente le parent, on s'assure que le parent soit le min/max avec ses enfants
    // De facon visuelle, ceci ammene un noeud le plus haut possible dans l'arbre
    // Par exemple: si le min/max est une feuille, on appelera resursivement log(n) fois la methode pour monter le noeud
    private void heapify(int idx) {
        // TODO
        int size = data.size();
        int largest = idx;
        int l = 2 * idx + 1;
        int r = 2 * idx + 2;
        if (l < size && data.get(l).compareTo(data.get(largest)) >1 )
            largest = l;
        if (r < size && data.get(r).compareTo(data.get(largest)) > 1)
            largest = r;

        if (largest != idx) {
            ValueType temp = data.get(largest);
            data.set(largest, data.get(idx));
            data.set(idx, temp);

            heapify(largest);}
    }

    // O(log(n)): on ajoute un element et on preserve les proprietes du monceau
    public void insert(ValueType element) {
        // TODO
        int size = data.size();
        if (size == 0) {
            data.add(element);
        } else {
            data.add(element);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }

    }

    // O(n): on s'assure que tous les elements sont bien places dans le tableau,
    // allez voir le lien dans la description pour vous aider
    public void build() {
        // TODO
        int size = data.size();
        if(isMin == true){
            for(int i=size/2; i >0; i--){
            }
        }else{

            for(int i=size/2; i >0; i--){

            }
        }
    }

    // O(log(n)): on retire le min ou le max et on preserve les proprietes du monceau
    public ValueType pop() {
        // TODO
        return null;

    }

    // O(1): on retourne sans retirer le plus petit ou plus grand element.
    public ValueType peek() {
        // TODO
        if(data != null && data.size() != 0)
            return data.get(1);
        return null;    }

    // O(nlog(n)): On applique l'algorithme Heap Sort, on s'attend a ce que le monceau soit vide a la fin.
    public List<ValueType> sort() {
        // TODO
        return null;
    }

    // Creation d'un iterateur seulement utilise dans les tests, permet de faire des boucles "for-each"
    @Override
    public Iterator<ValueType> iterator() {
        // TODO
        return null;
    }
}
