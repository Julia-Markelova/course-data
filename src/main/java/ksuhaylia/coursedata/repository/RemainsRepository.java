package ksuhaylia.coursedata.repository;

import com.sun.org.apache.regexp.internal.RE;
import ksuhaylia.coursedata.entity.Continents;
import ksuhaylia.coursedata.entity.FloraFauna;
import ksuhaylia.coursedata.entity.Remains;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RemainsRepository extends CrudRepository<Remains,Integer> {
    public List<Remains> findRemainsByGroupOfArchaeologists(String group);
    public List<Remains> findRemainsByFloraFauna(FloraFauna ff);
    public List<Remains> findRemainsByRemainAgeBefore(int age);
    public List<Remains> findRemainsByRemainAgeAfter(int age);
    public List<Remains> findRemainsByContinents(Continents continent);
    public List<Remains> findRemainsByRemainAge(int age);
    public void deleteByRemainId(int id);
}
