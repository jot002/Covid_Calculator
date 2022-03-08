/**
* Creates a DataPoint that takes in the 4 parameters that include information
* on when, where, the total cases, and cases of covid by race.
*
* Bugs: None known
*
* @author   Jonathan Tran
*/

public class DataPoint {
    // The number and races represented in this data point.  DO NOT CHANGE.
    public int numRaces = 8;
    private String[] races = {"White", "Black", "LatinX", "Asian", "AIAN",
                            "NHPI", "Multiracial", "Other"};
    // the date in the form of year, month, day
    private String date;
    // state abbreviation
    private String state;
    // total number of cases that were reported on that day
    private int totalCases;
    // number of cases per race on a given day
    private int[] casesByRace;


    /**
    * Constructor: Initializes the member variable date to dateIn, state
    * to stateIn, totalCases to totalCasesIn, and casesByRace to casesByRaceIn.
    *
    * @param dateIn The date in the form of year, month, day
    * @param stateIn The state abbreviation
    * @param totalCasesIn Total number of cases reported that day
    * @param asesByRaceIn The number of cases per race on a given day
    */
    public DataPoint(String dateIn, String stateIn, int totalCasesIn,
                    int[] casesByRaceIn) {
        // initializes the private member variables, date, state, totalCases,
        // and casesByRace
        this.date = dateIn;
        this.state = stateIn;
        this.totalCases = totalCasesIn;
        this.casesByRace = casesByRaceIn;
    }
    
   /**     
    * Returns a String representation of this date.  
    * @return the date of the covid cases as it is stored 
    * in the DataPoint object
    */
    public String getDate() {
        return this.date;
    }

    /**     
    * Returns a String representation of the state.  
    * @return the state of the covid cases as it is stored 
    * in the DataPoint object
    */
    public String getState() {
        return this.state;
    }

    /**     
    * Returns a String representation of this date.  
    * @param raceIndex the index of the race
    * @return the number of cases by race at the given index position
    */
    public int getCasesByRace(int raceIndex) {
        return this.casesByRace[raceIndex];
    }

    /**     
    * Returns the total number of cases as an int
    * @return total number of cases
    */
    public int getTotalCases() {
        return this.totalCases;
    }

    /**
    * Return the race name associated with the given index in this data point.
    * Preconditions: index is between 0 (inclusive) and numRaces (8) (exclusive)
    *
    * DO NOT CHANGE.
    *
    * @param index The index of the race.
    * @return The name of the race (e.g. "White" or "LatinX")
    */
    public String getRaceName(int index) {
        return this.races[index];
    }
}
