package org.example.computerspringjwt.controller;


import org.example.computerspringjwt.model.Computer;
import org.example.computerspringjwt.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/computers")
public class ComputerController {
    @Autowired
    private IComputerService computerService;

    @GetMapping("")
    public ResponseEntity<List<Computer>> findAll() {
        return new ResponseEntity<>(computerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> finOne(@PathVariable Long id) {
        Computer c = computerService.findByid(id);
        return new ResponseEntity<>(computerService.findByid(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Computer computer) {
        computerService.save(computer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        computerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> edit(@PathVariable Long id,  @RequestBody Computer computer){
        Optional<Computer> computerOptional = Optional.ofNullable(computerService.findByid(id));
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            computer.setId(id);
            computerService.save(computer);
            return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
        }
    }
}

