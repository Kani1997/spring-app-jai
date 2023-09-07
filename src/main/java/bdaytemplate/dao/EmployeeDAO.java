package bdaytemplate.dao;

import bdaytemplate.dto.EmailRequest;

import java.util.List;

public interface EmployeeDAO {
public  List<EmailRequest> findAllWithBirthday();
}
