package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoUsager;

/** Dao Site for testing.
 * @author imie
 */
@DummyUsager
public class DummyDaoUsager implements IDao<DtoUsager> {
    /** List of dto for testing.
     */
    private List<DtoUsager> dto;
    /** Constructor.
     */
    public DummyDaoUsager() {
        Integer numid = 1;
        DtoUsager dto1 = new DtoUsager();
        dto1.setId(numid++);
        dto1.setName("RICHARD");
        dto1.setFirstName("Florent");
        dto1.setPassword("floflo");
        dto1.setInscrSite(null);
        DtoUsager dto2 = new DtoUsager();
        dto2.setId(numid++);
        dto2.setName("BONBEURRE");
        dto2.setFirstName("Jean");
        dto2.setInscrSite(null);
        DtoUsager dto3 = new DtoUsager();
        dto3.setId(numid++);
        dto3.setName("DUPONT");
        dto3.setFirstName("Pierre");
        dto3.setInscrSite(null);
        DtoUsager dto4 = new DtoUsager();
        dto4.setId(numid++);
        dto4.setName("OLALUNE");
        dto4.setFirstName("Pierre");
        dto4.setInscrSite(null);
        dto = new ArrayList<DtoUsager>();
        dto.add(dto1);
        dto.add(dto2);
        dto.add(dto3);
        dto.add(dto4);
    }

    @SuppressWarnings("javadoc")
    @Override
    public void close() throws Exception {
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoUsager> selectAll() {
        return dto;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoUsager getById(final Integer id) {
        DtoUsager usager = null;
        for (DtoUsager u: dto) {
            if (u.getId() == id) {
                usager = u;
            }
        }
        return usager;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoUsager insert(final DtoUsager data) {
        Integer maxId = 0;
        for (DtoUsager u: dto) {
            if (u.getId() > maxId) {
                maxId = u.getId();
            }
        }
        data.setId(maxId + 1);
        dto.add(data);
        return data;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoUsager data) {
        for (DtoUsager u: dto) {
            if (u.getId() == data.getId()) {
                dto.remove(u);
            }
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void update(final DtoUsager data) {
        for (DtoUsager u: dto) {
            if (u.getId() == data.getId()) {
                u.setName(data.getName());
                u.setFirstName(data.getFirstName());
                u.setDateBirth(data.getDateBirth());
                u.setInscrSite(data.getInscrSite());
                u.setEmail(data.getEmail());
            }
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoUsager> selectFiltered(final DtoUsager elementFilter)
            throws NullFilterException {
        List<DtoUsager> usagers = new ArrayList<DtoUsager>();
        for (DtoUsager u: dto) {
            boolean correct = true;
            if (elementFilter.getName() != null && !elementFilter.getName().equals(u.getName())) {
                correct = false;
            }
            if (elementFilter.getFirstName() != null && !elementFilter.getFirstName().equals(u.getFirstName())) {
                correct = false;
            }
            if (correct) {
                usagers.add(u);
            }
        }
        return usagers;
    }

    @SuppressWarnings("javadoc")
    @Override
    public void delete(final DtoUsager data, final Connection con) {
    }

}
