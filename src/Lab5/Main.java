import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    static List<Patient> patients = new ArrayList<>();
    static List<Patient> patientsTraites = new ArrayList<>();
    static int time = -1;
    static boolean medecinLibre = true;
    static Patient patientChezMedecin = null;

    public static void main(String[] args) throws InterruptedException {
        Patient p1 = new Patient("P1", 3, 5);
        Patient p2 = new Patient("P2", 2, 6);
        Patient p3 = new Patient("P3", 1, 3);
        Patient p4 = new Patient("P4", 4, 9);
        Patient p5 = new Patient("P5", 5, 2);
        //....
        patients = Arrays.asList(p1, p2, p3, p4, p5);

        File queue = new File();
        do {
            if ((patientsTraites.size() == patients.size()) && medecinLibre && null == queue)
                break;
            //Arriver des patients
            for (Patient p : patients) {
                if (p.getArriver() == time) {
                    queue.ajouterPatient(p);
                    patientsTraites.add(p);
                }
            }

            //Passer chez le medecin si il est libre
            if (medecinLibre && !queue.isEmpty()) {
                patientChezMedecin = queue.retirePatient();
                System.out.println("Medecin va traiter " + patientChezMedecin);
            } else if (!medecinLibre && patientChezMedecin.getExamenDuree() == 0) {
                System.out.println("Patient sort " + patientChezMedecin);
                patientChezMedecin = null;
                medecinLibre = true;
            } else if (!medecinLibre && patientChezMedecin.getExamenDuree() > 0)
                patientChezMedecin.setExamenDuree(patientChezMedecin.getExamenDuree() - 1);
            passTime();
        } while (true);


    }

    static void passTime() throws InterruptedException {
        Thread.sleep(1000);
        time++;
        System.out.println(time);
    }
}
