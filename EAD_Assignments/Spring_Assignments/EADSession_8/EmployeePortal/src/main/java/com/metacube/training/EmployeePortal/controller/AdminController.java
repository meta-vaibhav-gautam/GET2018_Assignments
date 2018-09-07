package com.metacube.training.EmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortal.model.JobTitleMaster;
import com.metacube.training.EmployeePortal.model.Project;
import com.metacube.training.EmployeePortal.model.SkillMaster;
import com.metacube.training.EmployeePortal.service.JobTitleMasterService;
import com.metacube.training.EmployeePortal.service.ProjectService;
import com.metacube.training.EmployeePortal.service.SkillMasterService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private JobTitleMasterService jobTitleMasterService;
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getProjectId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("projectId") int projectId) {
		model.addAttribute("project", projectService.getProjectById(projectId));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("projectId") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skillMaster", new SkillMaster());
		return "admin/editSkill";
	}
	
	@RequestMapping(path = "/skills/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("skillId") int skillId) {
		model.addAttribute("skillMaster", skillMasterService.getSkillById(skillId));
		return "admin/editSkill";
	}
	
	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skillMaster") SkillMaster skillMaster) {
		if(skillMaster!= null && skillMaster.getSkillId() == 0) {
			skillMasterService.createSkill(skillMaster);	
		}else {
			skillMasterService.updateSkill(skillMaster);
		}
		return "redirect:/admin/skills";
	}
	
	@RequestMapping(path = "/skills" , method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skillMaster",skillMasterService.getAllSkills());
		return "admin/skills";
	}
	
	@RequestMapping(path = "/skills/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("skillId") int id) {
		skillMasterService.deleteSkill(id);
		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/Jobtitles/add", method = RequestMethod.GET)
	public String createJobTitleMaster(Model model) {
		model.addAttribute("jobTitleMaster", new JobTitleMaster());
		return "admin/JobTitles";
	}
	
	@RequestMapping(path = "/JobTitles/edit", method = RequestMethod.GET)
	public String editJobTitleMaster(Model model, @RequestParam("job_code") int job_code) {
		model.addAttribute("jobTitleMaster", jobTitleMasterService.getJobTitleMaterById(job_code));
		return "admin/JobTitles";
	}
	
	@RequestMapping(path = "/Jobtitles", method = RequestMethod.POST)
	public String saveJobTitleMaster(@ModelAttribute("jobTitleMaster") JobTitleMaster jobTitleMaster) {
		jobTitleMasterService.createJobTitleMaster(jobTitleMaster);
		return "redirect:/admin/JobTitles";
	}
	
}
