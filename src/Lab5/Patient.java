package Lab5;

// Class: Patient le noeud de la file d'attente de patients (FIFO)
public class Patient {
    private String nom; // nom du patient
    private int arriver; // heure d'arrivée
    private int examenDuree; // durée de l'examen
    private Patient predecesseur; // patient précédent
    private Patient successeur; // patient suivant

    // Constructeur de Patient
    public Patient(String nom, int arriver, int examenDuree) {
        this.nom = nom;
        this.arriver = arriver;
        this.examenDuree = examenDuree;
        this.predecesseur = null;
        this.successeur = null;
    }

    // Affichage d'un patient
    @Override
    public String toString() {
        return "Patient{" +
                "nom='" + nom + '\'' +
                '}';
    }

    // Getters et Setters
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

}
