package com.example.file_storage_system;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping()
public class FileController {
    
    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("username") String username) throws IOException {

        String filePath = "uploaded_files/" + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        FileMetadata fileMetadata = new FileMetadata();
        fileMetadata.setFilename(file.getOriginalFilename());
        fileMetadata.setUsername(username);
        fileMetadata.setTimestamp(System.currentTimeMillis());

        fileMetadataRepository.save(fileMetadata);

        return "file uploaded successfully";                        
    }
}
