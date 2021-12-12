package com.my.mmy.lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LostController {
	@Autowired
	LostService lostService;
	
	@RequestMapping(value = "/lost/list", method=RequestMethod.GET)
	public String lostlist(Model model) {
		model.addAttribute("list", lostService.getLostList());
		return "posts";
	}
	
	@RequestMapping(value = "/lost/add", method=RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value = "/lost/addok", method=RequestMethod.GET)
	public String addPostOK(LostVO vo) {
		int i = lostService.insertLost(vo);
		if (i == 0)
			System.out.println("데이터 추가 실패!");
		else
			System.out.println("데이터 추가 성공!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/lost/editpost/{id}", method=RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		LostVO lostVO = lostService.getLost(id);
		model.addAttribute("lostVO", lostVO);
		return "editform";
	}
	
	@RequestMapping(value = "/lost/editok", method=RequestMethod.GET)
	public String editPostOK(LostVO vo) {
		int i = lostService.updateLost(vo);
		if (i == 0)
			System.out.println("데이터 수정 실패!");
		else
			System.out.println("데이터 수정 성공!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/lost/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		int i = lostService.deleteLost(id);
		if (i == 0)
			System.out.println("데이터 삭제 실패!");
		else
			System.out.println("데이터 삭제 성공!");
		return "redirect:list";
	}
}
