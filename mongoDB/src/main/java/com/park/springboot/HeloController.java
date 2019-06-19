package com.park.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.park.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataMongoRepository repository;
	
	/**
	 *
	 * @fn 		public ModelAndView index(ModelAndView mav)
	 * 
	 * @brief 	메인 페이지 설정 
	 *
	 * @author 	박범찬	
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");
		mav.addObject("title", "학점 평균 계산기");
		mav.addObject("msg", "학점 평균을 입력해주세요.");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		mav.addObject("title", "성적 입력");
		mav.addObject("msg", "성적을 입력해주세요");

		return mav;
	}
		
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장	
	 *		   	save 메소드를 이용해 DB에 저장			
	 *
	 */
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("code") String code, 
			@RequestParam("name") String name,
			@RequestParam("UI") int UI, 
			@RequestParam("Culture") int Culture,
			@RequestParam("Capstone") int Capstone, 
			@RequestParam("Jquery") int Jquery, 
			@RequestParam("Pass") int Pass,
			@RequestParam("Mento") int Mento, 
			@RequestParam("Smart1") int Smart1, 
			@RequestParam("Smart2") int Smart2,
			@RequestParam("Jsp") int Jsp, 
			@RequestParam("Linux") int Linux, 

			ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, code, UI, Capstone, Jquery, Pass, Mento, Smart1, Smart2, Jsp, Linux);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}

