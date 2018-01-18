package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Continents;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContinentsRepository extends CrudRepository<Continents, Integer> {
    public List<Continents> findContinentsBySquare(double square);
    public List<Continents> findContinentsByClimate(String climate);
    public Continents findContinentsByContinentName(String name);
    public void deleteByContinentId(int id);
}
