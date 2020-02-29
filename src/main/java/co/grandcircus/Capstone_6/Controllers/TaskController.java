package co.grandcircus.Capstone_6.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.Capstone_6.Entities.Task;
import co.grandcircus.Capstone_6.Entities.User;
import co.grandcircus.Capstone_6.Repos.TaskRepo;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepo tRepo;

	@Autowired
	private HttpSession sesh;

	@RequestMapping("/")
	public ModelAndView taskList() {
		User user = (User) sesh.getAttribute("user");
		List<Task> taskList = tRepo.findByUserId(user.getId());
		return new ModelAndView("tasks/tasks", "tasks", taskList);

	}

	@RequestMapping("/add")
	public ModelAndView addTask() {
		User user = (User) sesh.getAttribute("user");
		ModelAndView mav = new ModelAndView("tasks/editTask");
		mav.addObject("user", user);
		mav.addObject("CRUD", "Add");
		return mav;
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editTask(@PathVariable("id") Task task) {
		User user = (User) sesh.getAttribute("user");
		if(user.getId() != task.getUser().getId()) {
			// If loggedin user is not the owner of the task
			return new ModelAndView("tasks/tasks", "message", "Unable to edit task.");
		}
		ModelAndView mav = new ModelAndView("tasks/editTask");
		mav.addObject("user", user);
		mav.addObject("task", task);
		mav.addObject("CRUD", "Edit");
		return mav;
	}

	@PostMapping("/post/{crud}")
	public ModelAndView postTask(
			Task task,
			@PathVariable("crud") String crud,
			RedirectAttributes redir) {
		
		if (crud.equals("add")) {
			tRepo.save(task);
		} else {
			tRepo.save(task);
		}

		crud = crud.toLowerCase() + "ed";
		redir.addFlashAttribute("message", "<h4 class=\"text-success\">Task " + crud + " successfully.</h4>");
		return new ModelAndView("redirect:/tasks/");
	}
	
	@RequestMapping("/{id}/delete")
	public ModelAndView deleteTask(@PathVariable("id") Task task, RedirectAttributes redir){
		User user = (User) sesh.getAttribute("user");
		if(user.getId() != task.getUser().getId()) {
			// If loggedin user is not the owner of the task
			return new ModelAndView("tasks/tasks", "message", "<h4 class=\"text-danger\">Unable to edit task.</h4>");
		}
		tRepo.delete(task);
		redir.addFlashAttribute("message", "Task successfully deleted.");
		return new ModelAndView("redirect:/tasks/");
	}
}
