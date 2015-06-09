package fr.imie.formation.jdbc.dao;

import java.util.List;

import fr.imie.formation.jdbc.NullFilterException;

/** Defines the interface for Dao.
 * @author Florent RICHARD
 * @param <D> Data exchanged
 */
public interface IDao<D> extends AutoCloseable {

    /** Return the list of all elements.
     * @return List of all elements.
     */
    List<D> selectAll();

    /** Return the element specified by its Id.
     * @param id Id of the element to return
     * @return Element corresponding to the Id.
     */
    D getById(Integer id);

    /** Add a new element.
     * @param data Element to add.
     * @return element added.
     */
    D insert(D data);

    /** Remove an element.
     * @param data Element to remove.
     */
    void delete(D data);

    /** Modify an element.
     * @param data Element to modify with new values to apply.
     */
    void update(D data);

    /** Return a list of elements corresponding to the filter specified.
     * Attributes set to null in the filter are not used for filtering.
     * @param elementFilter Pattern of element.
     * @return List of elements corresponding to the filter.
     * @throws NullFilterException Case of error during filtering.
     */
    List<D> selectFiltered(D elementFilter) throws NullFilterException;
}
