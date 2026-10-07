package ifpb.edu.br.ifgram.Controller;

import ifpb.edu.br.ifgram.Model.User;

public record UserResponse (Long Id, String Nome, String Email){
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getNome(), user.getEmail());

    }
}

