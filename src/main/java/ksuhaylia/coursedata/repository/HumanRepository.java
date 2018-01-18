package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Eras;
import ksuhaylia.coursedata.entity.Human;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HumanRepository extends CrudRepository<Human,Integer> {
    public List<Human> findHumansByEras(Eras era);
    public List<Human> findHumansByHumanName(String name);
    public void deleteByHumanId(int id);
}
