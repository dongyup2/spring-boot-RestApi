package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.springboot.dao.IMemberDao;
import com.study.springboot.dto.MemberDto;


@Controller
//@RequestMapping("/")
public class MyController {
	
	@Autowired
	IMemberDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "main2";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws JsonProcessingException {
		List<MemberDto> list = dao.list();
		ObjectMapper mapper = new ObjectMapper();
		// string 으로 저장
		String jsonString = mapper.writeValueAsString(list);
		model.addAttribute("list", jsonString);
		
		return "list";
	}
	
	
}
