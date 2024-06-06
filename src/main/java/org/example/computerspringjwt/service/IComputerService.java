package org.example.computerspringjwt.service;

import org.example.computerspringjwt.model.Computer;
import org.example.computerspringjwt.model.dto.ComputerDTO;
//import org.example.computerspringjwt.model.dto.ComputerDTO;

import java.util.List;

public interface IComputerService {
    List<Computer> findAll();
    Computer findByid(Long id);
    void save(Computer computer);
    void deleteById(Long id);

    Computer saveComputerDTO(ComputerDTO computerDTO);
}
