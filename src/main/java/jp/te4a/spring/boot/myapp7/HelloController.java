package jp.te4a.spring.boot.myapp7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	@Autowired
	BookService bookService;
	final String indexDirectory = "books/list";
	
	@RequestMapping(indexDirectory)
	public String Index(Model model) {
		model.addAttribute("msg", "this is setting message");
		return indexDirectory;
	}
	
	@PostMapping(value=indexDirectory)
	public ModelAndView postForm(
		@RequestParam("id") String id,
		@RequestParam("title") String title,
		@RequestParam("writter") String writter,
		@RequestParam("publisher") String publisher,
		@RequestParam("price") String price
	){
		ModelAndView mv = new ModelAndView(indexDirectory);
		bookService.save(
			new BookBean(
				Integer.valueOf(id),
				title,
				writter,
				publisher,
				Integer.valueOf(price)
			)
		);
		mv.addObject("books", bookService.findAll());
		return mv;
	}
}
