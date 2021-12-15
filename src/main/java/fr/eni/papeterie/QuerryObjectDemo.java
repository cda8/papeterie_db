package fr.eni.papeterie;

import fr.eni.papeterie.entites.ArticlesEntity;
import fr.eni.papeterie.entites.hibernate.HibernateTest;

import java.util.List;

public class QuerryObjectDemo {

    public static void main(String[] args) {




        HibernateTest test = new HibernateTest();

        test.getSession();


        ArticlesEntity a1 = new ArticlesEntity("Bic1", "BBOrange", "Bic bille Orange", 1.2f, 20, null, "bleu", "Stylo");
        ArticlesEntity a2 = new ArticlesEntity("Bic2", "BBOrange", "Bic bille Orange", 1.2f, 20, null, "bleu", "Stylo");
        ArticlesEntity a3 = new ArticlesEntity("Bic3", "BBOrange", "Bic bille Orange", 1.2f, 20, null, "bleu", "Stylo");
        test.create(a1);
        test.create(a2);
        test.create(a3);

//        List<ArticlesEntity> articles = test.read();
//
//
//        articles.forEach(System.err::println);
////        System.err.println(articles.get(articles.size()-1) + " taille " + articles.get(articles.size()));
//        System.out.println("-----------UPDATE-----------");
//        a1.setReference("Le nouveau");
//        test.update(a1);
//        System.err.println(articles.get(articles.size()-1) + " taille " + articles.size());
//        System.out.println();
//        System.out.println("-----------DELETE-----------");
//        test.delete(a1);
//        System.err.println(articles.get(articles.size()-1) + " taille " + articles.size() );


        test.closeSession();
    }
}
