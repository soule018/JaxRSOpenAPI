package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Fiche;


public class FicheDao extends AbstractJpaDao<Long, Fiche> {


    public FicheDao() {
        super(Fiche.class);
    }

    public Fiche createFiche(String libelle) {
        Fiche fiche = new Fiche(libelle);
        this.save(fiche);
        return fiche;
    }

    /*public void createFiche(String libelle,){
        this.save(fiche);
    }*/
}
