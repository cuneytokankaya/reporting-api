package com.cuneytokankaya.homework.reportingapi.repository;

import com.cuneytokankaya.homework.reportingapi.model.Acquirer;
import com.cuneytokankaya.homework.reportingapi.model.Merchant;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AcquirerRepository {

    public Acquirer getAcquirerById(Long id)
    {
        Optional<Acquirer> filteredAcquirer= getDummyAcquirers()
                .stream()
                .filter(merchant -> merchant.getId().equals(id))
                .findAny();

        return filteredAcquirer.isPresent() ? filteredAcquirer.get() : null;
    }

    public List<Acquirer> getDummyAcquirers()
    {
        Acquirer a1 = new Acquirer();
        a1.setId(1L);
        a1.setCode("1");
        a1.setName("Acquirer 1");
        a1.setType("1");

        Acquirer a2 = new Acquirer();
        a2.setId(2L);
        a2.setCode("2");
        a2.setName("Acquirer 2");
        a2.setType("2");

        Acquirer a3 = new Acquirer();
        a3.setId(3L);
        a3.setCode("3");
        a3.setName("Acquirer 3");
        a3.setType("3");

        Acquirer a4 = new Acquirer();
        a4.setId(4L);
        a4.setCode("4");
        a4.setName("Acquirer 4");
        a4.setType("4");

        Acquirer a5 = new Acquirer();
        a5.setId(5L);
        a5.setCode("5");
        a5.setName("Acquirer 5");
        a5.setType("5");

        return Arrays.asList(a1,a2,a3,a4,a5);
    }
}
