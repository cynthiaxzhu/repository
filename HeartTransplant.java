/**
 * Receives as a parameter the number of available hearts for transplant 
 * and prints all the recipients in order of precedence.
 *
 * Introduction to Computer Science - Spring 2020
 *
 * @author Cynthia Zhu
 */

public class HeartTransplant {

    private Person[] listOfPatients;
    private SurvivabilityByAge[] survivabilityByAge;
    private SurvivabilityByCause[] survivabilityByCause;

    /**
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {

        listOfPatients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;

    }

    /**
     * Inserts the parameter Person p into the instance variable array
     * listOfPatients. Returns the integer 0 if it successfully inserts p
     * into the array and -1 if there is not enough space to insert p into
     * array.
     */
    public int addPerson(Person p, int arrayIndex) {

        if (arrayIndex > listOfPatients.length) {
            return -1;
        } else {
            listOfPatients[arrayIndex] = p;
            return 0;
        }

    }

    /**
     * Allocates the listOfPatients array with numberOfLines length, then 
     * reads numberOfLines persons from the data file (each line refers to
     * one Person). For each person read from the data file, instantiates 
     * a Person object and inserts the Person object into the 
     * listOfPatients array. The method returns the number of patients 
     * read from file. File format: ID, ethnicity, gender, age, cause, 
     * urgency, state of health.
     */
    public int readPersonsFromFile(int numberOfLines) {

        listOfPatients = new Person[numberOfLines];

        Person p = new Person(0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < listOfPatients.length; i++) {
            p = new Person(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            addPerson(p, i);
        }

        return listOfPatients.length;

    }

    /**
     * Allocates the survivabilityByAge array with numberOfLines length, 
     * then reads numberOfLines survivability by age rates from the data 
     * file (each line refers to one survivability rate by age). For each 
     * rate read from the data file, instantiates a SurvivabilityByAge 
     * object and inserts the object into the survivabilityByAge array. 
     * The method returns the number of survivabilities rates read from 
     * file.
     */
    public int readSurvivabilityRateByAgeFromFile(int numberOfLines) {

        survivabilityByAge = new SurvivabilityByAge[numberOfLines];

        for (int i = 0; i < survivabilityByAge.length; i++) {
            survivabilityByAge[i] = new SurvivabilityByAge(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        }

        return survivabilityByAge.length;

    }

    /**
     * Allocates the survivabilityByCause array with numberOfLines length,
     * then reads numberOfLines survivability by cause rates from the 
     * data file (each line refers to one survivability rate by cause). 
     * For each rate read from the data file, instantiates a 
     * SurvivabilityByCause object and inserts the object into the 
     * survivabilityByCause array. The method returns the number of 
     * survivabilities rates read from file.
     */
    public int readSurvivabilityRateByCauseFromFile(int numberOfLines) {

        survivabilityByCause = new SurvivabilityByCause[numberOfLines];

        for (int i = 0; i < survivabilityByCause.length; i++) {
            survivabilityByCause[i] = new SurvivabilityByCause(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        }

        return survivabilityByCause.length;

    }

    /**
     * Returns a Person array with every Person that has age above the 
     * parameter age from the listOfPatients array. The return array has 
     * to be completely full with no empty spots, that is the array size 
     * should be equal to the number of persons with age above the 
     * parameter age. Return null if there is no Person with age above 
     * the parameter age.
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    }

    /**
     * Returns a Person array with every Person that has the state of 
     * health equal to the parameter state from the listOfPatients array. 
     * The return array has to be completely full with no empty spots, 
     * that is the array size should be equal to the number of persons 
     * with the state of health equal to the parameter state. Returns 
     * null if there is no Person with the state of health equal to the 
     * parameter state.
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /**
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the 
     * listOfPatients array. The return array has to be completely full 
     * with no empty spots, that is the array size should be equal to the 
     * number of persons with the heart condition cause equal to the 
     * parameter cause. Return null if there is no Person with the heart 
     * condition cause equal to the parameter cause.
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /** 
     * Assume there are numberOfHearts available for transplantation 
     * surgery. Also assume that the hearts are of the same blood type as 
     * the persons on the listOfPatients. This method finds a set of 
     * persons to be the recepients of these hearts. The method returns a 
     * Person array from the listOfPatients array that have the highest 
     * potential for survivability after the transplant. The array size 
     * is numberOfHearts. If numberOfHeartsAvailable is greater than 
     * listOfPatients array size all Persons will receive a transplant. If
     *  numberOfHeartsAvailable is smaller than listOfPatients array size 
     * find the set of people with the highest potential for survivability.
     */
    public Person[] getPatientsWithAgeAbove(int age) {

        int length = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getAge() > age) {
                length = length + 1;
            }
        }

        if (length == 0) {
            return null;
        }

        Person[] patientsWithAgeAbove = new Person[length];

        int j = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getAge() > age) {
                patientsWithAgeAbove[j] = listOfPatients[i];
                j = j + 1;
            }
        }

