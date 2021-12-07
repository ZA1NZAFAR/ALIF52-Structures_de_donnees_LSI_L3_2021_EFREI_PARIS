package E1;

public class List {
    //              1er    dernier
    private Element first, last;

    // ajouter un element au debut de la liste
    public void ajouterDebut(int val) {
        Element temp = new Element(val);
        //verification liste vide
        if (null == first) {
            first = temp;
            last = temp;
        } else {
            //addition d'element au debut
            temp = first;
            first = new Element(val);
            first.suiv = temp;
        }
    }

    //ajouter element a la fin de la liste
    public void ajouterFin(int val) {
        Element temp = new Element(val);
        //verification liste vide
        if (null == first) {
            first = temp;
        } else {
            last.suiv = temp;
        }
        last = last.suiv;
    }

    //recherce d'un element dans la liste
    public Element rechercher(int val) {
        //retourner null si liste vide
        if (null == first)
            return null;

        Element tmp = first;
        //parcourir la liste et envoyer l'element si trouve
        do {
            if (tmp.val == val)
                return tmp;
            else
                tmp = tmp.suiv;
        }
        while (tmp != null);
        //retouner null si rien trouve
        return null;
    }

    //supprimer le 1er element
    public void supprimerDebut() {
        if (null != first && null != first.suiv)
            first = first.suiv;
        else if (null != first) //onsupprime tout simplement le 1er element et 2em element devient le 1er
            first = null;
    }

    //suppression dernier element
    public void supprimerFin() {
        //verification liste vide
        if (null == first)
            return;
        Element temp = first;
        while (!temp.suiv.equals(last)) {
            temp = temp.suiv;
        }
        temp.suiv = null;
        last = temp;
    }

    //supprimer la valeur passer en argument
    public void supprimerVal(int val) {
        if (null == first) // si liste vide ne rien faire
            return;
        else if (first.val == val) //si 1er on le supprime directement
            supprimerDebut();
        else if (last.val == val)//si dernier on le supprime directement
            supprimerFin();
        Element temp = first;
        //on parcour et supprime si on le trouve
        do {
            if (temp.suiv.val == val) {
                temp.suiv = temp.suiv.suiv;
                break;
            }
            temp = temp.suiv;
        } while (null != temp.suiv && null != temp.suiv.suiv);
    }

    //afficher la liste
    public void afficher() {
        if (null == first)
            return;
        do {
            System.out.println("Val : " + first.val + " Suivant: " + first.suiv.val);
            first = first.suiv;
        } while (null != first.suiv);
    }


}
