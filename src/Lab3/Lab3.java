import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Lab3 {


    public static void main(String[] args) {
        // Quelques expressions de test
        List<String> tests = Arrays.asList("A+B", "(A+B)/C", "(A/(B-C+D))*(E-A)*C", "AB", "+-");
        for (String test : tests) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Infix Expression" + test + " Is Valid = " + exo1ValidateInfix(test));
            String postFix = exo2InfixToPostfix(test);
            System.out.println(postFix);
            System.out.println("Postfix Expression " + postFix + " Is Valid = " + exo2CheckPostfix(postFix));
            System.out.println("-----------------------------------------------------------------");
        }

    }

    // Exo 1
    static boolean exo1ValidateInfix(String s) {
        // Solution utilisant des piles
        Stack<Character> pile = new Stack<>();
        for (char c : s.toCharArray()) {
            try {
                if (c == '(') // Si nous lisons une parenthèse gauche, nous l'ajoutons à la pile
                    pile.push(c);
                else if (c == ')') // Si nous lisons une parenthèse droite, nous supprimons une parenthèse gauche de la pile
                    pile.pop();
            } catch (EmptyStackException e) {
                return false; // Si la pile est vide et que nous lisons une parenthèse droite, nous violons la condition 2
            }
        }
        return pile.isEmpty(); // Si la pile est vide à la fin, cela signifie que nous avons un nombre égal de parenthèses gauche et droite donc tout s'est bien passé et toutes les conditions ont été respectées. S'il y a quelque chose dans la pile, cela signifie que nous avons un nombre inégal de parenthèses gauche et droite qui viole notre première condition.
    }

    //Exo 2
    static String exo2InfixToPostfix(String infix) {
        Stack<Character> operators = new Stack<>(); // Pile pour les opérateurs
        StringBuilder postfix = new StringBuilder();// expression postfix
        for (Character c : infix.toCharArray()) {
            if (Character.isLetter(c)) // si le caractère est une lettre nous l'ajoutons à l'expression suffixe
                postfix.append(c);
            else if (c == '(') {
                operators.push(c); // si c'est une parenthèse gauche, nous l'ajoutons à la pile des opérateurs (c'est le début d'une partie de haute priorité)
            } else if (c == ')') { // si c'est une parenthèse droite, c'est la fin d'une partie de haute priorité
                while (operators.peek() != '(') { // nous supprimons tous les opérateurs jusqu'à ce que nous atteignions la parenthèse gauche précédemment ajoutée (nous n'ajoutons pas de parenthèse à l'expression suffixe)
                    postfix.append(operators.pop());
                }
                operators.pop();//nous supprimons la parenthèse gauche précédemment ajoutée de la pile
            } else { //si la lettre lue est autre qu'une lettre, ( ou ) nous l'ajoutons en fonction de sa priorité
                while (!operators.isEmpty() && !(operators.peek() == '(') && priotity(c) > priotity(operators.peek())) {
                    postfix.append(operators.pop());
                }
                operators.push(c);// nous ajoutons le nouvel opérateur de lecture à la pile
            }
        }
        while (!operators.isEmpty()) //s'il nous reste des opérateurs à la fin, nous les ajoutons à l'expression suffixe
            postfix.append(operators.pop());
        return postfix.toString();
    }

    static boolean exo2CheckPostfix(String postfix) {
        Stack<Character> stack = new Stack<>();    // pile de suffixes
        for (Character ch : postfix.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // si le caractère lu est un opérateur, nous devrions avoir deux lettres dans la pile ensemble si l'expression est correcte
                try {
                    stack.pop(); //on enlève deux lettres
                    stack.pop();
                } catch (EmptyStackException e) {
                    return false; // s'il y a une exception, cela indique que l'expression est incorrecte
                }
                switch (ch) {// on remplace la partie lue de l'expression par X. Exemple AB* devient X
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        stack.push('X');
                        break;
                }
            } else {
                stack.push('X');//s'il s'agit d'une lettre, nous l'ajoutons simplement à la pile pour un traitement ultérieur
            }
        }
        return stack.size() == 1; // si à la fin nous n'avons qu'un seul X, cela signifie que toutes les parties de l'expression sont simplifiables et donnerons un résultat qui montre que l'expression était effectivement correcte
    }

    static int priotity(char x) { //donne la priorité à un opérateur (le plus bas est le mieux)
        if (x == '+' || x == '-')
            return 2;
        if (x == '*' || x == '/')
            return 1;
        return -1; //il ne devrait pas arriver
    }
}
