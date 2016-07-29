package com.kaishengit.dao;

import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.SearchParam;
import com.kaishengit.util.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class BaseDao<T,PK> {

    @Inject
    private SessionFactory sessionFactory;
    private Class<?> entityClass;

    public BaseDao(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(T t){
        getSession().saveOrUpdate(t);
    }

    public T findById(PK pk){
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.add(Restrictions.eq("id",pk));
        return (T) criteria.uniqueResult();
    }

    public void deleteById(PK pk){
        T t = findById(pk);
        getSession().delete(t);
    }

    public List<T> findAll(){
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria.list();
    }

    public Long countAll(){
//        TODO Class<?> 代表什么意思
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public List<T> findByPage(Page<T> page){
        Criteria criteria = getSession().createCriteria(entityClass);
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getPageSize());
        return criteria.list();
    }

//    TODO 和老师区别  page在service中产生
    public List<T> findByPage(Page<T> page,List<SearchParam> searchParamList){
        Criteria criteria = getCriteria(searchParamList);
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getPageSize());
        return criteria.list();
    }

    private Criteria getCriteria(List<SearchParam> searchParamList) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for(SearchParam searchParam : searchParamList){
            if(searchParam.getType().equals("like")){
                criteria.add(Restrictions.like(searchParam.getPropertyname(),searchParam.getValue().toString(), MatchMode.ANYWHERE));
            }
            if(searchParam.getType().equals("le")){
                criteria.add(Restrictions.le(searchParam.getPropertyname(),searchParam.getValue()));
            }
            if(searchParam.getType().equals("lt")){
                criteria.add(Restrictions.lt(searchParam.getPropertyname(),searchParam.getValue()));
            }
            if(searchParam.getType().equals("ge")){
                criteria.add(Restrictions.ge(searchParam.getPropertyname(),searchParam.getValue()));
            }
            if(searchParam.getType().equals("gt")){
                criteria.add(Restrictions.gt(searchParam.getPropertyname(),searchParam.getValue()));
            }
        }
        return criteria;
    }

    public Long countByCriteria(Criteria criteria) {
        ResultTransformer resultTransformer = criteria.ROOT_ENTITY;

        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();

        criteria.setProjection(null);
        criteria.setResultTransformer(resultTransformer);

        return count;
    }

//    TODO 思考为何把page放入到DAO中
    public Page<T> findByPageNoByParam(Integer pageNo, List<SearchParam> searchParamList) {
        Criteria criteria = getCriteria(searchParamList);
        Integer totalSize = countByCriteria(criteria).intValue();

        Page<T> page = new Page<T>(pageNo,5,totalSize);

        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getPageSize());

        page.setItems(criteria.list());
//
//        Page<Book> bookPage = new Page<>(pageNo,5,totalSize);
//        List<Book> bookList = bookDao.findByPage(bookPage,searchParamList);
//        bookPage.setItems(bookList);

        return page;
    }
}
