package org.template.nag;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.template.nag.dao.ArticleRepository;
import org.template.nag.entity.Article;


@SpringBootApplication
public class TemplateInterfaceArticleApplication implements CommandLineRunner {
	Logger logger=Logger.getLogger(TemplateInterfaceArticleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TemplateInterfaceArticleApplication.class, args);
	}
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void run(String... args) throws Exception {

		
		List<Path> filtered= new ArrayList<>();
		String directory="F:\\BKSM\\Clients\\Maroc\\IPSEN\\FichierIPSEN\\NAG_JAVA"; 
		
		try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
		    filtered= paths.filter(Files::isRegularFile)
		    			   .filter(f-> f.getFileName().toString().endsWith(".csv")).collect(Collectors.toList());        
		} 
			
		filtered.stream().forEach( e -> {
			
				String nameOfFile=e.getFileName().toString();
				String pattern =nameOfFile.split("_")[0];
				 
			     switch (pattern) {
			         case "ART":
			        	 try {
			             importArticle(e);
			        	 }catch (Exception e2) {
							logger.info("Erreur import Article :"+e2.getMessage());
						}
			             break;
			         case "AR":
			        	 importAttendu();
			             break;
			     }
		});	
	}
		
	public void importArticle(Path e)throws IOException {
		
		List<String> lignes = Files.lines(Paths.get(e.toString()),Charset.forName("ISO8859_1")).collect(Collectors.toList());
			System.out.println("--------------------------");
			System.out.println("Récupération du fichier :"+e.toString());
			System.out.println("--------------------------");
			
			//ART_CODE;ART_DESL;TIE_CODE
			lignes.stream().skip(1).forEach(art -> {
					Article article=new Article();
					article.setCodeArticle(art.split(";")[0]);
					logger.info("code article :"+art.split(";")[0]);
					
					article.setDesignationLongue(art.split(";")[1]);
					logger.info("designation longue :"+art.split(";")[1]);
					
					article.setDesignation(art.split(";")[2]);
					logger.info("designation court :"+art.split(";")[2]);
					
					article.setCodeTiers(art.split(";")[3]);
					logger.info("code tiers :"+art.split(";")[3]);
					
				    articleRepository.save(article);
			});
	}
	
	
	public void importAttendu() {
		
	}
	
}
