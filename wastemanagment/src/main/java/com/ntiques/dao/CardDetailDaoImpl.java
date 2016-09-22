package com.ntiques.dao;


	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.ntiques.dao.CardDetailDao;
	import com.ntiques.model.CardDetail;

	@Repository
	public class CardDetailDaoImpl implements CardDetailDao {

		@Autowired (required=true)
		private SessionFactory sessionFactory;

		public CardDetailDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
		
		
		public void saveOrUpdate(CardDetail cardDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(cardDetail);

		}

	}



