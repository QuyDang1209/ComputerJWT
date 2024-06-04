package org.example.computerspringjwt.repo;

import org.example.computerspringjwt.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Long> {
}
