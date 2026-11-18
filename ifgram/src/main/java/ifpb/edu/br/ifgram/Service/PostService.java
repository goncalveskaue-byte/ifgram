package ifpb.edu.br.ifgram.Service;

import ifpb.edu.br.ifgram.Dto.PostRequest;
import ifpb.edu.br.ifgram.Dto.PostResponse;
import ifpb.edu.br.ifgram.Dto.UserRequest;
import ifpb.edu.br.ifgram.Dto.UserResponse;
import ifpb.edu.br.ifgram.Model.Post;
import ifpb.edu.br.ifgram.Model.User;
import ifpb.edu.br.ifgram.Repository.PostRepository;
import ifpb.edu.br.ifgram.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository repository;
    private final UserRepository repositoryUser;

    public PostService(PostRepository repository, UserRepository repositoryUser) {
        this.repository = repository;
        this.repositoryUser = repositoryUser;

    }
    public PostResponse buscarPorId(Long id ) {
       return PostResponse.from(repository.findById(id).get()) ;
    }
    public List<PostResponse> buscarPorAutor(Long id ) {
       List<Post> posts = repository.findByAutorId(id);
       List<PostResponse> postsresponses = new ArrayList<>();
       for (Post post : posts){
           postsresponses.add(PostResponse.from(post));
       }
       return postsresponses;
    }
    @Transactional
    public PostResponse criar(PostRequest request) throws Exception {

        User autor = repositoryUser.findById(request.autorId()).get();
        Post salvo= repository.save(new Post(request.imagemUrl(),request.legenda(), autor));
        return PostResponse.from(salvo);
    }

    public void deletar (Long id){
        Post post = repository.findById(id).get();
        repository.delete(post);
    }

    public List<PostResponse> getFeed() {
        List<Post> posts = repository.findAll();
        List<PostResponse> postsresponses = new ArrayList<>();
        for (Post post : posts){
            postsresponses.add(PostResponse.from(post));
        }
        return postsresponses;
    }
}
