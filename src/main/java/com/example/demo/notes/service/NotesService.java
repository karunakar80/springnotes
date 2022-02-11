package com.example.demo.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.notes.model.ClassNotes;
import com.example.demo.notes.repository.NotesRepository;

@Service
public class NotesService {
	@Autowired
	private NotesRepository repo;
	
	public ClassNotes saveNotes(ClassNotes classnotes) {
		return repo.save(classnotes);
		
	}
	public List<ClassNotes> getNotes(){
		return repo.findAll();
		
	}
	public String deleteNotes(int id) {
		repo.deleteById(id);
		return "product repository !!"+id;
		
	}
	public ClassNotes updateNotes(ClassNotes classnotes) {
		ClassNotes existingnotes=repo.findById(classnotes.getId()).orElse(null);
		existingnotes.setNotes(classnotes.getNotes());
		return repo.save(existingnotes);
		
	}
	
}
