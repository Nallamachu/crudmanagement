package com.spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.beans.DictionarySearch;

@Repository("searchDAO")
public class WarpSearchDaoImpl implements WarpSearchDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<DictionarySearch> getAllData() {
		Session session = sessionFactory.openSession();
		List<DictionarySearch> list = null;
		try {
			list = session.createQuery("from DictionarySearch").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public DictionarySearch getDataById(int id) {
		Session session = sessionFactory.openSession();
		DictionarySearch searchData = null;
		String inputQuery = "from DictionarySearch where id="+id;
		try {
			searchData = (DictionarySearch) session.createQuery(inputQuery).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return searchData;
	}

	@Override
	public void saveData(DictionarySearch search) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.save(search);
			tx.commit();
			System.out.println("Record Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void updateData(DictionarySearch search) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			session.update(search);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDataById(int id) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			DictionarySearch searchData = (DictionarySearch) session.get(DictionarySearch.class, id);
			session.delete(searchData);
			tx.commit();
			System.out.println(id);
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.flush();
			session.close();
		}
	}

}
