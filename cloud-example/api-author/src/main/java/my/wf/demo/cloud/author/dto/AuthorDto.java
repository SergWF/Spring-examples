package my.wf.demo.cloud.author.dto;

import my.wf.demo.cloud.author.model.Author;

import static org.immutables.value.Value.Immutable;


@Immutable
public interface AuthorDto {

    String getName();
    String getLink();

    static AuthorDto valueOf(Author author) {
        return ImmutableAuthorDto.builder()
                                 .name(author.getName())
                                 .link(author.getLink())
                                 .build();
    }

    static Author buildAuthor(AuthorDto dto) {
        return Author.builder()
                     .name(dto.getName())
                     .link(dto.getLink())
                     .build();
    }

    static Author updateAuthor(AuthorDto dto, Author author) {
        return author.toBuilder()
                     .name(dto.getName())
                     .link(dto.getLink())
                     .build();
    }
}
