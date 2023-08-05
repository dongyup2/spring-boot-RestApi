package com.study.restApi.controller;

import com.study.restApi.dao.IMemberDao2;
import com.study.restApi.dto.MemberDto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    @Autowired
    private IMemberDao2 memberDao;

    @GetMapping("/members")
    public List<MemberDto2> getAllMembers() {
        return memberDao.findAll();
    }

    @GetMapping("/member/{id}")
    public MemberDto2 getMemberById(@PathVariable int id) {
        return memberDao.findById(id);
    }

    @PostMapping("/member") //@RequestBody를 하게되면 json으로 body에서 보낸다.
    public int createMember(@RequestBody MemberDto2 member) {
        return memberDao.insert(member);
    }

    @PutMapping("/update/{id}")// @PathVariable int id 동적인 변수값으로 사용해라 라는뜻
    public int updateMember(@PathVariable int id, @RequestBody MemberDto2 member) {
        member.setId(id);
        return memberDao.update(member);
    }
    
    @PutMapping("/member/{name}")//하지만 name이 이미 set으로 설정됐으므로 name은 그대로 유지된다
    public int updateMember2(@PathVariable String name, @RequestBody MemberDto2 member) {
    	member.setName(name);
    	return memberDao.update2(member);
    }
    @PutMapping("/member")//하지만 name이 이미 set으로 설정됐으므로 name은 그대로 유지된다
    public int updateMember2( @RequestBody MemberDto2 member) {
    	return memberDao.update2(member);
    }
	/*
	 * @PutMapping("/update2/{oldName}/{newName}") public int
	 * updateMember2(@PathVariable String oldName, @PathVariable String
	 * newName, @RequestBody MemberDto member) { member.setName(oldName); return
	 * memberDao.update2(member, newName); }
	 */
    
    @DeleteMapping("/member/{id}")
    public int deleteMember(@PathVariable int id) {
        return memberDao.delete(id);
    }
}
