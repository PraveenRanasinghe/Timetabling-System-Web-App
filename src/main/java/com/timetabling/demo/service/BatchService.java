package com.timetabling.demo.service;

import com.timetabling.demo.dto.batchDTO;
import com.timetabling.demo.exceptions.BatchIdExistException;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.model.Module;
import com.timetabling.demo.repositary.BatchRepo;
import com.timetabling.demo.repositary.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    private BatchRepo batchRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    public List<batchDTO> getAllBatchesToList(){
        List<batchDTO> list = new ArrayList<>();
        for(Batch batch: batchRepo.findAll()){
            batchDTO dto= new batchDTO();
            dto.setBatchID(batch.getBatchID());
            dto.setBatchName(batch.getBatchName());
            list.add(dto);
        }
        return list;
    }


    public List<batchDTO> getSelectedModulesBatchList(String moduleId){
        List<batchDTO> list = new ArrayList<>();
        for (Batch batch: moduleRepo.findById(moduleId).get().getBatches()){
            batchDTO dto= new batchDTO();
            dto.setBatchID(batch.getBatchID());
            dto.setBatchName(batch.getBatchName());
            list.add(dto);
        }
        return list;
    }



    public List<Batch> getAllBatches(){
        return batchRepo.findAll();
    }

    public Batch createBatch(batchDTO dtoBatch) throws BatchIdExistException {
        Batch batches = new Batch();
        if(batchRepo.findById(dtoBatch.getBatchID()).isPresent()){
            throw new BatchIdExistException("Batch Id is already used. Please try with another Batch Id.");
        }
        else {
            batches.setBatchID(dtoBatch.getBatchID());
            batches.setBatchName(dtoBatch.getBatchName());
            batches.setStartDate(dtoBatch.getStartDate());
            batches.setEndDate(dtoBatch.getEndDate());
        }
        return batchRepo.save(batches);
    }


    public Batch getBatchById(String bId){
        Optional<Batch> batch= batchRepo.findById(bId);
        Batch batches= null;
        if(batch.isPresent()){
            batches=batch.get();
        }
        return batches;
    }

    public Batch updateBatchInfo(batchDTO dtoBatch){
        Batch batches = new Batch();
        batches.setBatchID(dtoBatch.getBatchID());
        batches.setBatchName(dtoBatch.getBatchName());
        batches.setStartDate(dtoBatch.getStartDate());
        batches.setEndDate(dtoBatch.getEndDate());
        return batchRepo.save(batches);
    }

    public void deleteBatch(Batch batch){
        batchRepo.delete(batch);
    }

    public List<batchDTO> searchBatches(String batchName){
        List<Batch> batchList= new ArrayList<>();
        batchList.addAll(batchRepo.searchBatchName(batchName));
        List<batchDTO> batchDTOS= new ArrayList<>();

        for(Batch batch:batchList){
            batchDTO dto= new batchDTO();
            dto.setBatchName(batch.getBatchName());
            dto.setBatchID(batch.getBatchID());
            dto.setStartDate(batch.getStartDate());
            dto.setEndDate(batch.getEndDate());
            batchDTOS.add(dto);
        }
        return batchDTOS;
    }
}
