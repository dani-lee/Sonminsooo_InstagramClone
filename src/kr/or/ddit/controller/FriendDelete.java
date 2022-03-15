package kr.or.ddit.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.FollowVO;
import kr.or.ddit.vo.FriendsVO;
import kr.or.ddit.vo.OptionVO;

/**
 * Servlet implementation class FriendDelete
 */
@WebServlet("/FriendDelete.do")
public class FriendDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		FollowVO vo = new FollowVO();

		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 1. service객체 얻기
		IMemberService service = MemberServiceImpl.getService();

		// 2. service메소드 호출하기 : 결과값 받기
		int cnt = 0;
			cnt = service.friendDelete(vo);


		// 3. 결과값을 request에 저장
		request.setAttribute("count", cnt);

		// 4. jsp로 forward : 1005/idcheck.jsp

		request.getRequestDispatcher("/sonminsooo/jsp/result.jsp").forward(request, response);
	}

}
