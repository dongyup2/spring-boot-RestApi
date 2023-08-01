package com.study.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.springboot.dao.IMemberDao;
import com.study.springboot.dto.MemberDto;


@RestController
@RequestMapping("/api")
public class RestApiController {
		
	@Autowired
	IMemberDao dao;
	// http://localhost:8090/api/members
	@GetMapping("/members")
	public String list() throws IOException {
	//public ResponseEntity<List<MemberDto>> list(){
		List<MemberDto> mlist = dao.list();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(mlist);
		// result.json 파일로 저장
		mapper.writeValue(new File("result.json"), mlist);
		
		// byte[] 로 저장
		byte[] jsonBytes = mapper.writeValueAsBytes(mlist);
		String data = new String(jsonBytes, "UTF-8");
		System.out.println("data : " + data);
		// string 으로 저장
		//return ResponseEntity.status(HttpStatus.OK).body(mlist);
		return data;//jsonString으로 보내도 같은 결과
	}
	// http://localhost:8090/api/member/1
	@GetMapping("/member/{mno}")
	public ResponseEntity<MemberDto> getMember(@PathVariable("mno") int mno){
		MemberDto member = dao.getMember(mno);
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	// http://localhost:8090/api/member
	@PostMapping("/member")
	public String regMember(@RequestBody MemberDto member) {
		System.out.println("post...");
		System.out.println(member);
		int result = dao.insert(member);
		String msg = "";
		if(result == 1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		return msg;
	}
	
	@PutMapping("/member")
	public String modifyMember(@RequestBody MemberDto member) {
		System.out.println(member);
		int result = dao.update(member);
		String msg = "";
		if(result == 1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		return msg;
	}
	
	@DeleteMapping("/member/{mno}")
	public String delMember(@PathVariable("mno") int mno) {
		int result = dao.delete(mno);
		String msg = "";
		if(result == 1) {
			msg = "success";
		}else {
			msg = "fail";
		}
		return msg;
	}
}
