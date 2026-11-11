package ifpb.edu.br.ifgram.Controller;

import ifpb.edu.br.ifgram.Dto.CommentRequest;
import ifpb.edu.br.ifgram.Dto.CommentResponse;
import ifpb.edu.br.ifgram.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> criar(@Valid @RequestBody CommentRequest request) {
        CommentResponse response = commentService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> listarPorPost(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.listarPorPost(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        commentService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}