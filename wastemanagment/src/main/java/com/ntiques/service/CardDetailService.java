package com.ntiques.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.CardDetailDaoImpl;
import com.ntiques.model.CardDetail;

@Service
@Transactional
public class CardDetailService 

{
	@Autowired (required=true)
	CardDetailDaoImpl CardDetailDao;
	public void saveOrUpdate(CardDetail carddetail)
	{
		CardDetailDao.saveOrUpdate(carddetail);
	}

}
