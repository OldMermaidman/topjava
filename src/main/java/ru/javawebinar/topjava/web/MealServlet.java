package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private final static Logger log = getLogger(MealServlet.class);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'hh:mm");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        List<MealTo> mealsTo = MealsUtil.filteredByStreams(MealsUtil.getMeals());
        request.setAttribute("mealsTo", mealsTo);
        request.setAttribute("localDateTimeFormat", dtf);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
