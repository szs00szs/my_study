package cc.hansam.jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

@WebServlet("/testservlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		
		System.out.println("ajax请求中...");
	
		PrintWriter out = response.getWriter();
		
		List<String> list = new ArrayList<>();
		list.add(name);
		list.add(age);
		list.add(sex);
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		out.write(jsonString);
		
	
		out.flush();
		out.close();

	}

}
