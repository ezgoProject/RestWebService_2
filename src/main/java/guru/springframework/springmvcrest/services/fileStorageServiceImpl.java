package guru.springframework.springmvcrest.services;

import guru.springframework.springmvcrest.domain.fileStorage;
import guru.springframework.springmvcrest.repositories.FileRespository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class fileStorageServiceImpl implements fileStorageService {
    private final FileRespository fileRespository;

    public fileStorageServiceImpl(FileRespository fileRespository) {
        this.fileRespository = fileRespository;
    }

    @Override
    public fileStorage saveFile(fileStorage file) {
        return file;
    }

    @Override
    public fileStorage findFileById(Long id) {
        return fileRespository.getOne(id);
    }

    @Override
    public List<fileStorage> findAllFiles() {
        return null;
    }

    @Override
    public void updateFile(Long Id,fileStorage file) {
        for(int i=0;i<findAllFiles().size();i++){
         fileStorage tempFile =   findAllFiles().get(i);
         if(tempFile.getId() == Id)
             findAllFiles().set(i,file);
            return ;
        }


    }



    @Override
    public void deleteFile(Long id) {
        findAllFiles().removeIf(f->f.getId()==id);
    }

}
