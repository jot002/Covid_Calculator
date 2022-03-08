/**
 * Creates an array of Datapoints called points that contains that same
 * amount of Datapoints as inputData 
 *
 * Bugs: None known
 *
 * @author   Jonathan Tran
 */
public class CovidCalculator {
    private DataPoint[] points;  // The data points to use in the calculations
    /**     
    * Constructor: Initializes the member variable points for future 
    * calculations; it copies the data from inputData into points by looping.
    *
    * @param inputData data place that points will take data from
    */
    public CovidCalculator(DataPoint[] inputData) {
        // initializes points to a be used in the future
        this.points = new DataPoint[inputData.length];
        int i;
        // copies the data from inputData into points using looping
        for (i=0; i < inputData.length; ++i) {
            points[i] = inputData[i];
        }
    }
    
    /**     
    * Returns a DataPoint[] representation of points.  
    * @return points 
    */
    public DataPoint[] getPoints() {
        return this.points;
    }

    /**     
    * Returns the average number of total cases across all the states on
    * a certain date as a double
    * @param date 
    * @return numAverage: average number of  total cases on that date across
    * all states
    */
    public double findAverageCases(String date) {
        int total = 0;
        int total_dates = 0;
        double numAverage;
        for (DataPoint elem: this.points) { 
            if (elem.getDate().equals(date)) {
                // incrementing the amount of dates that are equal to the 
                // argument by 1
                total_dates = total_dates + 1;
                // adding the total cases to the total amount
                total = total + elem.getTotalCases();
            }
        }
        //if the total was 0, return 0 as a double
        if (total == 0) {
            numAverage = (double)total;
            return numAverage;
        }
        // converting numAverage into a double
        numAverage = (double)total / total_dates;
        return numAverage;
    }
    
    /**     
    * Returns the String representation of the race that has the highest 
    * number of cases on the given date and state
    * @param date used to find the race with the highest cases
    * @param state used to find the race with the highest cases
    * @return race with the highest number of cases on the given date and 
    * state as a string.
    */
    public String findRaceWithHighestCases(String date, String state) {
        for (DataPoint elem: points) {
            if (elem.getDate().equals(date) && elem.getState().equals(state)){ 
                int maxCase = 0;
                for (int i=0; i < elem.numRaces; i++) {
                    // loops through to find the max cases by race
                    if (elem.getCasesByRace(i) > maxCase) {
                        maxCase = elem.getCasesByRace(i);
                    }
                }
                for (int i=0; i < elem.numRaces; i++) {
                    // uses the max cases from the above loop to get the race
                    if (elem.getCasesByRace(i) == maxCase) { 
                        return elem.getRaceName(i);
                    }         
                }
            }
        }
        return null;
    }

    /**     
    * Returns a String representation of the date that has the highest
    * number of total cases in a given state. 
    * @param state the state that will be analyzed 
    * @return the date of the highest total cases in the given state.
    */
    public String findDateWithHighestCases(String state) {
        int maxCases = 0;
        for (DataPoint elem: points) {
            if (elem.getTotalCases() > maxCases && 
                elem.getState().equals(state))  {
                // set maxCases to the total cases
                maxCases = elem.getTotalCases();
            }
        }
        for (DataPoint element: points) {
            if (element.getState().equals(state) && 
                element.getTotalCases() == maxCases) {
                // return date that has the highest number of total cases in 
                // the given state
                return element.getDate();
                }
        }
        return null;
    }
}
