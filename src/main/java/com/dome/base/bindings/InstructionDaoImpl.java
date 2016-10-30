package com.dome.base.bindings;

import com.dome.base.model.Instruction;
import com.dome.base.bindings.InstructionDao;
import com.dome.base.persistence.AbstractHibernateDao;
import java.util.List;

public class InstructionDaoImpl extends AbstractHibernateDao implements InstructionDao{
    
    public InstructionDaoImpl(){
        super();
    }
    @Override
    public List<Instruction> findByList() {
        return super.findList(Instruction.class);
    }
    
    @Override
    public void save(Instruction model) {
        super.save(model);
    }
}