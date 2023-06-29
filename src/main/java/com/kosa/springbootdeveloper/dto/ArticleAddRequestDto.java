package com.kosa.springbootdeveloper.dto;

import com.kosa.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor                     //생성자로 title, content를 받을 수 있게끔 setter가 필요없음
@Getter
public class ArticleAddRequestDto {

    private String title;
    private String content;

    public Article toEntity() {


        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
