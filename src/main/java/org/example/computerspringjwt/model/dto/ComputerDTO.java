package org.example.computerspringjwt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComputerDTO {
    // Data transfer object
    private String name;
    private String code;
    private String producer;
    private String type;

    private MultipartFile file;
}
