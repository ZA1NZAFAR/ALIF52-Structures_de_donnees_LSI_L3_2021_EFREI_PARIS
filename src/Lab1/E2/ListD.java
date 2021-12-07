package E2;

import java.util.Objects;

public class ListD {
    Element first, last, current;
    int size = 0; //taille de la liste (pratique pour parcourir la liste)

    //constructeur qui permet d'initialiser l'indice de l'element courant egal a 1er element
    public ListD() {
        current = first;
    }

    public void ajouterFin(String val) {
        Element temp = new Element(val);
        if (null == first) { //si list vide on l'addition au debut de la liste (car debut = fin)
            first = temp;
            last = temp;
            first.prec = last;
            last.suiv = first;
        } else { //sinon on le met a la fin en modifiant le different valeurs
            temp.prec = last;
            last.suiv = temp;
            last = temp;
            last.suiv = first;
            first.prec = last;
        }
        if (Objects.isNull(current)) //si le 1er element n'est pas initialiser on le met egal a le 1er element
            current = first;
        size++;
    }

    public void ajouterDeb(String val) {
        Element temp = new Element(val);
        if (null == first) { //si list vide on l'addition au debut de la liste (car debut = fin)
            first = temp;
            last = temp;
            first.prec = last;
            last.suiv = first;
        } else { //sinon on le met a la fin en modifiant le different valeurs
            temp.suiv = first;
            first.prec = temp;
            first = temp;
            last.suiv = first;
            first.prec = last;
        }
        if (Objects.isNull(current)) //si le 1er element n'est pas initialiser on le met egal a le 1er element
            current = first;
        size++;
    }

    //on renvoi le dernier element de la liste et on definit l'avant dernier element comme le dernier element
    public Element retirer() {
        Element tmp = last;
        last.prec.suiv = first;
        last = last.prec;
        first.prec = last;
        return tmp;
    }

    //nous permet d'avancer a droite dans la liste
    public Element avancer() {
        current = current.suiv;
        return current;
    }
    //nous permet d'avancer a gauche dans la liste
    public Element reculer() {
        current = current.prec;
        return current;
    }
    //renvoi la taille de la liste
    public int getSize() {
        return size;
    }

    @Override
    public String toString() { //renvoi un string contenant tout les elements
        String res = "";
        for (int i = 0; i < this.size; i++) {
            res = this.retirer().val + res;
        }
        return res;
    }

    //Getters/setters
    public Element getFirst() {
        return first;
    }

    public Element getLast() {
        return last;
    }

    public Element getCurrent() {
        return current;
    }
}
