package fi.muni.cz.pa165.travelagency.sampledata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.muni.cz.pa165.travelagency.service.config.ServiceConfiguration;
import java.io.IOException;
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
    
    final static Logger log = LoggerFactory.getLogger(SampleDataConfiguration.class);
    
    @Autowired
    SampleDataLoadingFacade sampleDataLoadingFacade;
    
    @PostConstruct
    public void dataLoading() throws IOException{
        log.debug("dataLoading()");
        sampleDataLoadingFacade.loadData();
    }
}
