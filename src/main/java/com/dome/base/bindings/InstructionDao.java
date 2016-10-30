package com.dome.base.bindings;

import com.dome.base.model.Instruction;
import java.util.List;


public interface InstructionDao{
    public List<Instruction> findByList();
    public void save(Instruction model);
} 