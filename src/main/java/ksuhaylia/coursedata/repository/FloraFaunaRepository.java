package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.FloraFauna;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FloraFaunaRepository extends CrudRepository<FloraFauna, Integer> {
    public List<FloraFauna> findFloraFaunaByAnimalNameStartsWith(String pattern);
    public List<FloraFauna> findFloraFaunaByFoodType(String foodType);
    public List<FloraFauna> findFloraFaunaByParentId(int id);
    public void deleteByAnimalId(int id);
    List<FloraFauna> findFloraFaunaByAreal(String areal);
}
