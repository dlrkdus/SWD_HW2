package com.example.helloworld.web;

import java.util.Calendar;

import com.example.helloworld.domain.PerformRequest;
import com.example.helloworld.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.springidol.SpringIdol;

@RequestMapping("/helloSpringIdol")
@Controller
public class HelloController {
	
	@Autowired
	public HelloController(SpringIdol springIdol) {
		springIdol.run();
	}
	@Autowired
	HelloService helloService;
	
	@RequestMapping("/hello.do")		// request handler method
	public ModelAndView hello(
		@RequestParam(value="name", required=false) String name) {

		String greeting = helloService.getGreeting();
		if (name != null) greeting = greeting + name;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("greeting", greeting);
		return mav;
	}
	@GetMapping("/perform")
	public String helloAndPerform1(@RequestParam String id, @RequestParam String requester){
		String greeting = helloService.getGreeting();
		String performance=null;
		if (id != null) {
			greeting = greeting + id;
			performance = helloService.makePerformance(id);
		}
		// ModelAndView 객체를 생성하여 뷰 이름과 모델 데이터를 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance",performance);
		return "perform";
	}

	@GetMapping("/perform/{id}/requester/{requester}")
	public String helloAndPerform2(@PathVariable String id, @PathVariable String requester){
		String greeting = helloService.getGreeting();
		String performance=null;
		if (id != null) {
			greeting = greeting + id;
			performance = helloService.makePerformance(id);
		}
		// ModelAndView 객체를 생성하여 뷰 이름과 모델 데이터를 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance",performance);
		return "perform";
	}

	@PostMapping("/performUsingComm")
	public String helloAndPerformUsingComm(@RequestBody PerformRequest request){

		// PerformRequest 객체를 통해 id와 requester를 전송받음
		String id = request.getId();
		String requester = request.getRequester();

		String greeting = helloService.getGreeting() + " " + requester;
		String performance = helloService.makePerformance(id);

		// ModelAndView 객체를 생성하여 뷰 이름과 모델 데이터를 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("perform");
		mav.addObject("greeting", greeting);
		mav.addObject("performance", performance);

		// ModelAndView 객체를 반환
		return "perform";
	}


}
