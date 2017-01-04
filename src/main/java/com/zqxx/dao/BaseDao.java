package com.zqxx.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDao<T> extends HibernateDaoSupport {
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	public T get(Class<T> entityClass, Serializable id){
		return this.getHibernateTemplate().get(entityClass, id);
	}
	public T findOne(String hql,Object value){
		List<?> list=this.find(hql, value);
		if(list.size()>0)return (T) list.get(0);
		else return null;
	}
	public Serializable save(Object entity){
		return this.getHibernateTemplate().save(entity);
	}
	public  List<?> find(String queryString){
		return this.getHibernateTemplate().find(queryString);
	}
	public  List<?> find(String queryString,Object value){
		return this.getHibernateTemplate().find(queryString,value);
	}
	public  List<?> find(String queryString,Object... value){
		return this.getHibernateTemplate().find(queryString,value);
	}
	
	public Page  pageFind(final String queryString,final String totalhql,final Integer pageSize,final Integer pageNo,final Object... values){
		return this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Page>() {
			@Override
			public Page doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				Query totalquery = session.createQuery(totalhql);
				 
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
						totalquery.setParameter(i, values[i]);
					}
				}
				queryObject.setFirstResult((pageNo-1)*pageSize);
				queryObject.setMaxResults(pageSize);
				List list=queryObject.list();
				Long total=(Long) totalquery.uniqueResult();
				Long totalPage=	(total-1)/pageSize+1;
				Page page=new Page();
				page.setPageNo(pageNo);
				page.setPageSize(pageSize);
				page.setTotal(total);
				page.setTotalpage(totalPage);
				page.setList(list);
				return page;
			}
		});
	}
	public Page  pageFind2(final String queryString,final String totalhql,final Integer pageSize,final Integer pageNo,final Object[] values){
		return this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Page>() {
			@Override
			public Page doInHibernate(Session session) throws HibernateException {
				Query queryObject = session.createQuery(queryString);
				Query totalquery = session.createQuery(totalhql);
				 
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						queryObject.setParameter(i, values[i]);
						totalquery.setParameter(i, values[i]);
					}
				}
				queryObject.setFirstResult((pageNo-1)*pageSize);
				queryObject.setMaxResults(pageSize);
				List list=queryObject.list();
				Long total=(Long) totalquery.uniqueResult();
				Long totalPage=	(total-1)/pageSize+1;
				Page page=new Page();
				page.setPageNo(pageNo);
				page.setPageSize(pageSize);
				page.setTotal(total);
				page.setTotalpage(totalPage);
				page.setList(list);
				return page;
			}
		});
	}
}
