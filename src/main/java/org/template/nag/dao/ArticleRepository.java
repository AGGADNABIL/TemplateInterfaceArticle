package org.template.nag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.template.nag.entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Integer>{

}
