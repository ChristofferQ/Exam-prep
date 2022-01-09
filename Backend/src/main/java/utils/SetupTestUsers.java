package utils;


import entities.*;
import facades.MainFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords


    User user = new User("user", "1234");
    User admin = new User("admin", "12345");
    User both = new User("user_admin", "1234");

    Boat boat1 = new Boat(1,"brand","make","name","image");
    Boat boat2 = new Boat(2,"brand2","make2","name2","image2");

    Harbour harbour1 = new Harbour(1,"name","address",20);
    Harbour harbour2 = new Harbour(2,"name2","address2",40);

    Owner owner1 = new Owner(1,"name","address", 1234);
    Owner owner2 = new Owner(2,"name2","address2", 6789);



    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(boat1);
    em.persist(boat2);
    em.persist(harbour1);
    em.persist(harbour2);
    em.persist(owner1);
    em.persist(owner2);
    em.persist(admin);
    em.persist(both);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
