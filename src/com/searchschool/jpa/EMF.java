package com.searchschool.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("Mi-JPA-con-JSF");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}