package com.kaishengit.dao;

import com.kaishengit.pojo.SearchParam;
import com.kaishengit.util.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.ResultTransformer;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class BaseDao<T,PK extends Serializable> {

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

    /**
     * 位最开始状态 通过 searchParamList 得到查询对象
     * @param page
     * @param searchParamList
     * @return
     */
    public List<T> findByPage(Page<T> page,List<SearchParam> searchParamList){
        Criteria criteria = getCriteria(searchParamList);
        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getPageSize());
        return criteria.list();
    }

    /**
     * 通过 createCriteriaBySearchParamList 构建Criteria对象
     * @param searchParamList
     * @return
     */
    private Criteria getCriteria(List<SearchParam> searchParamList) {
        Criteria criteria = getSession().createCriteria(entityClass);
        createCriteriaBySearchParamList(searchParamList, criteria);
        return criteria;
    }

    /**
     * 为Criteria 创建criteria的searchParam附加条件
     * @param searchParamList
     * @param criteria
     */
    private void createCriteriaBySearchParamList(List<SearchParam> searchParamList, Criteria criteria) {
        for(SearchParam searchParam : searchParamList){
            if(!searchParam.getPropertyname().contains("_or_")){
                criteria.add(createCriterion(searchParam));
            }else{
                String[] params = searchParam.getPropertyname().split("_or_");
                Disjunction disjunction = Restrictions.disjunction();
                for(String pa : params){
                    searchParam.setPropertyname(pa);
                    disjunction.add(createCriterion(searchParam));
                }
                criteria.add(disjunction);
            }
        }
    }

    /**
     * 拆分 searchParam对象中的数据进行组装Restriction对象
     * @param searchParam
     * @return
     */
    private Criterion createCriterion(SearchParam searchParam) {
        if(searchParam.getType().equalsIgnoreCase("like")){
            return Restrictions.like(searchParam.getPropertyname(),searchParam.getValue().toString(), MatchMode.ANYWHERE);
        }else if(searchParam.getType().equalsIgnoreCase("le")){
            return Restrictions.le(searchParam.getPropertyname(),searchParam.getValue());
        }else if(searchParam.getType().equalsIgnoreCase("lt")){
            return Restrictions.lt(searchParam.getPropertyname(),searchParam.getValue());
        }else if(searchParam.getType().equalsIgnoreCase("ge")){
            return Restrictions.ge(searchParam.getPropertyname(),searchParam.getValue());
        }else if(searchParam.getType().equalsIgnoreCase("gt")){
            return Restrictions.gt(searchParam.getPropertyname(),searchParam.getValue());
        }else if(searchParam.getType().equalsIgnoreCase("eq")){
            return Restrictions.eq(searchParam.getPropertyname(),searchParam.getValue());
        }
        return null;
    }

    /**
     * 将count查询出来的数据进行计数
     * @param criteria
     * @return
     */
    public Long countByCriteria(Criteria criteria) {
        ResultTransformer resultTransformer = criteria.ROOT_ENTITY;

        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();

        criteria.setProjection(null);
        criteria.setResultTransformer(resultTransformer);

        return count;
    }

    /**
     * 在dao层组装page
     * @param pageNo
     * @param searchParamList
     * @return
     */
    public Page<T> findByPageNoByParam(Integer pageNo, List<SearchParam> searchParamList){
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

    public Page<T> findByPageNoByCriteria(Criteria criteria, Integer pageNo, List<SearchParam> searchParamList) {
        createCriteriaBySearchParamList(searchParamList,criteria);
        Integer totalSize = countByCriteria(criteria).intValue();

        Page<T> page = new Page<T>(pageNo,5,totalSize);

        criteria.setFirstResult(page.getStart());
        criteria.setMaxResults(page.getPageSize());

        page.setItems(criteria.list());

//        Page<Book> bookPage = new Page<>(pageNo,5,totalSize);
//        List<Book> bookList = bookDao.findByPage(bookPage,searchParamList);
//        bookPage.setItems(bookList);

        return page;
    }
}
