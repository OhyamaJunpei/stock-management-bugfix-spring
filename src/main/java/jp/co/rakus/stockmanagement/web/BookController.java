package jp.co.rakus.stockmanagement.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.service.BookService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 書籍関連処理を行うコントローラー.
 * @author igamasayuki
 *
 */
@Controller
@RequestMapping("/book")
@Transactional
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ServletContext application;
	
	/**
	 * フォームを初期化します.
	 * @return フォーム
	 */
	@ModelAttribute
	public BookForm setUpForm() {
		return new BookForm();
	}
	
	@ModelAttribute
	public RegisterBookForm setUpRegisterBookForm() {
		return new RegisterBookForm();
	}
	
	/**
	 * 書籍リスト情報を取得し書籍リスト画面を表示します.
	 * @param model モデル
	 * @return 書籍リスト表示画面
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "book/list";
	}
	
	/**
	 * 書籍詳細情報を取得し書籍詳細画面を表示します.
	 * @param id 書籍ID
	 * @param model　モデル
	 * @return　書籍詳細画面
	 */
	@RequestMapping(value = "show/{bookId}")
	public String show(@PathVariable("bookId") Integer id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book/show";
	}
	
	/**
	 * 書籍更新を行います.
	 * @param form フォーム
	 * @param result リザルト情報
	 * @param model　モデル
	 * @return　書籍リスト画面
	 */
	@RequestMapping(value = "update")
	public String update(@Validated BookForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return show(form.getId(), model);
		}
		Book book = bookService.findOne(form.getId());
		book.setStock(form.getStock());
		bookService.update(book);
		return list(model);
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/book/regist";
	}
	
	@RequestMapping("/regist")
	public String regist(@Validated RegisterBookForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return form();
		}
		
		Book book = new Book();
		BeanUtils.copyProperties(form, book);
		
		//imageFileにformで受け取った画像ファイルを入れる
		MultipartFile imageFile = form.getImageFile();
		String filename = imageFile.getOriginalFilename();
		
		try {
			//仮想パスをシステム上の絶対パスに変換
			String path = application.getRealPath("/img/" + filename);
			System.out.println(path);
			//絶対パスにfileを作成
			File file = new File(path);
			System.out.println(file);
			//imageFileを"/img/ファイル名"に転送
			imageFile.transferTo(file);			
		}catch(Exception e) {
			return form();
		}
		
		book.setId(bookService.createId());
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			book.setSaledate(format.parse(form.getSaledate()));
		}catch(Exception e){
			return null;
		}
		
		book.setImage(filename);
		book = bookService.insert(book);
		
		return "redirect:list";
	}

}
