package edu.mum.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(UnableToUploadFileException.class)
	public ModelAndView handleError(HttpServletRequest req, UnableToUploadFileException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", exception.getMessage());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("showException");
		return mav;
	}
	
	@ExceptionHandler(org.springframework.web.multipart.MaxUploadSizeExceededException.class)
	public ModelAndView handleErrorMaxUpload(HttpServletRequest req, org.springframework.web.multipart.MaxUploadSizeExceededException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", exception.getMessage());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("showException");
		return mav;
	}
}