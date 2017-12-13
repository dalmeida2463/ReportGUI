package reportgui;

/**
 * This class builds the data placed into the report
 * 
 * @author Dave
 */
public class ReportData {
    
    private String officerFirst, officerLast, 
            firstName, lastName, location, offense;
    private int offenderAge;

    /**
     *
     */
    public ReportData() {
    }

    /**
     * 
     *
     * @param officerFirst
     * @param officerLast
     * @param firstName
     * @param lastName
     * @param offenderAge
     * @param location
     */
    public ReportData(String officerFirst, String officerLast, String firstName, String lastName, int offenderAge, String location) {
        this.officerFirst = officerFirst;
        this.officerLast = officerLast;
        this.firstName = firstName;
        this.lastName = lastName;
        this.offenderAge = offenderAge;
        this.location = location;
    }

    /**
     * Primary Constructor for ReportData data
     *
     * @param officerFirst first name of police officer
     * @param officerLast last name of police officer
     * @param firstName first name of offender
     * @param lastName last name of offender
     * @param offenderAge offender's age
     * @param location location of crime
     * @param offense crime committed by offender
     */
    public ReportData(String officerFirst, String officerLast, 
            String firstName, String lastName, int offenderAge,
            String location, String offense ){
        this.officerFirst = officerFirst;
        this.officerLast = officerLast;
        this.firstName = firstName;
        this.lastName = lastName;
        this.offenderAge = offenderAge;
        this.location = location;
        this.offense = offense;
        
    }

    /**
     * getter method for officer first name
     * 
     * @return first name of police officer
     */
    public String getOfficerFirst() {
        return officerFirst;
    }

    /**
     * setter method for officer first name
     *
     * @param officerFirst
     */
    public void setOfficerFirst(String officerFirst) {
        this.officerFirst = officerFirst;
    }

    /**
     * getter method for officer last name
     *
     * @return last name of police officer
     */
    public String getOfficerLast() {
        return officerLast;
    }

    /**
     * setter method for officer last name
     *
     * @param officerLast
     */
    public void setOfficerLast(String officerLast) {
        this.officerLast = officerLast;
    }

    /**
     * getter method for offender first name
     *
     * @return offender first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter method for offender first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter method for offender first name
     *
     * @return offender last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter method for offender first name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter method for offense location
     *
     * @return offense location
     */
    public String getLocation() {
        return location;
    }

    /**
     * setter method for offense location
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * getter method for offense
     *
     * @return offense committed
     */
    public String getOffense() {
        return offense;
    }

    /**
     * setter method for offense
     *
     * @param offense
     */
    public void setOffense(String offense) {
        this.offense = offense;
    }

    /**
     * getter method for offender age
     *
     * @return offender age
     */
    public int getOffenderAge() {
        return offenderAge;
    }

    /**
     * setter method for offender age
     *
     * @param offenderAge
     */
    public void setOffenderAge(int offenderAge) {
        this.offenderAge = offenderAge;
    }

    /**
     * toString method for data
     * 
     * @return toString
     */
    @Override
    public String toString() {
        return "ReportData{" + "officerFirst=" + officerFirst + 
                ", officerLast=" + officerLast + 
                ", firstName=" + firstName + 
                ", lastName=" + lastName + 
                ", offenderAge=" + offenderAge +
                ", location=" + location + 
                ", offense=" + offense + '}';
    }
    
    
}
