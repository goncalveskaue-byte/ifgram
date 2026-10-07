package ifpb.edu.br.ifgram.Service;

import ifpb.edu.br.ifgram.Controller.UserResponse;
import ifpb.edu.br.ifgram.Dto.UserRequest;
import ifpb.edu.br.ifgram.Model.User;
import ifpb.edu.br.ifgram.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
