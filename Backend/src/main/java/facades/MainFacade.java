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

    public static void createBoat(BoatDTO bDTO) {
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Boat boat = new Boat();
//        bDTO.setId(1);
//        bDTO.setBrand("Brand3");
//        bDTO.setMake("Make3");
//        bDTO.setName("Name3");
//        bDTO.setImage("Image3");
//        em.persist(boat);
//        em.getTransaction().commit();

    }




}
