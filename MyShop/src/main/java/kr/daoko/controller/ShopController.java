package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.MemberVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.domain.ReplyVO;
import kr.daoko.service.ShopService;

@Controller
@RequestMapping("/shop/**")
public class ShopController {
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	ShopService service;
	
	// 카테고리별 상품 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") String cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("get list");
		
		List<GoodsViewVO> list = null;
		list = service.list(cateCode, level);
		
		model.addAttribute("list", list);
	}

	// 상품 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") String gdsCode, Model model) throws Exception {
		logger.info("get view");
		
		GoodsViewVO view = service.goodsView(gdsCode);
		model.addAttribute("view", view);
		
		List<ReplyListVO> reply = service.replyList(gdsCode);
		model.addAttribute("reply", reply);
	}
	
	// 상품 조회 내 소감(댓글) 작성
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String registReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("post view regist reply");

		MemberVO member = (MemberVO)session.getAttribute("member");
		reply.setUserId(member.getUserId());
		
		service.registReply(reply);
		
		return "redirect:/shop/view?n=" + reply.getGdsCode();
	}
}
