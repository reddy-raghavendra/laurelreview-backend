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

import com.nwmsu.laurelreview.model.PodCast;
import com.nwmsu.laurelreview.repo.PodCastRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("api")
public class PodCastController {
	private final PodCastRepo podcastRepo;

	@Autowired
	public PodCastController(final PodCastRepo podcastRepo) {
		this.podcastRepo = podcastRepo;
	}
	
	@GetMapping(value = "/podcasts")
	public List<PodCast> getposCasts(){
		return podcastRepo.findAll();
	}
	
	@PostMapping(value = "/podcast/save")
	public String savePoscast(@RequestBody PodCast podcast) {
		podcastRepo.save(podcast);
		return "podcast saved successfully";
	}
	
	@GetMapping(value = "/podcast/{id}")
	public PodCast getPodCastById(@PathVariable Long id) {
		return podcastRepo.findById(id).get();
	}
	
	@PutMapping(value = "podcast/update/{id}")
	public String updatePodcast(@PathVariable Long id,@RequestBody PodCast updatedPodCast) {
		PodCast podcast = podcastRepo.findById(id).orElse(null);
		if (podcast == null) {
			return "Podcast with "+ id + " does not exist";
		}else {
			updatedPodCast.setPodcastId(id);
			BeanUtils.copyProperties(updatedPodCast, podcast);
			this.savePoscast(podcast);
			return "Podcast updated";
		}
	}
	
	@DeleteMapping(value = "podcast/delete/{id}")
	public String deletePodcast(@PathVariable Long id) {
		podcastRepo.deleteById(id);
		return "Deleted Successfully";
	}
	

}
