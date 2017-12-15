package fi.muni.cz.pa165.travelagency.sampledata;


import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import java.text.ParseException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Adds SampleDataLoadingFacade bean to ServiceConfiguration.
 *
 * @author (name = "Nermin Jukan", UCO = "<473370>")
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = {SampleDataLoadingFacadeImpl.class})
public class SampleDataConfiguration{
    
    
    @Autowired
    private SampleDataLoadingFacade sampleDataLoadingFacade;
    
    /**
     * Loads the data trough sampleDataLoadingFacade.
     * @throws ParseException when date cannot be parsed.
     */
    @PostConstruct
    public void dataLoading() throws ParseException{
        sampleDataLoadingFacade.loadData();
    }
}
