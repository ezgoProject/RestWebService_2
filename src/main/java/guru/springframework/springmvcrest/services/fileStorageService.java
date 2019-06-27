package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.fileStorage;

import java.util.List;

public interface fileStorageService {

      fileStorage saveFile(fileStorage file);

    fileStorage findFileById(Long id);

    List<fileStorage> findAllFiles();


     void updateFile(Long id,fileStorage file);



    void deleteFile(Long id);
}
