package Lab1.E3;
import Lab1.E2.ListD;

public class E3 {
    //on utilise la classe liste creer lors de l'exo 2
    ListD n1 = new ListD();
    ListD n2 = new ListD();

    public void fillUp() {
        //numero 1 (String car il nous permet d'avoir un nombre bcp plus grand)
        String a = "5118381298391239871289739127";
        //numero 2 (String car il nous permet d'avoir un nombre bcp plus grand)
        String b = "9";

        //initialisation de la 1ere liste qui represente le 1er nombre
        for (int i = 0; i < a.length(); i++) {
            n1.ajouterFin(a.charAt(i) + "");
        }
        //initialisation de la 2eme liste qui represente le 2eme nombre
        for (int i = 0; i < b.length(); i++) {
            n2.ajouterFin(b.charAt(i) + "");
        }
    }

    public void add() {
        ListD x, y;
        //on verifi la longeur de nos 2 nombres pour adapter notre algrithme
        if (n1.getSize() > n2.getSize()) {
            x = n1;
            y = n2;
        } else {
            x = n2;
            y = n1;
        }

        //on se place a la fin de la liste pour reveneir en arriere
        x.reculer();

        //liste resultat
        ListD res = new ListD();
        //la variable nous permettant de parcourir le nombre
        int ySize = y.getSize();
        for (int i = x.getSize() - 1; i >= 0; i--) {
            if (ySize > 0) {
                //on stock la valeur d'addition de derniers chars de non deux liste dans une var temporaire
                String tmp = (Integer.parseInt(x.retirer().getVal()) + Integer.parseInt(y.retirer().getVal())) + "";

                //si la taille de temp et >2 cela signifie q'uon a une valeur >9 qui demande des etape en plus afin de la rajouter dans le resultat
                if (tmp.length() > 1) {
                    //on met le char a droite (par exemple pour 12 on prend 2) dans le resultat
                    res.ajouterDeb(String.valueOf(tmp.charAt(1)));
                    //on recule dans la liste
                    x.reculer();
                    //on addition le char a gauche qui restait precedement (par exemple pour 12 on prend 1) dans le char actuel
                    x.getCurrent().setVal(Integer.parseInt(x.getCurrent().getVal()) + Integer.parseInt(String.valueOf(tmp.charAt(0))) + "");
                } else
                    //sinon on a une valeur <10 et on peut la placer directement dans le resultat
                    res.ajouterDeb(tmp);
                ySize--;
            } //si il nous reste plus d'element dans le 2eme liste (2em operand) on peut commencer a placer les char de la 1ere liste dans la liste de resultat
            else if (x.getCurrent().getVal().length() > 1 && null != x.getCurrent().getPrec()) {
                String tmp = x.getCurrent().getVal();
                //si l'element actuel et >10 on fait la meme manipulation comme deja fait precedement
                res.ajouterDeb(String.valueOf(tmp.charAt(1)));
                x.reculer();
                x.getCurrent().setVal((Integer.parseInt(x.getCurrent().getVal()) + Integer.parseInt(String.valueOf(tmp.charAt(0)))) + "");
            } else//si l'elemet en question <10 on le place directement dans le resultat
                res.ajouterDeb(x.retirer().getVal());
        }
        //on affiche la liste
        System.out.println(res);
    }

    public static void main(String[] args) {
        E3 e = new E3();
        //on in itialise les variables
        e.fillUp();
        //on appel la methode d'addition
        e.add();
    }


}
