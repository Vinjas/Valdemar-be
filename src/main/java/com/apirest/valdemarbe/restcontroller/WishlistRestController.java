package com.apirest.valdemarbe.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.valdemarbe.config.JwtTokenUtil;
import com.apirest.valdemarbe.model.entitybean.Book;
import com.apirest.valdemarbe.model.entitybean.User;
import com.apirest.valdemarbe.service.BookService;
import com.apirest.valdemarbe.service.UserService;
import com.apirest.valdemarbe.service.WishlistService;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistRestController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    WishlistService wishlistService;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<?> findWishlist(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtTokenUtil.getEmailFromToken(token);

        User user = userService.findByEmail(email);

        return new ResponseEntity<List<Book>>(user.getWishlist().getBooks(), HttpStatus.OK);
    }

    // @PostMapping
    // ResponseEntity<?> addBook(HttpServletRequest request, @RequestBody String
    // isbn) {
    // String token = request.getHeader("Authorization").substring(7);
    // String email = jwtTokenUtil.getEmailFromToken(token);

    // Wishlist wishlist = wishlistService.findByUser(email);

    // Book book = bookService.findOne(isbn);

    // if (book == null) {
    // return new ResponseEntity<String>("El libro no existe",
    // HttpStatus.BAD_REQUEST);
    // }

    // if (wishlist.getBooks().contains(book)) {
    // return new ResponseEntity<String>("El libro ya está en la wishlist",
    // HttpStatus.BAD_REQUEST);
    // }

    // wishlist.getBooks().add(book);
    // return new ResponseEntity<String>("Libro añadido a la lista de deseos",
    // HttpStatus.OK);
    // }
}
