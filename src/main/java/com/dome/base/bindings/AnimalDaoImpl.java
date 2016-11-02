package com.dome.base.bindings;


import com.dome.base.model.Animal;
import com.dome.base.bindings.AnimalDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;
public class AnimalDaoImpl extends AbstractHibernateDao implements AnimalDao{
     public AnimalDaoImpl(){
        super();
    }
    @Override
    public List<Animal> findByList() {
        return super.findList(Animal.class);
    }
    
    @Override
    public void save(Animal animal) {
        super.save(animal);
    }
}