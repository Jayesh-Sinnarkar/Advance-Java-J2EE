package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department extends BaseEntity {
	@Column(length = 30)
	private String location;
	@Column(name="dept_name",length = 40,unique = true)
	private String deptName;
	//one to many
	@OneToMany(mappedBy = "dept")
	private List<Employee> emps=new ArrayList<>();

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String location, String deptName) {
		super();
		this.location = location;
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department ID "+getId()+"   [location=" + location + ", deptName=" + deptName + "]";
	}
	

}
