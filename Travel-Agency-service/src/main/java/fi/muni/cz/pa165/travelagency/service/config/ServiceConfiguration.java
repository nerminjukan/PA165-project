package fi.muni.cz.pa165.travelagency.service.config;

import fi.muni.cz.pa165.travelagency.PersistenceSampleApplicationContext;
import fi.muni.cz.pa165.travelagency.service.ReservationServiceImpl;
import fi.muni.cz.pa165.travelagency.service.facade.ReservationFacadeImpl;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuariton
 */
@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackageClasses={ReservationServiceImpl.class, ReservationFacadeImpl.class})
public class ServiceConfiguration {

    /**
     * Dozer
     * @return Mapper
     */
    @Bean
    public Mapper dozer(){
        return new DozerBeanMapper();
    }
}
