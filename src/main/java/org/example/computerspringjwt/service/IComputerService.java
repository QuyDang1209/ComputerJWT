package org.example.computerspringjwt.service;

import org.example.computerspringjwt.model.Computer;

import java.util.List;

public interface IComputerService {
List<Computer> findAll();
Computer findByid(Long id);
void save(Computer computer);
void deleteById(Long id);
}
