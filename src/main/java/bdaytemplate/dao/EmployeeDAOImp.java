package bdaytemplate.dao;

import bdaytemplate.dto.EmailRequest;
import bdaytemplate.service.localDateGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }


    @Override
    public List<EmailRequest> findAllWithBirthday() {
        String    SQL         ="SELECT employeeid,name,birthdate,email,reporting_manager FROM details WHERE  MONTH(birthdate) = MONTH(CURRENT_DATE()) AND DAY(birthdate) = DAY(CURRENT_DATE())";
        return getNamedParameterJdbcTemplate().query(SQL, new BeanPropertyRowMapper<EmailRequest>(EmailRequest.class));
    }

}
