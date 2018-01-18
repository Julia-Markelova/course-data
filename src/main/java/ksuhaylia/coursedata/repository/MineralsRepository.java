package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Minerals;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface MineralsRepository extends CrudRepository<Minerals,Integer> {
    public List<Minerals> findMineralsByPriceBefore(BigInteger price);
    public  List<Minerals> findMineralsByPriceAfter(BigInteger price);
    public  List<Minerals> findMineralsByChemistryStructure(String structure);
    public List<Minerals> findMineralsByMineralName(String name);
    public List<Minerals> findMineralsByReliefs(String relief);

    public void deleteByMineralId(int id);
}
