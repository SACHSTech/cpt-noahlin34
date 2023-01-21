package charts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataRecord {
    

    private StringProperty year;
    private StringProperty country;
    private StringProperty value;

    public DataRecord(String y, String c, String v) {
        this.year = new SimpleStringProperty(y);
        this.country = new SimpleStringProperty(c);
        this.value = new SimpleStringProperty(v);
    }


    public StringProperty yearProperty() {
        return year;
    }

    public StringProperty countryProperty() {
        return country;
    }


    public StringProperty valueProperty() {
        return value;

    }
    

}
