package guru.springframework.springmvcrest.bootstrap;

import guru.springframework.springmvcrest.repositories.FileRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final FileRespository fileRespository;

    public BootStrapData(FileRespository fileRespository) {
        this.fileRespository = fileRespository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
