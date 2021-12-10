package Lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Patient> patients = new ArrayList<>(); // List des patients
    static List<Patient> patientsEnregistre = new ArrayList<>(); // List des patients enregistrés
    static int time = -1; // Temps courant
    static boolean medecinLibre = true; // Indique si le medecin est libre
    static Patient patientChezMedecin = null; // Patient qui est chez le medecin (en consultation)

    public static void main(String[] args) throws InterruptedException {
        // Création des patients
        Patient p1 = new Patient("P1", 3, 10);
        Patient p2 = new Patient("P2", 0, 6);
        Patient p3 = new Patient("P3", 2, 8);
        Patient p4 = new Patient("P4", 4, 9);
        Patient p5 = new Patient("P5", 6, 4);
        // Ajout des patients dans la liste
        patients = Arrays.asList(p1, p2, p3, p4, p5);

        File queue = new File();// File des patients
        do {
            // Conditions de fin de simulation
            if ((patientsEnregistre.size() == patients.size()) && medecinLibre && queue.isEmpty()) {
                System.out.println("Fin de la simulation");
                break;
            }

            // Ajout des patients dans la file en fonction de leur temps d'arrivée
            for (Patient p : patients) {
                // Si le patient n'est pas encore enregistré et que son temps d'arrivée est égal au temps courant (le patient est arrivé)
                if (p.getArriver() == time && !patientsEnregistre.contains(p)) {
                    queue.ajouterPatient(p); // Ajout du patient dans la file
                    patientsEnregistre.add(p); // Ajout du patient dans la liste des patients enregistrés
                    System.out.println(time + ": " + p + " arrive au cabinet"); // Affichage du message d'arrivée du patient
                }
            }

            // Si le medecin est libre et qu'il y a un patient dans la file (il y a un patient à consulter)
            if (medecinLibre && !queue.isEmpty()) {
                // Récupération du patient à consulter (premier patient dans la file)
                patientChezMedecin = queue.retirePatient();
                // Affichage du message de départ du patient
                System.out.println(time + ": Medecin va traiter " + patientChezMedecin);
                medecinLibre = false; // Le medecin est occupé

                // Si le temps de consultation du patient est fini (le patient sort du cabinet)
            } else if (!medecinLibre && patientChezMedecin.getExamenDuree() == 0) {
                System.out.println(time + ": " + patientChezMedecin + " va sortir"); // Affichage du message de sortie du patient
                patientChezMedecin = null; // Le patient n'est plus en consultation
                medecinLibre = true; // Le medecin est libre
                continue; // On passe au patient suivant
            }
            // Si le patient est en consultation et que le temps de consultation n'est pas fini (le patient continue de consulter)
            if (!medecinLibre && patientChezMedecin.getExamenDuree() > 0) {
                patientChezMedecin.setExamenDuree(patientChezMedecin.getExamenDuree() - 1);
            }
            // Passage au temps suivant (1 seconde)
            passTime();
        } while (true); // On continue tant que la simulation n'est pas finie
    }

    // Passage au temps suivant (1 seconde)
    static void passTime() throws InterruptedException {
        Thread.sleep(1000);
        time++;
        System.out.println("Time: " + time);
    }
}
