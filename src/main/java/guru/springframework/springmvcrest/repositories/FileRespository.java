package guru.springframework.springmvcrest.repositories;

import guru.springframework.springmvcrest.domain.fileStorage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRespository extends JpaRepository<fileStorage, Long > {


}
