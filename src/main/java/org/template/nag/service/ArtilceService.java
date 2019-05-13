package org.template.nag.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.template.nag.dao.ArticleRepository;
import org.template.nag.dto.ArticleDto;
import org.template.nag.entity.Article;

@Service
public class ArtilceService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	public void save(ArticleDto article , Article entity) {
	    BeanUtils.copyProperties(article,entity);
		articleRepository.save(entity);
	}
	
	

}
