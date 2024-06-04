package org.example.computerspringjwt.service;

import org.example.computerspringjwt.model.Computer;
import org.example.computerspringjwt.repo.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepository computerRepository;
    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findByid(Long id) {
        return computerRepository.findById(id).get();
    }

    @Override
    public void save(Computer computer) {
    computerRepository.save(computer);
    }

    @Override
    public void deleteById(Long id) {
    computerRepository.deleteById(id);
    }
}
