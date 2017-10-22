package my.wf.demo.cloud.author.controller;

import lombok.AllArgsConstructor;
import my.wf.demo.cloud.author.dto.AuthorDto;
import my.wf.demo.cloud.author.service.AuthorsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/authors", produces = {"application/json;charset=UTF-8"})
public class AuthorsController {

    private final AuthorsService authorsService;


    @GetMapping(value = "/{id}")
    public AuthorDto getAuthor(Long id) {
        return authorsService.getAuthor(id, AuthorDto::valueOf);
    }

    @GetMapping
    public Page<AuthorDto> getAuthors(Pageable pageable){
        return authorsService.getPagedAuthors(AuthorDto::valueOf, pageable);
    }

    @PostMapping
    public AuthorDto createAuthor(@Valid @RequestBody AuthorDto authorDto){
        return  authorsService.createAuthor(authorDto, AuthorDto::buildAuthor, AuthorDto::valueOf);

    }

    @PutMapping(value = "/{id}")
    public AuthorDto updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDto authorDto){
        return  authorsService.updateAuthor(id, authorDto, AuthorDto::updateAuthor, AuthorDto::valueOf);
    }

}
