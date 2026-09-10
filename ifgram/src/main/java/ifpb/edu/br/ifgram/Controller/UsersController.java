package ifpb.edu.br.ifgram.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kaue")
public class UsersController {

    @GetMapping
    public String getUser () {
        return "meu nome é Kauê";
    }
    @PutMapping
    public String putUser () {
        return "chamei meu endpoint como um put";
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
