public class Patient {
    private String nom;
    private int arriver,examenDuree;
    private Patient predecesseur;
    private Patient successeur;

    public Patient(String nom, int arriver, int examenDuree) {
        this.nom = nom;
        this.arriver = arriver;
        this.examenDuree = examenDuree;
        this.predecesseur = null;
        this.successeur = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Patient getPredecesseur() {
        return predecesseur;
    }

    public void setPredecesseur(Patient predecesseur) {
        this.predecesseur = predecesseur;
    }

    public Patient getSuccesseur() {
        return successeur;
    }

    public void setSuccesseur(Patient successeur) {
        this.successeur = successeur;
    }

    public int getArriver() {
        return arriver;
    }

    public void setArriver(int arriver) {
        this.arriver = arriver;
    }

    public int getExamenDuree() {
        return examenDuree;
    }

    public void setExamenDuree(int examenDuree) {
        this.examenDuree = examenDuree;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
