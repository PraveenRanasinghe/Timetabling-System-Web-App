package com.timetabling.demo.service;

import com.timetabling.demo.dto.moduleDTO;
import com.timetabling.demo.dto.userDTO;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepo moduleRepo;

    public List<Module> getAllModules(){
        return moduleRepo.findAll();
    }


    public List<moduleDTO> getAllModulesToList(){
        List<moduleDTO> list= new ArrayList<>();
        for(Module module:moduleRepo.findAll()){
            moduleDTO dto= new moduleDTO();
            dto.setModuleID(module.getModuleID());
            dto.setModuleName(module.getModuleName());
            list.add(dto);
        }
        return list;
    }

    public Module getModuleById(String mId){
        Optional<Module> module= moduleRepo.findById(mId);
        Module modules=null;
        if(module.isPresent()){
            modules=module.get();
        }
        return modules;
    }

    public Module createModule(moduleDTO dtoModule){
        Module modules= new Module();

        modules.setModuleID(dtoModule.getModuleID());
        modules.setModuleName(dtoModule.getModuleName());
        modules.setBatch(dtoModule.getBatch());
        modules.setUser(dtoModule.getUser());
        return moduleRepo.save(modules);
    }

    public Module updateModuleInfo(moduleDTO dtoModule){
        Module modules= new Module();

        modules.setModuleID(dtoModule.getModuleID());
        modules.setModuleName(dtoModule.getModuleName());
        modules.setBatch(dtoModule.getBatch());
        modules.setUser(dtoModule.getUser());
        return moduleRepo.save(modules);
    }


    public void deleteModules(Module module){
        moduleRepo.delete(module);
    }

}
