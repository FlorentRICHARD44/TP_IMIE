package fr.imie.formation.jdbc.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.jdbc.dao.DaoUsager;
import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.dto.DtoUsager;

/** Service to access the data from DAO.
 * @author Florent RICHARD
 */
public class ServiceDao implements AutoCloseable {
    /** Access to Database for Usager.
     */
    private IDao<DtoUsager> daoUsager;
    /** Constructor.
     */
    public ServiceDao() {
        daoUsager = new DaoUsager();
    }

    /** Return the list of all elements.
     * @return List of all elements.
     */
    public final List<Usager> selectAll() {
        List<DtoUsager> dtoUsagers = daoUsager.selectAll();
        List<Usager> usagers = new ArrayList<Usager>();
        for (DtoUsager dtoU: dtoUsagers) {
            usagers.add(dtoToData(dtoU));
        }
        return usagers;
    }

    /** Add a new element.
     * @param data Element to add.
     * @return element added.
     */
    public final Usager insert(final Usager data) {
        return dtoToData(daoUsager.insert(dataToDto(data)));
    }

    /** Remove an element.
     * @param data Element to remove.
     */
    public final void delete(final Usager data) {
        daoUsager.delete(dataToDto(data));
    }

    /** Modify an element.
     * @param data Element to modify with new values to apply.
     */
    public final void update(final Usager data) {
        daoUsager.update(dataToDto(data));
    }

    /** Return a list of elements corresponding to the filter specified.
     * Attributes set to null in the filter are not used for filtering.
     * @param elementFilter Pattern of element.
     * @return List of elements corresponding to the filter.
     * @throws Exception Case of error during filtering.
     */
    public final List<Usager> selectFiltered(final Usager elementFilter)
            throws Exception {
        List<DtoUsager> dtoUsagers = daoUsager.selectFiltered(
                                        dataToDto(elementFilter));
        List<Usager> usagers = new ArrayList<Usager>();
        for (DtoUsager dtoU: dtoUsagers) {
            usagers.add(dtoToData(dtoU));
        }
        return usagers;
    }

    /** Convert from Usager to DtoUsager.
     * @param usager Usager in input
     * @return DtoUsager in output
     */
    private DtoUsager dataToDto(final Usager usager) {
        DtoUsager dtoUsager = new DtoUsager();
        dtoUsager.setId(usager.getId());
        dtoUsager.setName(usager.getName());
        dtoUsager.setFirstName(usager.getFirstName());
        dtoUsager.setDateBirth(usager.getDateBirth());
        dtoUsager.setEmail(usager.getEmail());
        dtoUsager.setNbConnection(usager.getNbConnection());
        return dtoUsager;
    }

    /** Convert from DtoUsager to Usager.
     * @param dtoUsager DtoUsager in input
     * @return Usager in output
     */
    private Usager dtoToData(final DtoUsager dtoUsager) {
        Usager usager = new Usager();
        usager.setId(dtoUsager.getId());
        usager.setName(dtoUsager.getName());
        usager.setFirstName(dtoUsager.getFirstName());
        usager.setDateBirth(dtoUsager.getDateBirth());
        usager.setEmail(dtoUsager.getEmail());
        usager.setNbConnection(dtoUsager.getNbConnection());
        return usager;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void close() throws Exception {
        daoUsager.close();
    }
}
