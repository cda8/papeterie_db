package fr.eni.papeterie.dao.jpa;

import fr.eni.papeterie.entites.ArticlesEntity;

import java.util.List;

public class ArticlesEntityJpaRunner {

    public static void main(String[] args) {
        ArticlesDaoJpa articlesDaoJpa = new ArticlesDaoJpa();

        articlesDaoJpa.read().forEach(System.err::println);


       List<ArticlesEntity> a =  articlesDaoJpa.selectByMotCle("BB");

        a.forEach(System.out::println);
        System.out.println(a.size());
        a = articlesDaoJpa.SelectByMarque("BBOrange");
        System.out.println(a.size());
        a.forEach(System.out::println);


    }

}
