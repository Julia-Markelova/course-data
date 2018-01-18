package ksuhaylia.coursedata.repository;

import ksuhaylia.coursedata.entity.Eras;
import ksuhaylia.coursedata.entity.Literature;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface LiteratureRepository extends CrudRepository<Literature,Integer> {
    List<Literature> findLiteratureByPriceBetweenAndAuthorStartsWithAndErasAndBookName(double min, double max,
                                                                                              String author, Eras eras,
                                                                                              String book);
    List<Literature> findLiteratureByPriceBetweenAndAuthorStartsWithAndEras(double min, double max, String author, Eras eras);
    List<Literature> findLiteratureByPriceBetweenAndEras(double min, double max, Eras eras);
    List<Literature> findLiteratureByPriceBetween(double min,double max);
}
