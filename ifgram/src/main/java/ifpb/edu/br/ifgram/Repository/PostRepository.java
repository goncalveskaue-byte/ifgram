package ifpb.edu.br.ifgram.Repository;

import ifpb.edu.br.ifgram.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAutorId(Long autorId);

    List<Post> findByLegendaContainingIgnoreCase(String trecho);

    long countByAutorId(Long autorId);

    @Query("SELECT p FROM Post p ORDER BY p.criadoEm DESC")
    List<Post> findFeed();
}
