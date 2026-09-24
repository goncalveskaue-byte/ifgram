package ifpb.edu.br.ifgram.Service;

import ifpb.edu.br.ifgram.Controller.UserResponse;
import ifpb.edu.br.ifgram.Dto.UserRequest;

@Service
public class UsersService {
    private final UserRepository repository;

    Public Userservice(UserRepository repository) {
        this repository=repository;

        {

        @Transactional
         public UserResponse criar (UserRequest request) {

            if(repository.existsByEmail(request.email())) {
                throw new EmailDuplicadoException(request.email()));

            }
            User salvo= repository.save(new User(request.nome(),request.email()));
            return UserResponse.from(salvo);


    }
}