        return patientsWithAgeAbove;

    }

    public Person[] getPatientsByStateOfHealth(int state) {

        int length = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getStateOfHealth() == state) {
                length = length + 1;
            }
        }

        if (length == 0) {
            return null;
        }

        Person[] patientsByStateOfHealth = new Person[length];

        int j = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getStateOfHealth() == state) {
                patientsByStateOfHealth[j] = listOfPatients[i];
                j = j + 1;
            }
        }

        return patientsByStateOfHealth;

    }

    public Person[] getPatientsByHeartConditionCause(int cause) {

        int length = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getCause() == cause) {
                length = length + 1;
            }
        }

        if (length == 0) {
            return null;
        }

        Person[] patientsByHeartConditionCause = new Person[length];

        int j = 0;

        for (int i = 0; i < listOfPatients.length; i++) {
            if (listOfPatients[i].getCause() == cause) {
                patientsByHeartConditionCause[j] = listOfPatients[i];
                j = j + 1;
            }
        }

        return patientsByHeartConditionCause;

    }

    public Person[] match(int numberOfHearts) {

        Person[] recipients = new Person[numberOfHearts];

        if (numberOfHearts >= listOfPatients.length) {
            for (int i = 0; i < listOfPatients.length; i++) {
                recipients[i] = listOfPatients[i];
            }
        } else {

            double[] ratesAge = new double[listOfPatients.length];
            for (int i = 0; i < ratesAge.length; i++) {
                for (int j = 0; j < survivabilityByAge.length - 1; j++) {
                    if (listOfPatients[i].getAge() >= survivabilityByAge[j].getAge() &&
                    listOfPatients[i].getAge() < survivabilityByAge[j + 1].getAge() &&
                    survivabilityByAge[j + 1].getYears() == 5) {
                        ratesAge[i] = survivabilityByAge[j + 1].getRate();
                        j = survivabilityByAge.length - 1;
                    }
                }
            }

            double[] ratesCause = new double[listOfPatients.length];
            for (int i = 0; i < ratesCause.length; i++) {
                for (int j = 0; j < survivabilityByCause.length; j++) {
                    if (survivabilityByCause[j].getCause() == listOfPatients[i].getCause() &&
                    survivabilityByCause[j].getYears() == 5) {
                        ratesCause[i] = survivabilityByCause[j].getRate();
                        j = survivabilityByCause.length;
                    }
                }
            }

            double[][] rates = new double[listOfPatients.length][2];
            for (int i = 0; i < rates.length; i++) {
                rates[i][0] = i;
                rates[i][1] = ratesAge[i] + ratesCause[i];
            }

            for (int i = 0; i < rates.length - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < rates.length; j++) {
                    if (rates[j][1] > rates[maxIndex][1]) {
                        maxIndex = j;
                    }
                }
                double tempIndex = rates[i][0];
                double tempRate = rates[i][1];
                rates[i][0] = rates[maxIndex][0];
                rates[i][1] = rates[maxIndex][1];
                rates[maxIndex][0] = tempIndex;
                rates[maxIndex][1] = tempRate;
            }

            for (int i = 0; i < recipients.length; i++) {
                recipients[i] = listOfPatients[(int)rates[i][0]];
            }

        }

        return recipients;

    }

    public static void main(String[] args) {

        HeartTransplant ht = new HeartTransplant();

        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");

        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

    }

}