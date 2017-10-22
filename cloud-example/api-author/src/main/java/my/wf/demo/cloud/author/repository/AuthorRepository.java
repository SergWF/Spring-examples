package my.wf.demo.cloud.author.repository;

import my.wf.demo.cloud.author.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AuthorRepository {
    Optional<Author> findById(Long id);
    Author save(Author author);
    Page<Author> getAll(Pageable pageable);
}
