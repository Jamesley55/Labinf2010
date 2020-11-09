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
    }

    // O(n)
    public Heap(Collection<ValueType> data) {
        this(true, data);
    }

    // O(n): construction avec donnees initiales, allez voir le lien dans la description pour vous aider
    public Heap(boolean isMin, Collection<ValueType> data) {
        // TODO
    }

    // O(1): on retourne le nombre d'elements dans la liste
    public int size() {
        // TODO
        return 0;
    }

    // O(1): on compare deux elements en fonction du type de monceau
    private boolean compare(ValueType first, ValueType second) {
        // TODO
        return false;
    }

    // O(1): on donne l'indice du parent
    private int parentIdx(int idx) {
        // TODO
        return -1;
    }

    // O(1): on donne l'indice de l'enfant de gauche
    private int leftChildIdx(int idx) {
        // TODO
        return -1;
    }

    // O(1): on donne l'indice de l'enfant de droite
    private int rightChildIdx(int idx) {
        // TODO
        return -1;
    }

    // O(1): on echange deux elements dans le tableau
    private void swap(int firstIdx, int secondIdx) {
        // TODO
    }

    // O(log(n)): l'index courant represente le parent, on s'assure que le parent soit le min/max avec ses enfants
    // De facon visuelle, ceci ammene un noeud le plus haut possible dans l'arbre
    // Par exemple: si le min/max est une feuille, on appelera resursivement log(n) fois la methode pour monter le noeud
    private void heapify(int idx) {
        // TODO
    }

    // O(log(n)): on ajoute un element et on preserve les proprietes du monceau
    public void insert(ValueType element) {
        // TODO
    }

    // O(n): on s'assure que tous les elements sont bien places dans le tableau,
    // allez voir le lien dans la description pour vous aider
    public void build() {
        // TODO
    }

    // O(log(n)): on retire le min ou le max et on preserve les proprietes du monceau
    public ValueType pop() {
        // TODO
        return null;
    }

    // O(1): on retourne sans retirer le plus petit ou plus grand element.
    public ValueType peek() {
        // TODO
        return null;
    }

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
