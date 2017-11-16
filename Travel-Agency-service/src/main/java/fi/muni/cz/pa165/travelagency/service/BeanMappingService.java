package fi.muni.cz.pa165.travelagency.service;

import java.util.Collection;
import java.util.List;
import org.dozer.Mapper;

/**
 * Bean mapping
 */
public interface BeanMappingService {
    /**
     * @param <T> type
     * @param objects collection to be mapped
     * @param mapToClass class to be mapped into
     * @return mapped list
     */
    <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

    /**
     * @param <T> type
     * @param u object to be mapped
     * @param mapToClass class to be mapped into
     * @return mapped object
     */
    <T> T mapTo(Object u, Class<T> mapToClass);
    
    /**
     * @return Mapper
     */
    Mapper getMapper();
    
}
