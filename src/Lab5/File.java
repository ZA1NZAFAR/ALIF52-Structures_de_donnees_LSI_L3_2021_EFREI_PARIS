public class File {
    private Patient patient;

    public void ajouterPatient(Patient newPatient) {
        if (patient == null)
            patient = newPatient;
        else {
            goToLast();

            newPatient.setPredecesseur(patient);
            newPatient.setSuccesseur(null);

            patient.setSuccesseur(newPatient);
        }
    }

    public Patient retirePatient() {
        goToFirst();

        Patient tmp = patient;

        if (null!=patient.getSuccesseur()) {
            patient = patient.getSuccesseur();
            patient.setPredecesseur(null);
        }else
            patient = null;

        tmp.setPredecesseur(null);
        tmp.setSuccesseur(null);
        return tmp;
    }

    private void goToFirst() {
        if (patient==null)
            return;
        while (null != patient.getPredecesseur()) {
            patient = patient.getPredecesseur();
        }
    }

    private void goToLast() {
        if (patient==null)
            return;
        while (null != patient.getSuccesseur()) {
            patient = patient.getSuccesseur();
        }
    }

    @Override
    public String toString() {
        goToFirst();
        if (patient == null)
            return null;
        String res = patient + " -> ";
        while (null != patient.getSuccesseur()) {
            res += patient.getSuccesseur().toString() + " -> ";
            patient = patient.getSuccesseur();
        }
        res += "null";
        goToFirst();
        return res;
    }

    public boolean isEmpty(){
        return this==null;
    }
}
