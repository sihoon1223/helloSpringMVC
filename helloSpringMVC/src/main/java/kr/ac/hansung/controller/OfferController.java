package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;

import kr.ac.hansung.service.OfferService;


/* OfferController 클래스
 * OfferService를 주입받아 /offers 리퀘스트가 날아오면 showOffer메소드 실행 */

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model, @RequestParam(value="year") String year, @RequestParam(value="semester") String semester){
		List<Offer> offers = offerService.getOffers(Integer.parseInt(year), Integer.parseInt(semester));
		model.addAttribute("offers",offers);
		return "offers";
	}
	
	@RequestMapping("/offers_semester")
	public String showCurrentBySemester(Model model) {
	
		List<Offer> offers = offerService.getCurrentBySemester();
		model.addAttribute("offers", offers);
		
		return "offers_semester";
	}
	

	//수강신청 등록 조회
	@RequestMapping("/select_enrol")
	public String showOffersBySelect(Model model, @RequestParam(value="year") String year) {
	
		List<Offer> offers = offerService.getOfferSelected(Integer.parseInt(year));
		model.addAttribute("offers", offers);
		
		return "select_enrol";
	}

	
	@RequestMapping("/createoffer")
	public String doCreate(Model model, @Valid Offer offer, BindingResult result){
 		if(result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enrol";
		}
		offerService.insert(offer);
		model.addAttribute("success", "success");
		return "home";
	}
	
	
	@RequestMapping("/enrol")
	public String createOffers(Model model) {
		model.addAttribute("offer", new Offer());
		return "enrol";
	}
	

}

