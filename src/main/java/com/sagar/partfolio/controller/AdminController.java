package com.sagar.partfolio.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static final List<String> skills = new ArrayList<>(
        List.of("Java", "Spring Boot", "Hibernate")
    );

    private static final List<Map<String, String>> projects = new ArrayList<>(
        List.of(
            new HashMap<>(Map.of("title", "HRMS System", "description", "HR system")),
            new HashMap<>(Map.of("title", "Building Control System", "description", "Automation system"))
        )
    );

    private static Map<String, String> profile = new HashMap<>(Map.of(
        "name", "Sagar Dixit",
        "title", "Software Engineer",
        "about", "Passionate developer",
        "email", "mrsagardixit@gmail.com",
        "github", "https://github.com/sagbhu",
        "linkedin", "https://linkedin.com/in/sagar-dixit"
    ));
    
    private static final String ADMIN_PASSWORD = "sagar@admin123";

    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String,String> body) {
        String pass = body.get("password");
        
        if(ADMIN_PASSWORD.equals(pass)) {
            return Map.of("success", true);
        }
        return Map.of("success", false);
    }

    @GetMapping("/data")
    public Map<String, Object> getAll() {
        return Map.of(
            "profile", profile,
            "skills", skills,
            "projects", projects
        );
    }

    @PostMapping("/skill")
    public void addSkill(@RequestBody Map<String, String> data) {
        skills.add(data.get("name"));
    }

    @DeleteMapping("/skill/{index}")
    public void deleteSkill(@PathVariable int index) {
        if (index >= 0 && index < skills.size()) {
            skills.remove(index);
        }
    }

    @PostMapping("/skills/reorder")
    public void reorderSkills(@RequestBody List<String> newOrder) {
        skills.clear();
        skills.addAll(newOrder);
    }

    @PostMapping("/project")
    public void addProject(@RequestBody Map<String, String> data) {
        projects.add(Map.of(
            "title", data.get("title"),
            "description", data.get("description")
        ));
    }

    @DeleteMapping("/project/{index}")
    public void deleteProject(@PathVariable int index) {
        if (index >= 0 && index < projects.size()) {
            projects.remove(index);
        }
    }

    @PostMapping("/projects/reorder")
    public void reorderProjects(@RequestBody List<Map<String, String>> newOrder) {
        projects.clear();
        projects.addAll(newOrder);
    }

    @PostMapping("/profile/save")
    public void saveProfile(@RequestBody Map<String, String> data) {
    	profile.clear();
    	profile=Map.of(
        		"name", data.get("name")!=null?data.get("name"):"",
                "title", data.get("title"),
                "about", data.get("about"),
                "email", data.get("email"),
                "github", data.get("github"),
                "linkedin", data.get("linkedin")
            );
    }
    
    public static Map<String, Object> getAllStatic() {
        return Map.of(
            "name", profile.get("name"),
            "title", profile.get("title"),
            "about", profile.get("about"),
            "email", profile.get("email"),
            "github", profile.get("github"),
            "linkedin", profile.get("linkedin"),
            "skills", skills,
            "projects", projects
        );
    }
}
