package com.example.polkadanawa.Controller;

import com.example.polkadanawa.Model.User;
import com.example.polkadanawa.Service.LaborerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laborers")
public class LaborerController {

    @Autowired
    private LaborerService laborerService;

    // Register a laborer
    @PostMapping("/register")
    public User registerLaborer(@RequestBody User user, @RequestParam String jobCategory) {
        return laborerService.registerLaborer(user, jobCategory);
    }

    // Get all laborers by category
    @GetMapping("/category")
    public List<User> getLaborersByCategory(@RequestParam String jobCategory) {
        return laborerService.getLaborersByCategory(jobCategory);
    }

    // Delete laborer from a category
    @DeleteMapping("/{userId}")
    public void deleteLaborerFromCategory(@PathVariable String userId, @RequestParam String jobCategory) {
        laborerService.deleteLaborerFromCategory(userId, jobCategory);
    }
}
