package ifpb.edu.br.ifgram.Repository;

import ifpb.edu.br.ifgram.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdOrderByCriadoEmAsc(Long postId);

    long countByPostId(Long postId);

    List<Comment> findByAutorId(Long autorId);
}
