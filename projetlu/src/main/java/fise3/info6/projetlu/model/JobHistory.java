package fise3.info6.projetlu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the job_history database table.
 * 
 */
@Entity
@Table(name="job_history")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private JobHistoryPK id;
	private byte[] employee;
	private Date endDate;
	private byte[] job;
	private Department department;
	private Employee employeeBean;
	private Job jobBean;

	public JobHistory() {
	}


	@EmbeddedId
	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}


	@Lob
	public byte[] getEmployee() {
		return this.employee;
	}

	public void setEmployee(byte[] employee) {
		this.employee = employee;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE", nullable=false)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	@Lob
	public byte[] getJob() {
		return this.job;
	}

	public void setJob(byte[] job) {
		this.job = job;
	}


	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID", nullable=false, insertable=false, updatable=false)
	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}


	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID", nullable=false)
	public Job getJobBean() {
		return this.jobBean;
	}

	public void setJobBean(Job jobBean) {
		this.jobBean = jobBean;
	}

}