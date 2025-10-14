package com.tp.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component("daoapi")
//@Profile("api")
public class DaoApi implements IDao {

    @Override
    public double getValue() {
        return 220;
    }
}
