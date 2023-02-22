package com.codegym.controller;

import com.codegym.model.dto.GlassesDTO;
import com.codegym.model.service.GlassesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "GlassesServlet", value = {"/" ,"/login", "/edit", "/delete", "/save"})
public class GlassesServlet extends HttpServlet {
    private GlassesService glassesService = new GlassesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        switch (action) {
            case "/":
            case "/login":
                request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
                break;
            case "/home":
                request.setAttribute("glassess", glassesService.findAll());
                request.getRequestDispatcher("/WEB-INF/view/glasses/list.jsp").forward(request, response);
                break;
            case "/edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                GlassesDTO glassesDTO = glassesService.findById(editId);
                request.setAttribute("glassesDTO", glassesDTO);
                request.getRequestDispatcher("/WEB-INF/view/glasses/edit.jsp").forward(request, response);
                break;
            case "/delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                GlassesDTO glassesDTOs = glassesService.findById(deleteId);
                request.setAttribute("glassesDTO", glassesDTOs);
                request.getRequestDispatcher("/WEB-INF/view/glasses/delete.jsp").forward(request, response);
                break;
            case "/save":
                request.getRequestDispatcher("/WEB-INF/view/glasses/save.jsp").forward(request, response);

            case "/error":
                request.getRequestDispatcher("/WEB-INF/view/glasses/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String action = request.getServletPath();
        switch (action) {
            case "/list":
                request.setAttribute("glassess", glassesService.findAll());
                request.getRequestDispatcher("/WEB-INF/view/glasses/list.jsp").forward(request, response);
                break;
            case "/edit":
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String brand = request.getParameter("brand");
                try {
                    glassesService.edit(id, new GlassesDTO(id, name, price, quantity, brand));
                    request.setAttribute("glassess", glassesService.findAll());
                    request.getRequestDispatcher("/WEB-INF/view/glasses/list.jsp").forward(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/delete":
                int removeId = Integer.parseInt(request.getParameter("id"));
                glassesService.remove(removeId);
                request.setAttribute("glassess", glassesService.findAll());
                request.getRequestDispatcher("/WEB-INF/view/glasses/list.jsp").forward(request, response);
                break;
            case "/save":
                String saveName = request.getParameter("name");
                double savePrice = Double.parseDouble(request.getParameter("price"));
                int saveQuantity = Integer.parseInt(request.getParameter("quantity"));
                String saveBrand = request.getParameter("brand");
                glassesService.save(new GlassesDTO( saveName, savePrice, saveQuantity, saveBrand));
//                response.sendRedirect("/");
                request.setAttribute("glassess", glassesService.findAll());
                request.getRequestDispatcher("/WEB-INF/view/glasses/list.jsp").forward(request, response);
                break;
        }
    }
}
