package my.wf.demo.cloud.author.error;


public class AuthorNotFoundException extends RuntimeException {
    private final Long authorId;

    public AuthorNotFoundException(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String getMessage() {
        return String.format("Author not found by id %d", authorId);
    }
}
