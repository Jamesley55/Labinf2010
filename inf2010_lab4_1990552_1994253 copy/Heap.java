package tp4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Heap<ValueType extends Comparable<? super ValueType>> implements Iterable<ValueType> {
    private ArrayList<ValueType> data;
    private  boolean isMin;

    // O(1)
    public Heap() {
        this(true);
    }

    // O(1): construction sans donnees initiales
    public Heap(boolean isMin) {
        // TODO
        this.isMin = isMin;
        data = new ArrayList<ValueType>();
        data.add(null);

    }

    // O(n)
    public Heap(Collection<ValueType> data) {
        this(true, data);
    }

    // O(n): construction avec donnees initiales, allez voir le lien dans la description pour vous aider
    public Heap(boolean isMin, Collection<ValueType> data) {
        // TODO
        this.isMin = isMin;
        this.data = new ArrayList<ValueType>();
        this.data.add(null);
        this.data.addAll(data);
        build();
    }

    // O(1): on retourne le nombre d'elements dans la liste
    public int size() {
        // TODO
        return data.size() -1;
    }

    // O(1): on compare deux elements en fonction du type de monceau
    private boolean compare(ValueType first, ValueType second) {
        // TODO
        return isMin ? first.compareTo(second) > 0 : second.compareTo(first) > 0;

    }

    // O(1): on donne l'indice du parent
    private int parentIdx(int idx) {
        // TODO
        return idx/2;
    }

    // O(1): on donne l'indice de l'enfant de gauche
    private int leftChildIdx(int idx) {
        // TODO
        return idx * 2;
    }

    // O(1): on donne l'indice de l'enfant de droite
    private int rightChildIdx(int idx) {
        // TODO
        return idx * 2 + 1;
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
        int swapIdx = 0;
        if (idx <= size() / 2 && idx > 0) {
            if (rightChildIdx(idx) > size()) {
                swapIdx = leftChildIdx(idx);
            }
            else {
                //comparer gauche et droite
                if ( compare(data.get(leftChildIdx(idx)), data.get(rightChildIdx(idx)))) {
                    swapIdx = rightChildIdx(idx);
                }
                else{
                    swapIdx = leftChildIdx(idx);
                }
            }
            if(compare(data.get(idx), data.get(swapIdx)) ) {
                swap(idx, swapIdx);
                heapify(parentIdx(idx));
            }
        }

    }

    // O(log(n)): on ajoute un element et on preserve les proprietes du monceau
    public void insert(ValueType element) {
        // TODO
        data.add(element);
        heapify(parentIdx(size()));
    }

    // O(n): on s'assure que tous les elements sont bien places dans le tableau,
    // allez voir le lien dans la description pour vous aider
    public void build() {
        // TODO
        for(int i = size()/2; i > 0; i--){
            percolateDown(i);
        }

    }

    // O(log(n)): on retire le min ou le max et on preserve les proprietes du monceau
    public ValueType pop() {
        // TODO
        ValueType deletedValue = data.get(1);
        data.set(1, data.get(size()));
        data.remove(size());
        if(size() > 0){
            percolateDown(1);
        }
        return deletedValue;


    }

    // O(1): on retourne sans retirer le plus petit ou plus grand element.
    public ValueType peek() {
        // TODO
        return data.get(1);
    }

    // O(nlog(n)): On applique l'algorithme Heap Sort, on s'attend a ce que le monceau soit vide a la fin.
    public List<ValueType> sort() {
        // TODO
        List<ValueType> list = new ArrayList<>();
        while (size() > 0){
            list.add(pop());
        }
        return list;

    }

    // Creation d'un iterateur seulement utilise dans les tests, permet de faire des boucles "for-each"
    @Override
    public Iterator<ValueType> iterator() {
        // TODO
        return data.listIterator(1);
    }

    private void percolateDown(int idx){
        int child;
        ValueType tmp = data.get(idx);
        for(; idx*2 <= size(); idx=child){
            child = idx*2;
            if((child != size()) && !compare(data.get(child + 1), data.get(child))){
                child++;
            }
            if(!compare(data.get(child), tmp)){
                data.set(idx, data.get(child));
            }
            else
                break;
        }
        data.set(idx, tmp);
    }

}
