package org.employee.dtotest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {
	public static void main(String[] args) {
		EmployeeDTO emp=new EmployeeDTO();
		emp.setName("Sumit Singh");
		emp.setPhone("9128948481");
		emp.setAddress("Gopalganj");
		
		Configuration cfg =new Configuration();
		cfg.addResource("employeedto.hbm.xml");
		cfg.configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction trx=session.getTransaction();
		trx.begin();
		session.save(emp);
		trx.commit();
		session.close();
	}
}
