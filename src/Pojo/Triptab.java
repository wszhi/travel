package Pojo;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
public class Triptab {
	private Integer travel_id;
private String employee_id;
	private String position;
	private String destination;
	private String type;
	private String reason;
	public Date apply_time;
	public Date start_time;
	private Date end_time;
	private String schedule;
	private String remark;
	private String manager_id;
	public String state;
	private String man_rea;
	private String department;
	public  Triptab() {};
	// 初始化全部属性的构造器
	
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getMan_rea(){
		return man_rea;
	}
	public void setMan_rea(String man_rea) {
		this.man_rea = man_rea;
	}
	public String getState(){
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(Integer travel_id) {
		this.travel_id = travel_id;
	}
	
}
