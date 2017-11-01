package mum.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
		return "/WEB-INF/jsp/index.jsp";
	}
}
