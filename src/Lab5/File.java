package Lab5;

public class File {
    // Patient
    private Patient patient;

    // methode pour ajouter un patient dans la file d'attente de la clinique (en tete)
    public void ajouterPatient(Patient newPatient) {
        if (patient == null) // si la file est vide
            patient = newPatient; // on ajoute le patient en tete
        else {
            goToLast(); // on se place a la fin de la file

            newPatient.setPredecesseur(patient); // on met le predecesseur du nouveau patient egale a la fin de la file d'attente (le dernier patient)
            newPatient.setSuccesseur(null); // on met le successeur du patient a null

            patient.setSuccesseur(newPatient);  // on ajoute le nouveau patient a la fin
        }
    }

    // methode pour retirer un patient de la file d'attente de la clinique (en tete)
    public Patient retirePatient() {
        goToFirst(); // on se place au debut de la file
        if (patient == null) // si la file est vide
            return null; // on retourne null

        Patient tmp = patient; // on stocke le patient en tete dans une variable temporaire
        if (null != patient.getSuccesseur()) { // si le patient en tete a un successeur
            patient = patient.getSuccesseur(); // on decale le patient en tete
            patient.setPredecesseur(null); // on met le predecesseur du patient en tete a null
        } else // si le patient en tete n'a pas de successeur
            patient = null; // on met la file d'attente a vide

        tmp.setPredecesseur(null); // on met le predecesseur du patient en tete a null
        tmp.setSuccesseur(null); // on met le successeur du patient en tete a null
        return tmp; // on retourne le patient en tete de la file d'attente de la clinique (patient en tete)
    }

    // methode pour se placer au debut de la file d'attente de la clinique (en tete)
    private void goToFirst() {
        if (patient == null) // si la file est vide
            return; // on retourne
        while (null != patient.getPredecesseur()) { // tant que le patient en tete a un predecesseur
            patient = patient.getPredecesseur(); // on se place au predecesseur du patient
        }
    }

    // methode pour se placer a la fin de la file d'attente de la clinique
    private void goToLast() {
        if (patient == null) // si la file est vide
            return; // on retourne
        while (null != patient.getSuccesseur()) { // tant que le patient en tete a un successeur
            patient = patient.getSuccesseur(); // on se place au successeur du patient
        }
    }

    @Override
    public String toString() { // methode pour afficher la file d'attente de la clinique
        goToFirst(); // on se place au debut de la file
        if (patient == null)
            return null;
        String res = patient + " -> "; // on affiche le patient en tete de la file d'attente de la clinique
        while (null != patient.getSuccesseur()) { // tant que le patient en tete a un successeur
            res += patient.getSuccesseur().toString() + " -> "; // on affiche le successeur du patient en tete de la file d'attente de la clinique
            patient = patient.getSuccesseur(); // on se place au successeur du patient en tete de la file d'attente de la clinique
        }
        res += "null"; // on rajoute null a la fin de la file d'attente de la clinique pour indiquer qu'il n'y a plus de patient dans la file d'attente
        goToFirst(); // on se place au debut de la file
        return res; // on retourne la chaine de caractere contenant la file d'attente de la clinique
    }

    public boolean isEmpty() { // methode pour savoir si la file d'attente de la clinique est vide
        return this.patient == null; // on retourne true si la file d'attente de la clinique est vide, false sinon
    }
}
