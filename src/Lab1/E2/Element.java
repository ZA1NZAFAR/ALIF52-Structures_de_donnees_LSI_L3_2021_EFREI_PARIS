package E2;
//La classe element contient maintenant l'element suivant ainsi que l'element precedent
public class Element {
    String val;
    Element suiv, prec;

    public Element(String val) {
        this.val = val;
        this.suiv = null;
        this.prec = null;
    }

    @Override
    public String toString() {
        return val + "";
    }


    //Les getters/setters
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Element getPrec() {
        return prec;
    }
}
