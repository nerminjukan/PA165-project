package fi.muni.cz.pa165.travelagency.sampledata;

import java.text.ParseException;

/**
 * Populates database with sample data.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
public interface SampleDataLoadingFacade {
    
    /**
     * Creates the sample data for the application.
     * 
     * @throws ParseException when date cannot be parsed.
     */
    void loadData() throws ParseException;
}
