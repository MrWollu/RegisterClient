package edu.uark.uarkregisterapp.models.api;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import edu.uark.uarkregisterapp.models.api.fields.EmployeeFieldName;
import edu.uark.uarkregisterapp.models.api.interfaces.ConvertToJsonInterface;
import edu.uark.uarkregisterapp.models.api.interfaces.LoadFromJsonInterface;
import edu.uark.uarkregisterapp.models.transition.EmployeeTransition; //look at  transition

public class Employee implements ConvertToJsonInterface, LoadFromJsonInterface<Employee> {
	private UUID id;
	private String lastname, firstname, password;
	public UUID getId() {
		return this.id;
	}
	public employee setId(UUID id) {
		this.id = id;
		return this;
	}
	public String getLastName() {
		return this.lastname;
	}
	public Employee setlname(String lname) { // lname = last name
		this.lname = lname;
		return this;
	}
	public String getFirstname() {
		return this.firstname;
	}
	public Employee setfname(String lname) { // fname = first name
		this.fname = fname;
		return this;
	}
	public String getpassword() {
		return this.password;
	}
	public Employee setPassword(String password) { // lname = last name
		this.password = password;
		return this;
	}
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Employee setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public Employee setCount(int count) {
		this.count = count;
		return this;
	}

	private Date createdOn;
	public Date getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	@Override
	public Employee loadFromJson(JSONObject rawJsonObject) {
		String value = rawJsonObject.optString(EmployeeFieldName.ID.getFieldName());
		if (!StringUtils.isBlank(value)) {
			this.id = UUID.fromString(value);
		}

		this.lookupCode = rawJsonObject.optString(EmployeeFieldName.LOOKUP_CODE.getFieldName());
		this.count = rawJsonObject.optInt(EmployeeFieldName.COUNT.getFieldName());

		value = rawJsonObject.optString(EmployeeFieldName.CREATED_ON.getFieldName());
		if (!StringUtils.isBlank(value)) {
			try {
				this.createdOn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US).parse(value);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		return this;
	}

	@Override
	public JSONObject convertToJson() {
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(EmployeeFieldName.ID.getFieldName(), this.id.toString());
			jsonObject.put(EmployeeFieldName.LOOKUP_CODE.getFieldName(), this.lookupCode);
			jsonObject.put(EmployeeFieldName.COUNT.getFieldName(), this.count);
			jsonObject.put(EmployeeFieldName.CREATED_ON.getFieldName(), (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US)).format(this.createdOn));
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	public Employee() {
		this.count = -1;
		this.lookupCode = "";
		this.id = new UUID(0, 0);
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.createdOn = new Date();
	}

	public Employee(EmployeeTransition employeeTransition) {
		this.id = employeeTransition.getId();
		this.lastname = employeeTransition.getFirstname();
		this.firstname = employeeTransition.getLastName();
		this.count = employeeTransition.getCount();
		this.createdOn = employeeTransition.getCreatedOn();
		this.lookupCode = employeeTransition.getLookupCode();
	}
}
