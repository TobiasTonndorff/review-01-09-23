import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("review");


      /*  StudentExample student1 = new StudentExample("Tobias", 25, "Tobias@Tonndorff.dk");
        StudentExample student2 = new StudentExample("Mads", 25, "mads@nørgaard.dk");
        StudentExample student3 = new StudentExample("anders", 2, "anders@larsen.com");
        StudentExample student4 = new StudentExample("XX", 24, "XXtentation@RIP.org");
        StudentExample student5 = new StudentExample("Chris", 24, "JegBliverAltidFyretNårJegMelderMigSyg@nederen.dk");
        StudentExample student6 = new StudentExample("Andreas", 25, "NyPC-FINALLY@GoFundMe.com");

        try(var em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);
            em.getTransaction().commit();


        }finally {
            emf.close();
        }

        */



        /*

        1. JPQL vs SQL:

        JPQL is object-oriented where SQL is table/database oriented:

        JPQL doesn't work directly with tables, but with objects and their properties.

        JPQL is case-sensitive, where SQL is not.

        SQL is not checked during compile time, where JPQL is.






        */


        // Named query example (annotation in StudentExample class)
     /*   try(var em = emf.createEntityManager()){
            Query idQuery = em.createNamedQuery("find student by id ");

            idQuery.setParameter("id", 5);
            List<StudentExample> studentList = idQuery.getResultList();

            for(StudentExample student : studentList){
                System.out.println("Student ID :" + student.getId());
                System.out.println("\t Student Name :" + student.getName());
                System.out.println("Student email :" + student.getEmail());
            }
        }
        */

    //difference between typedQueries and normal queries

        /*

        1. Type safety

        2. Compile time checking

        3. readability & maintainability

        4. parameterization (setParameter()) method

         */

        /*
        Explain the difference between the methods: getSingleResult() and getResultList().

        getResultList():

        1. is used when you expect more than one result
        2. returns a list of results - in JPQL it would be a list of objects (entities)
        3. returns an empty list if no results are found
        4. doesn't throw an exception if no results are found

        getSingleResult():

        1. is used when you expect only one result
        2. returns a single result - in JPQL it would be a single object (entity)
        3. throws an exception if no results are found
        4. throws an exception if more than one result is found

         */






         /*
         be able to explain the difference between  the methods: getFirstResult() and setMaxResults().


        getFirstResult():

        1. you can specify the first result to be retrieved based on the index of the result
        2. the first result is 0 by default
        3. it is used in combination with setMaxResults()
        4. can be usefull for big data sets






        setMaxResults():

        1. you can specify the maximum number of results to be retrieved
        2. it is used in combination with getFirstResult()
        3. can be usefull for big data sets

          */





        try(var em = emf.createEntityManager()){
            int someNumber = 2;

            String nativeQuery = "SELECT * FROM studentexample WHERE age > :someNumber";

            Query query = em.createNativeQuery(nativeQuery, StudentExample.class);
            query.setParameter("someNumber", someNumber);

            List<StudentExample> studentList = query.getResultList();

            for(StudentExample student : studentList){
                System.out.println("Student ID :" + student.getId());
                System.out.println("\t Student Name :" + student.getName());
                System.out.println("Student email :" + student.getEmail());
            }

        }finally {
            emf.close();
        }














    }
}