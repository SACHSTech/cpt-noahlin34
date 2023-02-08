package cpt;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * @author Noah Lin
 * Class responsible for handling data in the table
 * Creates datarecord object.
 * 
 */
public class DataRecord {
    

    private StringProperty year;
    private StringProperty country;
    private StringProperty value;

    /**
     * Constructor method for datarecord class. Contains all 3 values for 3 columns. 
     * @param y year
     * @param c country
     * @param v value 
     */
    public DataRecord(String y, String c, String v) {
        this.year = new SimpleStringProperty(y);
        this.country = new SimpleStringProperty(c);
        this.value = new SimpleStringProperty(v);
    }


    //getter method for the year 
    public StringProperty yearProperty() {
        return year;
    }

    //getter method for the country 
    public StringProperty countryProperty() {
        return country;
    }


    //getter method for the coefficient value. 
    public StringProperty valueProperty() {
        return value;

    }
    

}
