package com.timetabling.demo.service;

import com.timetabling.demo.dto.batchDTO;
import com.timetabling.demo.model.Batch;
import com.timetabling.demo.repositary.BatchRepo;
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

    public List<Batch> getAllBatches(){
        return batchRepo.findAll();
    }

    public Batch createBatch(batchDTO dtoBatch){
        Batch batches = new Batch();
        batches.setBatchID(dtoBatch.getBatchID());
        batches.setBatchName(dtoBatch.getBatchName());
        batches.setStartDate(dtoBatch.getStartDate());
        batches.setEndDate(dtoBatch.getEndDate());
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
}
