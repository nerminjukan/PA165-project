package fi.muni.cz.pa165.travelagency.service;

import org.dozer.Mapper;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.Collection;
import java.util.List;

public class BeanMappingServiceImpl implements BeanMappingService {
    @Override
    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        throw new NotYetImplementedException();
    }

    @Override
    public <T> T mapTo(Object u, Class<T> mapToClass) {
        throw new NotYetImplementedException();
    }

    @Override
    public Mapper getMapper() {
        throw new NotYetImplementedException();
    }
}
