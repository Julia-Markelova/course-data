package ksuhaylia.coursedata.repository;


import com.sun.org.apache.regexp.internal.RE;
import ksuhaylia.coursedata.entity.Relief;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReliefRepository extends CrudRepository<Relief, Integer> {
    public List<Relief> findReliefsByHeightBefore(double height);
    public List<Relief> findReliefsByHeightAfter(double height);
    public List<Relief> findReliefsByHeight(double height);
    public List<Relief> findReliefsByContinents(String continent);
    public List<Relief> findReliefsByMinerals(String mineral);
    public List<Relief> findReliefsByReliefName(String name);
    public void deleteByReliefId(int id);
}
