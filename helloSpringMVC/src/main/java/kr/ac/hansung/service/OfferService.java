package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.OfferDAO;
import kr.ac.hansung.model.Offer;

@Service
public class OfferService {
	
	@Autowired
	private OfferDAO offerDao;
	
	public List<Offer> getCurrentBySemester(){
		return offerDao.getCurrentBySemester();
	}
	
	//레코드 삽입
	public void insert(Offer offer) {
		offerDao.insert(offer);
		
	}
	
	public List<Offer> getOffers(int year, int semester){
		return offerDao.getOffers(year, semester);
	}
	
	
	public List<Offer> getOfferSelected(int year){
		return offerDao.getOfferSelected(year);
	}
}
