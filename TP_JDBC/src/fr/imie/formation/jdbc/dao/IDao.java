package fr.imie.formation.jdbc.dao;

import java.util.List;

/** Defines the interface for Dao.
 * @author Florent RICHARD
 * @param <D> Data exchanged
 */
public interface IDao<D> extends AutoCloseable {

    /** Return the list of all elements.
     * @return List of all elements.
     */
    List<D> selectAll();

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
     * @throws Exception Case of error during filtering.
     */
    List<D> selectFiltered(D elementFilter) throws Exception;
}
