package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoSite;

/** Dao Site for testing.
 * @author imie
 */
@Dummy
public class DummyDaoSite implements IDao<DtoSite> {
    /** List of Dto used for testing.
     */
    private List<DtoSite> dto;
    /** Constructor.
     */
    public DummyDaoSite() {
        Integer numid = 1;
        DtoSite dto1 = new DtoSite();
        dto1.setId(numid++);
        dto1.setName("Saint-Clément");
        DtoSite dto2 = new DtoSite();
        dto2.setId(numid++);
        dto2.setName("Doulon");
        DtoSite dto3 = new DtoSite();
        dto3.setId(numid++);
        dto3.setName("Pirmil");
        dto = new ArrayList<DtoSite>();
        dto.add(dto1);
        dto.add(dto2);
        dto.add(dto3);
    }

    @SuppressWarnings("javadoc")
    @Override
    public void close() throws Exception {
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoSite> selectAll() {
        return dto;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoSite getById(final Integer id) {
        DtoSite site = null;
        for (DtoSite s: dto) {
            if (s.getId() == id) {
                site = s;
            }
        }
        return site;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoSite insert(final DtoSite data) {
        return data;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoSite data) {
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void update(final DtoSite data) {
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoSite> selectFiltered(final DtoSite elementFilter)
            throws NullFilterException {
        return new ArrayList<DtoSite>();
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoSite data, final Connection con) {
    }

}
