package ifpb.edu.br.ifgram.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagemUrl;

    @Column(length = 300)
    private String legenda;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User autor;

    public Post() {
    }

    public Post(String imagemUrl, String legenda, User autor) {
        this.imagemUrl = imagemUrl;
        this.legenda = legenda;
        this.autor = autor;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public String getLegenda() {
        return legenda;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public User getAutor() {
        return autor;
    }
}

// Por que o relacionamento é @ManyToOne no Post e não @OneToMany?

    /*Porque a anotação reflete a perspectiva da classe Post: muitos posts (Many) pertencem a um único usuário (One).
    A anotação @OneToMany seria usada apenas na classe User, onde um usuário possui muitos posts.
     */


//Quem guarda a chave estrangeira, a tabela tb_post ou a tb_user?

    /*A tabela tb_post. Em relacionamentos de banco de dados, o lado "muitos" é quem sempre guarda a chave estrangeira (user_id)
    referenciando o ID do usuário na tabela tb_user.
     */
