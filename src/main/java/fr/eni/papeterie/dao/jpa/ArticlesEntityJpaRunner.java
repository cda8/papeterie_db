package fr.eni.papeterie.dao.jpa;

import fr.eni.papeterie.entites.ArticlesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ArticlesEntityJpaRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger("ArticlesEntityJpaRunner");
    public static void main(String[] args) {

        ArticlesDaoJpa articlesDaoJpa = new ArticlesDaoJpa();

        articlesDaoJpa.read().forEach(System.err::println);


       List<ArticlesEntity> a =  articlesDaoJpa.selectByMotCle("BB");

        a.forEach(System.out::println);
        LOGGER.debug("Hey");
        a = articlesDaoJpa.SelectByMarque("BBOrange");
        System.out.println(a.size());
        a.forEach(System.out::println);


    }

}
