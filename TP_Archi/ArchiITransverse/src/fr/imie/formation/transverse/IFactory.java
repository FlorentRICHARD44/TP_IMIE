package fr.imie.formation.transverse;

import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;
import fr.imie.formation.jdbc.services.IService;

public interface IFactory {

    IDao<DtoUsager> getUsagerDao();

    IDao<DtoSite> getSiteDao();

    IService getService();

}
