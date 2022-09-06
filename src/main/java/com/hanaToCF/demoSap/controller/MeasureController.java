package com.hanaToCF.demoSap.controller;

import com.hanaToCF.demoSap.model.Measures;
import com.hanaToCF.demoSap.repo.MeasuresRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class MeasureController {

    @Autowired
    MeasuresRepo mRepo;

    @GetMapping("/measure")
    public List<Measures> getMeasures(){
        log.info("Received Get request");
        return new ArrayList<>(mRepo.findAll());
    }

    @GetMapping("/measure/{id}")
    public Measures getMeasures(@PathVariable("id") Long id){
        log.info("Received Get request for id: {}", id);
        return mRepo.findById(id).orElse(null);
    }

    @DeleteMapping("/measure/{id}")
    public void deleteMeasures(@PathVariable("id") Long id){
        log.info("Received Delete request for id: {}", id);
        mRepo.deleteById(id);
    }

    @PostMapping("/measure")
    public Measures postMeasures(@RequestBody Measures measure){
        log.info("Received post request with body: {}", measure.toString());
        return mRepo.save(measure);
    }
}
