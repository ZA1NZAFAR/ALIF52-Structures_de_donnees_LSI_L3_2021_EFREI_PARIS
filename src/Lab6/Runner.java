package Lab6;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        // les valeurs des noeuds
        List<Integer> nodes = Arrays.asList(50, 45, 65, 55, 54, 56, 80, 70, 85, 30, 47);
        Noeud noeud = new Noeud(nodes.get(0)); // création du noeud racine avec la valeur du premier élément de la liste nodes (50)
        for (Integer i : nodes) { // pour chaque élément de la liste nodes
            noeud.add(i); // ajout de l'élément à la liste des fils du noeud racine
        }

        // affichage de chaque noeud en utilisant la méthode search de la classe Noeud (voir classe Noeud)
        System.out.println("--------------Displaying tree:");
        for (Integer i : nodes) { // pour chaque élément de la liste nodes
            System.out.println(noeud.search(i)); // affichage des noeud avec la valuer i de la liste nodes  (45, 65, 55, 54, 56, 80, 70, 85, 30, 47)
        }
        System.out.println("----------Fin-Displaying tree.");


        System.out.print("Inorder : "); // affichage inorder
        noeud.inorder();
        System.out.println("");
        System.out.print("Preorder : "); // affichage preorder
        noeud.preorder();
        System.out.println("");
        System.out.print("Postorder : "); // affichage postorder
        noeud.postorder();
        System.out.println("");
        System.out.print("Breadth first traversal : "); // affichage breadth first
        noeud.breadthFirst();
        System.out.println("");

        System.out.println("Max = " + noeud.max()); // affichage de la valeur max du noeud racine
        System.out.println("Min = " + noeud.min()); // affichage de la valeur min du noeud racine
        System.out.println(("Nb noeuds = " + noeud.size())); // affichage du nombre de noeud du noeud racine
        System.out.println("Hauteur tree = " + noeud.height()); // affichage de la hauteur du noeud racine (racine = 0 donc on aura 3)

        System.out.println("Search for 55 = " + noeud.search(55)); // affichage du noeud avec la valeur 55
        Noeud n = noeud.search(77); // création d'un noeud avec la valeur 77 a partir du noeud racine
        System.out.println("Search for 77 = " + n); // affichage du noeud avec la valeur 77 (null car il n'existe pas)

        noeud.remove(65); // suppression du noeud avec la valeur 65
        noeud.remove(47); // suppression du noeud avec la valeur 65

        // affichage post suppression
        System.out.println("--------------Displaying tree:");
        for (Integer i : nodes) // pour chaque élément de la liste nodes
            System.out.println(noeud.search(i)); // affichage des noeud avec la valuer i de la liste nodes  (45, 65, 55, 54, 56, 80, 70, 85, 30, 47)
        System.out.println("----------Fin-Displaying tree");
    }
}
