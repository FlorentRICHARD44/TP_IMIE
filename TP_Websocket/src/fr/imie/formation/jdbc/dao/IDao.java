package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.util.List;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoUsager;

/** Defines the interface for Dao.
 * @author Florent RICHARD
 * @param <T> Data exchanged
 */
public interface IDao<T> extends AutoCloseable {

    /** Return the list of all elements.
     * @return List of all elements.
     */
    List<T> selectAll();

    /** Return the element specified by its Id.
     * @param id Id of the element to return
     * @return Element corresponding to the Id.
     */
    T getById(Integer id);

    /** Add a new element.
     * @param data Element to add.
     * @return element added.
     */
    T insert(T data);

    /** Remove an element.
     * @param data Element to remove.
     */
    void delete(T data);

    /** Modify an element.
     * @param data Element to modify with new values to apply.
     */
    void update(T data);

    /** Return a list of elements corresponding to the filter specified.
     * Attributes set to null in the filter are not used for filtering.
     * @param elementFilter Pattern of element.
     * @return List of elements corresponding to the filter.
     * @throws NullFilterException Case of error during filtering.
     */
    List<T> selectFiltered(T elementFilter) throws NullFilterException;

    /** Remove an element with a connection provided.
     * @param data Element to remove.
     * @param con Connection to use.
     */
    void delete(T data, Connection con);
}
