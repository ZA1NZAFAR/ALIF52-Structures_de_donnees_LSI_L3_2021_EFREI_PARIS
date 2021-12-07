import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab4 {
    //Ex1------
    static int multiply(int a, int b) {
        if (a == 0 || b == 0) //si a ou b = 0 alors on retourne 0 sans calculer
            return 0;
        else if (a == 1 || b == 1) { //si a ou b = 1 alors on multiplie et retourne le resultat
            return b * a;
        } else {
            return a + multiply(a, b - 1); // si a et b > 1 on fait un appel recursif pour continuer le calcul
        }
    }

    //Ex2-------
    static void displayNums(int depart, int fin) {
        if (depart > fin) // des qu'on depasse la valuer limite(30 dans notre cas) on retourne sans afficher
            return;
        System.out.println(depart); //on affiche la valeur de n a chaque passage
        displayNums(depart + 1,fin); // on fait un appel recursif pour continuer l'operation
    }


    //Ex3-------
    static void hanoi(int n, int[] fromPeg, int[] toPeg, int[] auxPeg) {
        //on a trois deplacements a efectuer
        //1. debut vers arriver
        //2. debut vers intermediare
        //3. intermediare vers arriver
        try {
            if (n == 0) { //quand n vaut 0 on peut deplacer de debut vers arriver
                toPeg[0] = fromPeg[0];
                fromPeg[0] = 0;
                return;
            }
            hanoi(n - 1, fromPeg, auxPeg, toPeg);//(appel recursif) debut vers intermediare
            toPeg[n] = fromPeg[n]; // debut vers arriver
            fromPeg[n] = 0;
            hanoi(n - 1, auxPeg, toPeg, fromPeg); //(appel recursif) intermediare vers arriver
        } catch (Exception ignored) {

        }
    }

    //  Ex4
    public static boolean check(String s, int pos) {
        if (pos == s.length()) // si on arrive jusqu'a la fin sans avoir une erreur cela indique que tout est bon donc on retourne vrai
            return true;
        //verification si on lit un facteur
        if (s.charAt(pos) == '(') // si le char actuel est une ( on peut esperer que on est en train de lire un facteur
            if (isLetter(s.charAt(pos + 1))) // on verifie si le char suivant est bien une lettre
                if (isSymbol(s.charAt(pos + 2))) // on verifie si le char n + 2 est bien un symbole
                    if (isLetter(s.charAt(pos + 3))) // on verifie si le char n + 3 est bien une lettre
                        if (s.charAt(pos + 4) == ')') // on verifie si le char n + 3 est bien une )
                            return check(s, pos + 5); // si toutes les conditions precedentes sont vrai on peut continuer la lecture a partir du char n + 5
                        else
                            return false; // des qu'on a une condition qui n'est pas vrai on peut retourner fausse sans verifier la suite
                    else return false;
                else return false;
            else return false;

        if (isLetter(s.charAt(pos))) //verification si il y a une erreur (une lettre suivie par une autre lettre ou '('
            if (s.charAt(pos + 1) == '(' || isLetter(s.charAt(pos + 1)))
                return false;

        if (isLetter(s.charAt(pos))) // verification d'un terme (on repete la meme syntaxe de verification comme utilise precedement
            if (isSymbol(s.charAt(pos + 1)))
                if (s.charAt(pos + 2) == '(')
                    return check(s, pos + 2);
                else if (isLetter(s.charAt(pos + 2)))
                    return check(s, pos + 3);
                else return false;
            else return false;

        if (isSymbol(s.charAt(pos))) // verif expression (on repete la meme syntaxe de verification comme utilise precedement
            if (isLetter(s.charAt(pos + 1)) && (pos + 2 <= s.length() || !isLetter(s.charAt(pos + 2))))
                return check(s, pos + 2);
            else return false;
        else
            return false;
    }

    public static boolean isLetter(char c) {// methode qui nous permet de verifier si le char passer en parametre est bien une lettre alphabetqie
        return Character.isLetter(c);
    }

    public static boolean isSymbol(char c) {// methode qui nous permet de verifier si le char passer en parametre est bien un symbole (operator arithmetique)
        return c == '*' || c == '+' || c == '-' || c == '/';
    }


    public static void main(String[] args) {
        //Test exo 1
        System.out.println(multiply(5, 90));

        // Test exo 2
        displayNums(1,20); // arg 1 = depart, arg2 = fin

        //Test exo 3
        int[] a = {1, 2, 3}; // tour 1
        int[] b = {0, 0, 0}; // tour 2
        int[] c = {0, 0, 0}; // tour 3
        System.out.println("Avant les deplacements: ");
        System.out.println("Depart : " + Arrays.toString(a));
        System.out.println("Intermediare : " + Arrays.toString(b));
        System.out.println("Arrive : " + Arrays.toString(c));
        hanoi(3, a, b, c); // on commence la simulation en lui indiquant la taille de tour initiale
        System.out.println("Apres les deplacements: ");
        System.out.println("Depart : " + Arrays.toString(a));
        System.out.println("Intermediare : " + Arrays.toString(b));
        System.out.println("Arrive : " + Arrays.toString(c));

        //Test exo 4
        // Plusieurs user cases
        String[] s = {"(a*a)*n+b", "a+v++", "(a+b)+c", "(a+b)", "a+(a+b)"};
        for (String ss : s) {
            System.out.println(ss + " : " + check(ss, 0));
        }
    }
}
