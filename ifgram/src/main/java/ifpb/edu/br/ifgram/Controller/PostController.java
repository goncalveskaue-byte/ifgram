package ifpb.edu.br.ifgram.Controller;

import ifpb.edu.br.ifgram.Dto.PostRequest;
import ifpb.edu.br.ifgram.Dto.PostResponse;
import ifpb.edu.br.ifgram.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getFeed() {
        return ResponseEntity.ok(postService.getFeed());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(postService.buscarPorId(id));
    }

    @GetMapping("/autor/{autorId}")
    public ResponseEntity<List<PostResponse>> buscarPorAutor(@PathVariable Long autorId) {
        return ResponseEntity.ok(postService.buscarPorAutor(autorId));
    }

    @PostMapping
    public ResponseEntity<PostResponse> criar(@Valid @RequestBody PostRequest request) throws Exception{
        PostResponse response = postService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        postService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
