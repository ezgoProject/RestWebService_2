package guru.springframework.springmvcrest.controllers;
import guru.springframework.springmvcrest.domain.fileStorage;
import guru.springframework.springmvcrest.services.fileStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileStore;
import java.util.List;


@RestController

public class FileController {
    private final fileStorageService filestorageservice;

    public FileController(fileStorageService filestorageservice) {
        this.filestorageservice = filestorageservice;
    }
    @GetMapping
    List<fileStorage> getAllFiles(){
        return filestorageservice.findAllFiles();
    }
    @RequestMapping(method = RequestMethod.POST,value="/storage/documents")
    public void saveFile(@RequestBody fileStorage file){
        filestorageservice.saveFile(file);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/storage/documents/{docId}")
    public ResponseEntity<fileStorage>  updateFile(@RequestBody fileStorage file,@PathVariable Long id){
        fileStorage isExist = filestorageservice.findFileById(id);
        if (isExist == null) {
            return new ResponseEntity<fileStorage>(HttpStatus.NO_CONTENT);
        } else if (file == null) {
            return new ResponseEntity<fileStorage>(HttpStatus.BAD_REQUEST);
        }
        filestorageservice.updateFile(id,file);
        return new ResponseEntity<fileStorage>(file, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value="/storage/documents/{docId}")
    @ResponseBody
    public ResponseEntity<fileStorage> findFileById(@PathVariable Long id){
        fileStorage file = filestorageservice.findFileById(id);
        if(file ==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }
        return ResponseEntity.ok(file);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/storage/documents/{docId}")
    public ResponseEntity<fileStorage>  deleteFile(@PathVariable Long id, ServerHttpResponse response){
        fileStorage isExist = filestorageservice.findFileById(id);
        if(isExist == null){
            return new ResponseEntity<fileStorage>(HttpStatus.NO_CONTENT);
        }
            filestorageservice.deleteFile(id);
        return new ResponseEntity<fileStorage>( HttpStatus.OK);

    }
}
