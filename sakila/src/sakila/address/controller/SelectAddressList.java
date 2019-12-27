package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Address;
import sakila.address.model.AddressDao;

/**
 * Servlet implementation class SelectAddressList
 */
@WebServlet("/selectAddressList")
public class SelectAddressList extends HttpServlet {
	private AddressDao addressDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("apllication/json;charset=UTF-8");
		System.out.println("address/selectAddressList");
		
		//모든 주소목록을 가져온다.
		//주소 목록은 AddressDao 에서 처리한다.
		addressDao = new AddressDao();
		List <Address> list = addressDao.selectAddressList();
		//확인 코드
		System.out.println("Servlet list: "+list);
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);	//json타입으로 변환
		System.out.println("jsonList: "+jsonList);
		response.getWriter().write(jsonList);	//요청을 
	}

}
