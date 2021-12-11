package Lab6;

import sun.misc.Queue; // import de la classe Queue de la bibliothèque Java utilisée pour la file d'attente des noeuds

// la class Noeud
public class Noeud {
    private int data; // la valeur de l'element
    private Noeud left; // le noeud gauche
    private Noeud right; // le noeud droit

    // constructor
    public Noeud(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    // permet d'ajouter un noeud dans l'arbre avec la valeur val
    public void add(int val) {
        if (val < data) { // si la valeur est plus petite que la racine
            if (left == null) { // si le noeud gauche est null
                left = new Noeud(val); // on cree un nouveau noeud avec la valeur val
            } else { // sinon
                left.add(val); // on ajoute le noeud a gauche avec la valeur val (recursif)
            }
        } else if (val > data) { // si la valeur est plus grande que la racine
            if (right == null) { // si le noeud droit est null
                right = new Noeud(val); // on cree un nouveau noeud avec la valeur val
            } else { // sinon
                right.add(val); // on ajoute le noeud a droite avec la valeur val (recursif)
            }
        }
    }

    // inorder : gauche, racine, droite
    public void inorder() {
        if (left != null) { // si le noeud gauche n'est pas null
            left.inorder(); // on appelle la methode inorder sur le noeud gauche
        }
        System.out.print(data + " "); // on affiche la valeur de la racine
        if (right != null) { // si le noeud droit n'est pas null
            right.inorder(); // on appelle la methode inorder sur le noeud droit
        }
    }

    //preorder : racine, gauche, droite
    public void preorder() {
        System.out.print(data + " "); // on affiche la valeur de la racine
        if (left != null) { // si le noeud gauche n'est pas null
            left.preorder(); // on appelle la methode preorder sur le noeud gauche
        }
        if (right != null) { // si le noeud droit n'est pas null
            right.preorder(); // on appelle la methode preorder sur le noeud droit
        }
    }

    //postorder : gauche, droite, racine
    public void postorder() {
        if (left != null) { // si le noeud gauche n'est pas null
            left.postorder(); // on appelle la methode postorder sur le noeud gauche
        }
        if (right != null) { // si le noeud droit n'est pas null
            right.postorder(); // on appelle la methode postorder sur le noeud droit
        }
        System.out.print(data + " "); // on affiche la valeur de la racine
    }

    // breadth first : file des noeuds en ordre croissant de leur distance de la racine
    public void breadthFirst() throws InterruptedException {
        Queue queue = new Queue(); // on cree une file vide
        queue.enqueue(this); // on ajoute la racine a la file
        while (!queue.isEmpty()) { // tant que la file n'est pas vide  (on continue tant que la file n'est pas vide)
            Noeud temp = (Noeud) queue.dequeue(); // on recupere le premier element de la file
            System.out.print(temp.data + " "); // on affiche la valeur de l'element
            if (temp.left != null) { // si le noeud gauche n'est pas null
                queue.enqueue(temp.left); // on ajoute le noeud gauche a la file
            }
            if (temp.right != null) { // si le noeud droit n'est pas null
                queue.enqueue(temp.right); // on ajoute le noeud droit a la file
            }
        }
    }

    // retourne le maximum de l'arbre
    public int max() {
        if (right == null) { // si le noeud droit est null
            return data; // on retourne la valeur de la racine car c'est le maximum de l'arbre (tout a droite de la racine est forcement plus grand)
        } else { // sinon
            return right.max(); // on appelle la methode max sur le noeud droit
        }
    }

    // retourne le minimum de l'arbre
    public int min() {
        if (left == null) { // si le noeud gauche est null
            return data; // on retourne la valeur de la racine car c'est le minimum de l'arbre (tout a gauche de la racine est forcement plus petit)
        } else { // sinon
            return left.min(); // on appelle la methode min sur le noeud gauche
        }
    }

    // retourne la hauteur de l'arbre (le plus grand chemin entre la racine et un noeud)
    public int height() {
        if (left == null && right == null) { // si le noeud gauche et le noeud droit sont null
            return 0; // on retourne 0 car c'est la racine qui est a la hauteur 0
        } else if (left == null) { // sinon si le noeud gauche est null
            return 1 + right.height(); // on retourne 1 + la hauteur du noeud droit car c'est le noeud droit qui est a la hauteur 1
        } else if (right == null) { // sinon si le noeud droit est null
            return 1 + left.height(); // on retourne 1 + la hauteur du noeud gauche car c'est le noeud gauche qui est a la hauteur 1
        } else { // sinon
            return 1 + Math.max(left.height(), right.height()); // on retourne 1 + la hauteur du noeud gauche ou du noeud droit le plus haut
        }
    }

    // retourne le nombre de noeuds de l'arbre
    public int size() {
        int count = 1; // on initialise le compteur a 1
        if (left != null) { // si le noeud gauche n'est pas null
            count += left.size(); // on ajoute le nombre de noeuds du noeud gauche a la valeur du compteur
        }
        if (right != null) { // si le noeud droit n'est pas null
            count += right.size(); // on ajoute le nombre de noeuds du noeud droit a la valeur du compteur
        }
        return count; // on retourne le nombre de noeuds de l'arbre
    }

    // recherche d'un noeud dans l'arbre avec la valeur val et retourne le noeud si trouve sinon null
    public Noeud search(int val) {
        if (val == data) { // si la valeur recherchee est egale a la valeur de la racine
            return this; // on retourne le noeud courant
        } else if (val < data) { // sinon si la valeur recherchee est plus petite que la valeur de la racine
            if (left == null) { // si le noeud gauche est null
                return null; // on retourne null car la valeur recherchee n'est pas dans l'arbre
            } else { // sinon
                return left.search(val); // on appelle la methode search sur le noeud gauche
            }
        } else { // sinon si la valeur recherchee est plus grande que la valeur de la racine
            if (right == null) { // si le noeud droit est null
                return null; // on retourne null car la valeur recherchee n'est pas dans l'arbre
            } else { // sinon
                return right.search(val); // on appelle la methode search sur le noeud droit
            }
        }
    }

    // supprime un noeud de l'arbre avec la valeur val et retourne le noeud supprime sinon null
    public Noeud remove(int val) {
        if (val < data) { // si la valeur recherchee est plus petite que la valeur de la racine
            if (left == null) { // si le noeud gauche est null
                return this; // on retourne le noeud courant car la valeur recherchee n'est pas dans l'arbre
            } else { // sinon
                left = left.remove(val); // on appelle la methode remove sur le noeud gauche
            }
        } else if (val > data) { // sinon si la valeur recherchee est plus grande que la valeur de la racine
            if (right == null) { // si le noeud droit est null
                return this; // on retourne le noeud courant car la valeur recherchee n'est pas dans l'arbre
            } else { // sinon
                right = right.remove(val); // on appelle la methode remove sur le noeud droit
            }
        } else { // sinon si la valeur recherchee est egale a la valeur de la racine
            if (left == null && right == null) {
                return null; // on retourne null car la valeur recherchee n'est pas dans l'arbre
            } else if (left == null) { // sinon si le noeud gauche est null
                return right; // on retourne le noeud droit
            } else if (right == null) { // sinon si le noeud droit est null
                return left; // on retourne le noeud gauche
            } else { // sinon
                data = right.min(); // on met la valeur de la racine a la valeur du noeud droit le plus petit
                right = right.remove(data); // on appelle la methode remove sur le noeud droit
            }
        }
        return this; // on retourne le noeud courant pour pouvoir faire un appel recursive
    }

    // getter
    public int getData() {
        return data;
    }

    // affichage de l'arbre
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + (null != left ? left.getData() : "null") + // si le noeud gauche n'est pas null on affiche la valeur du noeud gauche sinon on affiche null
                ", right=" + (null != right ? right.getData() : "null") + // si le noeud droit n'est pas null on affiche la valeur du noeud droit sinon on affiche null
                '}';
    }
}
