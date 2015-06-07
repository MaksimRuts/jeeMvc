package by.gsu.epamlab.controller;

import by.gsu.epamlab.logic.MathLogic;
import by.gsu.epamlab.logic.MathOperations;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public class StartController extends HttpServlet {

    private String[] numbers;
    private String control;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        readProperties(config);
    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("".equals(action) || action == null) {
            req.setAttribute(Constants.KEY_NUMBERS, numbers);
            req.setAttribute(Constants.KEY_CONTROL, control);
            getServletContext().getRequestDispatcher(Constants.JUMP_START).forward(req, resp);
        } else {
            String[] params = req.getParameterValues(Constants.CHECKBOX_NAME);
            double result = 0;
            if (params != null) {
                double[] arr = new double[params.length];
                for (int i = 0; i < params.length; i++) {
                    arr[i] = Double.parseDouble(req.getParameter(params[i]));
                }
                result = MathLogic.executeOperation(arr, MathOperations.valueOf(action));
            }

            req.setAttribute(Constants.RESULT_VALUE, result);
            getServletContext().getRequestDispatcher(Constants.JUMP_RESULT).forward(req, resp);
        }
    }

    private void readProperties(ServletConfig config) {
        String filename = config.getInitParameter(Constants.FILENAME);
        ResourceBundle bundle = ResourceBundle.getBundle(filename);
        if (bundle.containsKey(Constants.KEY_NUMBERS)) {
            numbers = bundle.getString(Constants.KEY_NUMBERS).split(Constants.NUMBERS_SEPARATOR);
        }
        if (bundle.containsKey(Constants.KEY_CONTROL)) {
            control = bundle.getString(Constants.KEY_CONTROL);
        }
    }
}
