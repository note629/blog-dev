package com.kosa.springbootdeveloper.controller;

import com.kosa.springbootdeveloper.domain.Article;
import com.kosa.springbootdeveloper.dto.ArticleAddRequestDto;
import com.kosa.springbootdeveloper.dto.ArticleResponseDto;
import com.kosa.springbootdeveloper.repository.ArticleRepository;
import com.kosa.springbootdeveloper.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleAddRequestDto dto){
        Article savedArticle = articleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponseDto>> findAllArticles() {
        List<ArticleResponseDto> articles = articleService.findAll()
                .stream()
                .map(ArticleResponseDto::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }
}
