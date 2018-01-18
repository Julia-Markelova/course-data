package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Posts;
import ksuhaylia.coursedata.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * Created by ymark on 20.12.2017.
 */
public interface PostRepository extends CrudRepository<Posts,Integer> {
 public List<Posts> findPostsByTheme(String theme);
List<Posts> findPostsByType(String type);
List<Posts> findPostsByTypeAndUser(String type, Users user);

}
