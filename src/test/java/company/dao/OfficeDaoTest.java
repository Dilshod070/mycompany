package company.dao;

import company.hibernate.OfficeEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OfficeDaoTest {

    private OfficeDao _dao;

    @Before
    public void setUp() throws Exception {
        _dao = new OfficeDao();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        assertEquals("Lomonosovsky pr-ct 27/11", _dao.findById(1).getAddress());
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        OfficeEntity tmp = new OfficeEntity();
        tmp.setAddress("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(tmp.getId()).getAddress());
        tmp.setAddress("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(tmp.getId()).getAddress());
        _dao.delete(tmp);
        assertNull(_dao.findById(tmp.getId()));
    }

    @Test
    public void findAll() {
        List<OfficeEntity> _list = _dao.findAll();
        for (OfficeEntity i: _list) {
            assertEquals(i.getAddress(), _dao.findById(i.getId()).getAddress());
        }
    }

    @Test
    public void updateDescription() {
        OfficeEntity tmp = _dao.findById(1);
        String prev = tmp.getDescription();
        tmp.setDescription("DESCRIPTION");
        _dao.update(tmp);
        assertEquals("DESCRIPTION", _dao.findById(1).getDescription());
        tmp.setDescription(prev);
        _dao.update(tmp);
    }

}