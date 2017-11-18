package fi.muni.cz.pa165.travelagency.service;

import org.dozer.Mapper;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BeanMappingServiceImpl implements BeanMappingService {

    @Autowired
    private Mapper dozer;

    @Override
    public <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass) {
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : objects) {
            mappedCollection.add(dozer.map(object, mapToClass));
        }
        return mappedCollection;
    }

    @Override
    public <T> T mapTo(Object u, Class<T> mapToClass) {
        return dozer.map(u,mapToClass);
    }

    @Override
    public Mapper getMapper() {
        return dozer;
    }
}
