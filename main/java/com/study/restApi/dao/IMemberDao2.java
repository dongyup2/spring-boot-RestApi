package com.study.restApi.dao;

import java.util.List;  

import org.apache.ibatis.annotations.Mapper;

import com.study.restApi.dto.MemberDto2;

@Mapper
public interface IMemberDao2 {
	public List<MemberDto2> findAll();//get 
	public MemberDto2 findById(int id);//get
	public int insert(MemberDto2 member); //post
	public int update(MemberDto2 member); //put
	public int update2(MemberDto2 member);
	public int delete(int id);//delete
}
