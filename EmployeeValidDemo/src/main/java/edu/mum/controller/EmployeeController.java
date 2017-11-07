package edu.mum.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.Employee;
import edu.mum.exception.UnableToUploadFileException;

@Controller
public class EmployeeController {

	private static final Log logger = LogFactory.getLog(EmployeeController.class);

	@RequestMapping(value = { "/", "employee_input" })
	public String inputEmployee(@ModelAttribute("employee") Employee employee) {
		return "EmployeeForm";
	}

	@RequestMapping(value = "/employee_save")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "EmployeeForm";
		}

		String[] suppressedFields = bindingResult.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
					+ StringUtils.addStringToArray(suppressedFields, ", "));
		}
		
		if (employee.getImage().getSize() > 1024000) {
			throw new UnableToUploadFileException("Unable to upload files. File size is over 1024000 bytes");
		}

		MultipartFile image = employee.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (image != null && !image.isEmpty()) {
			try {
				// Window
				// image.transferTo(new File(rootDirectory + "images\\" + employee.getId() +
				// ".png"));
				// Mac
				image.transferTo(new File(rootDirectory + "/images/" + employee.getId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}

		

		// save product here
		model.addAttribute("employee", employee);

		return "EmployeeDetails";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setDisallowedFields(new String[]{"firstName"});
	}

//	@ExceptionHandler(UnableToUploadFileException.class)
//	public ModelAndView handleError(HttpServletRequest req, UnableToUploadFileException exception) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", exception.getMessage());
//		mav.addObject("exception", exception);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("unableToUploadFile");
//		return mav;
//	}
}
