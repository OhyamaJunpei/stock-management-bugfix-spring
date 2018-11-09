package jp.co.rakus.stockmanagement.service;

import java.util.List;

import jp.co.rakus.stockmanagement.domain.Book;
import jp.co.rakus.stockmanagement.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 書籍関連サービスクラス.
 * @author igamasayuki
 *
 */
@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book findOne(Integer id) {
		return bookRepository.findOne(id);
	}
	
//	public Book save(Book book){
//		return bookRepository.save(book);
//	}
	
	public Book update(Book book){
		return bookRepository.update(book);
	}
	
//	public void delete(Integer id){
//		bookRepository.delete(id);
//	}
	
	/**
	 * bookのidは自動採番されないため
	 * 現在DBにあるidに+1したidを作るメソッド.
	 * @return DBに存在するid+1
	 */
	public Integer createId() {
		Integer maxId = bookRepository.getMaxId();
		if (maxId == null) {
			maxId = 1;
			return maxId;
		}
		return maxId + 1;
	}
	
	public Book insert(Book book) {
		return bookRepository.insert(book);
	}
}
