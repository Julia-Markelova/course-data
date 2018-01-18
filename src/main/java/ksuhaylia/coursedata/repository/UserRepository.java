package ksuhaylia.coursedata.repository;


import ksuhaylia.coursedata.entity.Posts;
import ksuhaylia.coursedata.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<Users,Integer> {
      public Users findUsersByEmail(String email);
      public Users findUsersByAdmin(boolean isAdmin);
}
