package com.example.demo.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.notes.model.ClassNotes;
import com.example.demo.notes.service.NotesService;

@RestController
public class NotesController {
	@Autowired
	private NotesService service;
	@PostMapping("/addnotes")
	public ClassNotes addNotes(@RequestBody ClassNotes classnotes ) {
		return service.saveNotes(classnotes);
		
	}
	@GetMapping("/notesall")
	public List<ClassNotes> findAllProducts(){
		return service.getNotes();
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteNotes(id);
		
	}
	@PutMapping("/update")
	public ClassNotes updateNotes(@RequestBody ClassNotes classnotes) {
		return service.updateNotes(classnotes);
		
	}

}
