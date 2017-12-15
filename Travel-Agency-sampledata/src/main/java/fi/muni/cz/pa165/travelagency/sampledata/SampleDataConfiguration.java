package fi.muni.cz.pa165.travelagency.sampledata;


import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
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
public class SampleDataConfiguration {
    
    
    @Autowired
    private SampleDataLoadingFacade sampleDataLoadingFacade;
    
    /**
     * Loads the data trough sampleDataLoadingFacade.
     */
    @PostConstruct
    public void dataLoading(){
        sampleDataLoadingFacade.loadData();
    }
}
