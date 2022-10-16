package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageDTO;
import com.board.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model){
		log.info("ctl list");
		model.addAttribute("list" , service.getList(cri));
		
		// 페이지당 10개의 데이터 정의(cri객체) , 데이터 수를 123개 정의(total) 를 담은 pageDTO객체를 pageMaker라는 이름으로 view에 전달
		// model.addAttribute("pageMaker" , new PageDTO(cri, 123));
		
		int total = service.getTotal(cri);
	
		log.info("total:" + total);
		
		model.addAttribute("pageMaker" , new PageDTO(cri, total));
	}
	
	@GetMapping("/register")
	public void register(){
		log.info("ctl register");
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr){
		
		log.info("register:" + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
	}

	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri){
		
		log.info("/get or /modify");
		model.addAttribute("board", service.get(bno));
	}
	
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri){
		log.info("modify:" + board);
		
		if(service.modify(board)){
			rttr.addFlashAttribute("result" , "success");
		}

		//Criteria 클래스에서 UriComponentsBuilder를 사용하면 일일이 파라미터 값을 유지할 필요가 없다.
		/*
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
		*/
		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri){
		
		log.info("remove..." + bno);
		
		if(service.remove(bno)){
			rttr.addFlashAttribute("result","success");
		}
		
		//Criteria 클래스에서 UriComponentsBuilder를 사용하면 일일이 파라미터 값을 유지할 필요가 없다.
		/*
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
		*/		
		return "redirect:/board/list" + cri.getListLink();
	}
	
	

}
