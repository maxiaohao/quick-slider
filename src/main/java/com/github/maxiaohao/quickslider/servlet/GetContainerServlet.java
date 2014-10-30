package com.github.maxiaohao.quickslider.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.github.maxiaohao.quickslider.handler.PersistenceHandler;
import com.github.maxiaohao.quickslider.model.Container;
import com.github.maxiaohao.quickslider.util.JsonUtils;

/**
 * Servlet implementation class SliderReaderServlet
 */
public class GetContainerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContainerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");

        String containerId = request.getParameter("id");
        if (StringUtils.isNumeric(containerId)) {
            Container obj = PersistenceHandler.getInstance().getContainer(Integer.parseInt(containerId));
            if (null != obj) {
                try {
                    JsonUtils.writeAsJson(response.getWriter(), obj, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }

}
