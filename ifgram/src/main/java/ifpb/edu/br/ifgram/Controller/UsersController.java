package ifpb.edu.br.ifgram.Controller;

import ifpb.edu.br.ifgram.Dto.UserRequest;
import ifpb.edu.br.ifgram.Service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UsersController {

    public final UsersService service;

    public UsersController(UsersService service){
        this.service = service;
    }
    @GetMapping
    public String getUser () {
        return "meu nome é Kauê";
    }
    @PutMapping
    public UserResponse UpdateUser(UserRequest request) throws Exception {
        return service.atualizarUsuario(request);
    }
    @PatchMapping
    public String patchUser () {
        return "chamei meu endpoint como um patch";
    }
    @PostMapping
    public String postUser () {
        return "chamei meu endpoint como um post";
    }
    @DeleteMapping
    public String deleteUser () {
        return "chamei meu endpoint como um delete";
    }
}
