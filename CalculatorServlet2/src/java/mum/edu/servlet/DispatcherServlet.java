package mum.edu.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.controller.IndexController;
import mum.edu.controller.InputCalcController;
//import mum.edu.controller.SaveProductController;
import mum.edu.controller.ResultController;

public class DispatcherServlet extends HttpServlet {
    
     @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) 
            throws IOException, ServletException {

        String uri = request.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /app10a/product_input. 
         * However, in the case of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex); 
        String dispatchUrl = null;
 
        if (action.equals("/")) {
        	IndexController controller = new IndexController();
        	dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("/calc")) {
        	InputCalcController controller = new InputCalcController();
        	dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("/result")) {
        	ResultController controller = new ResultController();
        	dispatchUrl = controller.handleRequest(request, response);
        }
 
         // forward to a view
        if (dispatchUrl != null) {
            RequestDispatcher requestDispatcher = 
                    request.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(request, response);
        }
    }
}
