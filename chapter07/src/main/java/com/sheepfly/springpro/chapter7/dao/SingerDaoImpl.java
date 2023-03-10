package com.sheepfly.springpro.chapter7.dao;

import com.sheepfly.springpro.chapter7.entity.Singer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@SuppressWarnings("unchecked")
@Transactional(rollbackFor = Throwable.class)
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

    private static final Log logger = LogFactory.getLog(SingerDaoImpl.class);
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        String hql = "select s from Singer s";
        // String hql = "from Singer s";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findById").
                setParameter("id", id).uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    @Override
    public void saveOrUpdate(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("save or update with id:" + singer.getId());
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer deleted with id: " + singer.getId());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
