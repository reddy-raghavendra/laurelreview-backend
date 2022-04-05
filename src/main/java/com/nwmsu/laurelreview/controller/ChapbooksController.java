
package com.nwmsu.laurelreview.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwmsu.laurelreview.model.ChapBook;
import com.nwmsu.laurelreview.repo.ChapBookRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("api")
public class ChapbooksController {
	private final ChapBookRepo chapBookRepo;

	@Autowired
	public ChapbooksController(final ChapBookRepo chapBookRepo) {
		this.chapBookRepo = chapBookRepo;
	}
	
	@GetMapping(value = "/chapbooks")
	public List<ChapBook> getposCasts(){
		return chapBookRepo.findAll();
	}
	
	@PostMapping(value = "/chapbook/save")
	public String saveChapBook(@RequestBody ChapBook chapbook) {
		chapBookRepo.save(chapbook);
		return "chapbook saved successfully";
	}
	
	@GetMapping(value = "/chapbook/{id}")
	public ChapBook getchapbookById(@PathVariable Long id) {
		return chapBookRepo.findById(id).get();
	}
	
	@PutMapping(value = "chapbook/update/{id}")
	public String updatechapbook(@PathVariable Long id,@RequestBody ChapBook updatedchapbook) {
		ChapBook chapbook = chapBookRepo.findById(id).orElse(null);
		if (chapbook == null) {
			return "chapbook with "+ id + " does not exist";
		}else {
			updatedchapbook.setchapBookId(id);
			BeanUtils.copyProperties(updatedchapbook, chapbook);
			this.saveChapBook(chapbook);
			return "chapbook updated";
		}
	}
	
	@DeleteMapping(value = "chapbook/delete/{id}")
	public String deletechapbook(@PathVariable Long id) {
		chapBookRepo.deleteById(id);
		return "Deleted Successfully";
	}
	

}
