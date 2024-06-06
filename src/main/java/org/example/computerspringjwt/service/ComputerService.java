package org.example.computerspringjwt.service;

import org.example.computerspringjwt.model.Computer;
//import org.example.computerspringjwt.model.dto.ComputerDTO;
import org.example.computerspringjwt.model.dto.ComputerDTO;
import org.example.computerspringjwt.repo.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ComputerService implements IComputerService{
    @Value("${upload.path}")
    private String upload;
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

    @Override
    public Computer saveComputerDTO(ComputerDTO computerDTO) {
        // save Multipart de lay urlImage
        MultipartFile multipartFile = computerDTO.getFile();
        String urlImage = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(computerDTO.getFile().getBytes(), new File(upload, urlImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // chuyen doi ComputerDTO -> Computer
        Computer computer = new Computer();
        computer.setName(computerDTO.getName());
        computer.setCode(computerDTO.getCode());
        computer.setType(computerDTO.getType());
        computer.setProducer(computerDTO.getProducer());

        // gan urlImage vao Computer
        computer.setUrl(urlImage);
        computerRepository.save(computer);

        return computer;
    }
}
