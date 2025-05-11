package tasks.homework6;

public class Hospital {
    //можно сделать как надо, распихав каждый класс в отдельный файл, но мне лень и так всё нагляднее видно

    Surgeon surgeon = new Surgeon();
    Physician physician = new Physician();
    Dentist dentist = new Dentist();

    public void runClinic() {
        Patient patient = new Patient((int) ( Math.random() * 3) + 1);
        physician.getReception(patient);
    }

    abstract static class Doctor {
        protected String name;
        public abstract void heal();

        @Override
        public String toString() {
            return this.name;
        }
    }

    static class Surgeon extends Doctor {

        {
            this.name = "хирург";
        }

        public void heal() {
            System.out.println("Хирург вырезает болезнь");
        }
    }

    class Physician extends Doctor {

        {
            this.name = "терапевт";
        }

        public void heal() {
            System.out.println("Терапевт проводит терапию");
        }

        public void getReception(Patient patient) {
            switch (patient.getPlan()) {
                case (1):
                    patient.setDoctor(surgeon);
                    surgeon.heal();
                    break;
                case (2):
                    patient.setDoctor(dentist);
                    dentist.heal();
                    break;
                default:
                    patient.setDoctor(physician);
                    physician.heal();
            }
        }
    }

    class Dentist extends Doctor {

        {
            this.name = "зубной";
        }

        public void heal() {
            System.out.println("Зубной сверлит зубы");
        }
    }

    class Patient {

        private Doctor doctor;
        private int plan;

        public Patient(int plan) {
            this.plan = plan;
        }

        public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
            System.out.printf("Пациенту c ID %1$d назначен %2$s\n", this.hashCode(), doctor);
        }

        public  int getPlan() {
            return plan;
        }

    }
}
