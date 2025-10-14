package com.tp.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component("daofile")
//@Profile("file")
public class DaoFile implements IDao {

    @Override
    public double getValue() {
        return 180;
    }
}
