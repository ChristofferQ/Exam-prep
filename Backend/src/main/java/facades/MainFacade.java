package facades;

import dtos.BoatDTO;
import entities.Boat;
import entities.Harbour;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainFacade {

    private static EntityManagerFactory emf;
    private static MainFacade instance;

    private MainFacade() {
    }

    public static MainFacade getMainFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MainFacade();
        }
        return instance;
    }


    public static BoatDTO createBoat(int id, String brand, String make, String name, String image) /* throws MissingFieldException */{
        /*if(brand == null || make == null || name == null || image == null){
            throw new MissingFieldException("Missing field");
        }*/

        Boat b = new Boat(id, brand, make, name, image);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BoatDTO(b);

    }





}
