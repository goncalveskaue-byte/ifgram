package ifpb.edu.br.ifgram.Service;

import ifpb.edu.br.ifgram.Controller.UserResponse;
import ifpb.edu.br.ifgram.Dto.UserRequest;
import ifpb.edu.br.ifgram.Model.User;
import ifpb.edu.br.ifgram.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UserRepository repository;

    public UsersService(UserRepository repository) {
        this.repository = repository;

    }

        @Transactional
         public UserResponse criar (UserRequest request) throws Exception {

            if(repository.existsByEmail(request.email())) {
                throw new Exception(request.email());

            }
            User salvo= repository.save(new User(request.nome(),request.email()));
            return UserResponse.from(salvo);
    }

    public UserResponse atualizarUsuario(UserRequest request) throws Exception {
        Optional<User> usuario = repository.findByEmail(request.email());
        if(usuario.isEmpty()){
            throw new Exception("usuário nao existe na base dos dados.");
        }
        User usuarioSalvo = usuario.get();
        usuarioSalvo.setNome(request.nome());
        repository.save(usuarioSalvo);

        return UserResponse.from(usuarioSalvo);

    }
    public void deletarUsuario (UserRequest request) throws Exception{
        Optional<User> usuario = repository.findByEmail(request.email());
        if(usuario.isEmpty()){
            throw new Exception("Usuario não encontrado!");

        }
        User usuarioDeletar = usuario.get();
        repository.delete(usuarioDeletar);
    }
}
