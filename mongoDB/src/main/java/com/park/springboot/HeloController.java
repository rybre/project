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
		mav.addObject("title", "학점 입력");
		mav.addObject("msg", "학점을 입력해주세요");

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
			@RequestParam("UI") double UI, 
			@RequestParam("Culture") double Culture,
			@RequestParam("Capstone") double Capstone, 
			@RequestParam("Jquery") double Jquery, 
			@RequestParam("Pass") double Pass,
			@RequestParam("Mento") double Mento, 
			@RequestParam("Smart1") double Smart1, 
			@RequestParam("Smart2") double Smart2,
			@RequestParam("Jsp") double Jsp, 
			@RequestParam("Linux") double Linux,
			@RequestParam("Sum") int Sum,

			ModelAndView mov) 
	{
		MyDataMongo mydata = new MyDataMongo(name, code, UI, Culture, Capstone, Jquery, Pass, Mento, Smart1, Smart2, Jsp, Linux, Sum);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}

	/**
	 *
	 * @fn 		public ModelAndView detail(ModelAndView mav)
	 * 
	 * @brief 	상세 조회 페이지
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 출력
	 *
	 */
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");
		mav.addObject("title", "Detail Page");
		mav.addObject("msg", "상세 조회 및 수정 삭제");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView removecheck(ModelAndView mav)
	 * 
	 * @brief 	삭제 유무 확인페이지
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 삭제 유무 확인페이지 출력
	 *
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView removecheck(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "Delete Page");
		mav.addObject("msg", "삭제 유무 확인");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView remove(ModelAndView mav)
	 * 
	 * @brief 	데이터 삭제
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	deleteBy 를 이용한 데이터 조건삭제
	 *
	 */
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView remove(@RequestParam("id") String id, ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}

	/**
	 *
	 * @fn 		public ModelAndView edit(ModelAndView mav)
	 * 
	 * @brief 	수정페이지
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy를 이용해 조건에 충족되는 데이터를 List에 저장 후 화면에 표시
	 *
	 */
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id, ModelAndView mav) {
		
		mav.setViewName("edit");
		mav.addObject("title", "Edit Page");
		mav.addObject("msg", "수정할 데이터를 입력해주세요.");
		
		List<MyDataMongo> list = repository.findById(id);
		
		mav.addObject("datalist", list);
		return mav;
	}

	
	/**
	 *
	 * @fn 		public ModelAndView editpost(ModelAndView mav)
	 * 
	 * @brief 	데이터 수정
	 *
	 * @author 	박범찬
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장	
	 *		   	save 메소드를 이용해 DB에 저장		
	 *			deleteBy를 이용해 이전데이터 삭제	
	 *
	 */
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editpost(
			@RequestParam("id") String id, 
			@RequestParam("code") String code, 
			@RequestParam("name") String name,
			@RequestParam("UI") double UI, 
			@RequestParam("Culture") double Culture,
			@RequestParam("Capstone") double Capstone, 
			@RequestParam("Jquery") double Jquery, 
			@RequestParam("Pass") double Pass,
			@RequestParam("Mento") double Mento, 
			@RequestParam("Smart1") double Smart1, 
			@RequestParam("Smart2") double Smart2,
			@RequestParam("Jsp") double Jsp, 
			@RequestParam("Linux") double Linux,
			@RequestParam("Sum") int Sum,
			
			ModelAndView mov) 

	{
		MyDataMongo mydata = new MyDataMongo(name, code, UI, Culture, Capstone, Jquery, Pass, Mento, Smart1, Smart2, Jsp, Linux, Sum);
		repository.save(mydata);
		repository.deleteById(id);
		
		return new ModelAndView("redirect:/");
	}

}
