package com.comarch.book.store.model;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

public class Encja1 {
    @ManyToOne
    private Encja2 pole1;
    @ManyToMany
    private Set<Encja2> pole2 = new HashSet<>();
}
