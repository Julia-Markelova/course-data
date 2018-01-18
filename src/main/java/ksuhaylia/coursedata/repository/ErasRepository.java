package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Continents;
import ksuhaylia.coursedata.entity.Eras;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ErasRepository extends CrudRepository<Eras,Integer> {
    public Eras findErasByEraName(String name); //т к имя уникально 100%, поэтому получим 1 эру
    public List<Eras> findErasByClimate(String climate);
    public List<Eras> findErasByContinents(List<Continents> continents);
    public void deleteByEraId(int id);
}
