package ksuhaylia.coursedata.controllers;

import ksuhaylia.coursedata.entity.Eras;
import ksuhaylia.coursedata.entity.Literature;
import ksuhaylia.coursedata.repository.ErasRepository;
import ksuhaylia.coursedata.repository.LiteratureRepository;
import ksuhaylia.coursedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by ymark on 19.12.2017.
 */
@Controller
public class LibraryController {

    @Autowired
    private LiteratureRepository literatureRepository;
    @Autowired
    private ErasRepository erasRepository;

    @RequestMapping(value = "/findBooks",method = RequestMethod.POST)
    public @ResponseBody
    List<Literature> findBooks(@RequestParam("min") double min,
                               @RequestParam("max") double max,
                               @RequestParam("name") String name,
                               @RequestParam("book") String book,
                               @RequestParam("era") String era) {
        if (!era.equals("")) {
            Eras eras = erasRepository.findErasByEraName(era);
            if (!name.equals("")) {
                if (!book.equals("")) {
                    return literatureRepository.findLiteratureByPriceBetweenAndAuthorStartsWithAndErasAndBookName(min,
                            max, name, eras, book);
                }
                return literatureRepository.findLiteratureByPriceBetweenAndAuthorStartsWithAndEras(min, max, name, eras);
            }
            return literatureRepository.findLiteratureByPriceBetweenAndEras(min, max, eras);
        }
        return literatureRepository.findLiteratureByPriceBetween(min,max);
    }
}

