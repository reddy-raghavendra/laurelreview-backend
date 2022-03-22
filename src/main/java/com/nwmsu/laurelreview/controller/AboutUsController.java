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
import com.nwmsu.laurelreview.model.AboutUs;
import com.nwmsu.laurelreview.repo.AboutUsRepo;
import ch.qos.logback.core.joran.util.beans.BeanUtil;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping("api")
public class AboutUsController {
    private final AboutUsRepo AboutUsRepo;

    @Autowired
    public AboutUsController(final AboutUsRepo AboutUsRepo) {
        this.AboutUsRepo = AboutUsRepo;
    }

    @GetMapping(value = "/AboutUs")
    public List<AboutUs> getposCasts() {
        return AboutUsRepo.findAll();
    }

    @PostMapping(value = "/AboutUs/save")
    public String saveAboutUs(@RequestBody AboutUs AboutUs) {
        AboutUsRepo.save(AboutUs);
        return "AboutUs saved successfully";
    }

    @GetMapping(value = "/AboutUs/{id}")
    public AboutUs getPodCastById(@PathVariable Long id) {
        return AboutUsRepo.findById(id).get();
    }

    @PutMapping(value = "AboutUs/update/{id}")
    public String updateAboutUs(@PathVariable Long id, @RequestBody AboutUs updatedAboutUs) {
        AboutUs AboutUs = AboutUsRepo.findById(id).orElse(null);
        if (AboutUs == null) {
            return "AboutUs with " + id + " does not exist";
        } else {
            updatedAboutUs.setAboutUsId(id);
            BeanUtils.copyProperties(updatedAboutUs, AboutUs);
            this.saveAboutUs(AboutUs);
            return "AboutUs updated";
        }
    }

    @DeleteMapping(value = "AboutUs/delete/{id}")
    public String deletePodcast(@PathVariable Long id) {
        AboutUsRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
