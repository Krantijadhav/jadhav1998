package com.grid.dynamic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grid.dynamic.Entity.Student;
import com.grid.dynamic.Repository.StudentRepo;


@Service

public class StudentService {
	
	@Autowired
	private StudentRepo repo;

	
	public void addRecord(Student p)
	{
		repo.save(p);
	}
	
	public List<Student> getAllPrn()
	{
		return repo.findAll();
	}

	public Student getPrnById(long id)
	{
	Optional<Student> p=repo.findById(id);
	if(p.isPresent())
	{
		return p.get();
	}
	return null;
}	
	public void deletePrn(long id) {
		repo.deleteById(id);
	}
}
