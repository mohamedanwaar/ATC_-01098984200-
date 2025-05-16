package com.example.bookingsystem.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FilesController {

    @Value("${file.upload-dir}")
    private String uploadDir;

//    @PostMapping("/admin/uploadFile")
    public String uploadFile( MultipartFile file) {
        if (file.isEmpty()) {
            return null; // Return null if the file is empty
        }

        try {
            // Save the file to the upload directory
            String absoluteUploadDir = "C:/uploads"; // Change this to your desired absolute path
            Path filePath = Paths.get(absoluteUploadDir, file.getOriginalFilename());
            Files.createDirectories(filePath.getParent());
            file.transferTo(filePath.toFile());
            System.out.println("File uploaded successfully: " + filePath.toString());
            // Return the file URL
            return "/uploads/" + file.getOriginalFilename();

        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null; // Return null if an error occurs
        }
    }
}

