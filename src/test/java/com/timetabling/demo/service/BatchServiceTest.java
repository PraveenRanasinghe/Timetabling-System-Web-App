package com.timetabling.demo.service;

import com.timetabling.demo.model.Batch;
import com.timetabling.demo.testDto.BatchDTO;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class BatchServiceTest {

    @Autowired
    private BatchService batchService;

    @Test
    public void getAllBatches(){
        List<Batch> allBatches = batchService.getAllBatches();
        assertThat(allBatches,not(IsEmptyCollection.empty()));
    }

}
