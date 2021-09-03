package com.timetabling.demo.service;

import com.timetabling.demo.dto.ModuleDTO;
import com.timetabling.demo.exceptions.ModuleIdExistException;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.BatchRepo;
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

    @Autowired
    private EmailService emailService;

    @Autowired
    private BatchRepo batchRepo;

    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }


    public List<ModuleDTO> getAllModulesToList() {
        List<ModuleDTO> list = new ArrayList<>();
        for (Module module : moduleRepo.findAll()) {
            ModuleDTO dto = new ModuleDTO();
            dto.setModuleID(module.getModuleID());
            dto.setModuleName(module.getModuleName());
            dto.setBatches(module.getBatches());
            dto.setUser(module.getUser());
            list.add(dto);
        }
        return list;
    }


    public Module getModuleById(String mId) {
        Optional<Module> module = moduleRepo.findById(mId);
        Module modules = null;
        if (module.isPresent()) {
            modules = module.get();
        }
        return modules;
    }

    public Module createModule(ModuleDTO dtoModule) throws ModuleIdExistException {
        Module modules = new Module();
        if(moduleRepo.findById(dtoModule.getModuleID()).isPresent()){
            throw new ModuleIdExistException("Module Id is already Used! Please try again with another Module Id.");
        }
        List<Batch> batchList = new ArrayList();

        modules.setModuleID(dtoModule.getModuleID());
        modules.setModuleName(dtoModule.getModuleName());
        modules.setUser(dtoModule.getUser());

        for (Batch batches : dtoModule.getBatches()) {
            batchList.add(batchRepo.findById(batches.getBatchID()).get());
        }
        modules.setBatches(batchList);
        emailService.EmailToLecWhenModuleIsAssigned(dtoModule.getUser().getEmail());
        return moduleRepo.save(modules);
    }


    public Module updateModuleInfo(ModuleDTO dtoModule) {
        Module modules = new Module();
        List<Batch> batchList = new ArrayList();

        modules.setModuleID(dtoModule.getModuleID());
        modules.setModuleName(dtoModule.getModuleName());
        modules.setUser(dtoModule.getUser());

        Optional<Module> byId = moduleRepo.findById(dtoModule.getModuleID());

        if (byId.isPresent()) {
            batchList = byId.get().getBatches();
        }
        modules.setBatches(batchList);
        return moduleRepo.save(modules);
    }


    public void deleteModules(Module module) {
        moduleRepo.delete(module);
    }

    public List<Module> getModulesInBatch(Batch batchId){
        return moduleRepo.findModulesByBatchesEquals(batchId);
    }

    public List<Module> getLecturerModules(String email){
        return moduleRepo.findModulesByUserEmail_Email(email);
    }


    public List<ModuleDTO> searchModules(String modName){
        List<Module> moduleList= new ArrayList<>();
        moduleList.addAll(moduleRepo.getModuleName(modName));
        List<ModuleDTO> moduleDTOList= new ArrayList<>();

        for (Module module:moduleList){
            ModuleDTO dto= new ModuleDTO();
            dto.setBatches(module.getBatches());
            dto.setModuleName(module.getModuleName());
            dto.setModuleID(module.getModuleID());
            dto.setUser(module.getUser());
            moduleDTOList.add(dto);
        }
        return moduleDTOList;
    }
}
