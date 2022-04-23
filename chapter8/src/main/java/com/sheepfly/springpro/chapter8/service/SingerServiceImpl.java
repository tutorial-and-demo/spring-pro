package com.sheepfly.springpro.chapter8.service;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
@Transactional(rollbackFor = {Throwable.class})
public class SingerServiceImpl implements SingerService {
    private static final Logger log = LoggerFactory.getLogger(SingerServiceImpl.class);
    private static final String ALL_SINGER_NATIVE_QUERY = "select id, first_name, last_name, birth_date, version from singer";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Singer> queryAllSinger() {
        return null;
    }

    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Singer findById(long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Singer singer) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAllByNativeQuery() {
        return null;
    }
}
