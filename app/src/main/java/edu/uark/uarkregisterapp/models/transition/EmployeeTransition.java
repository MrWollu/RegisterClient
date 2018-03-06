package edu.uark.uarkregisterapp.models.transition;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

import edu.uark.uarkregisterapp.commands.converters.ByteToUUIDConverterCommand;
import edu.uark.uarkregisterapp.commands.converters.UUIDToByteConverterCommand;
import edu.uark.uarkregisterapp.models.api.Employee;


//lets get it
public class EmployeeTransition implements Parcelable {
	private String firstname, lastname, password;
	private UUID id;
	
	public String getLastName() {
		return this.lastname;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	public String getpassword() {
		return this.password;
	}
	public UUID getId() {
		return this.id;
	}
	public EmployeeTransition setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public EmployeeTransition setFirsttname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public EmployeeTransition setPassword(string password) {
		this.password = password;
		return this;
	}
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public EmployeeTransition setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public EmployeeTransition setCount(int count) {
		this.count = count;
		return this;
	}

	private Date createdOn;
	public Date getCreatedOn() {
		return this.createdOn;
	}
	public EMployeeTransition setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	@Override
	public void writeToParcel(Parcel destination, int flags) {
		destination.writeByteArray((new UUIDToByteConverterCommand()).setValueToConvert(this.id).execute());
		destination.writeString(this.lookupCode);
		destination.writeInt(this.count);
		destination.writeLong(this.createdOn.getTime());
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<EmployeeTransition> CREATOR = new Parcelable.Creator<EmployeeTransition>() {
		public EmployeeTransition createFromParcel(Parcel employeeTransitionParcel) {
			return new EmployeeTransition(employeeTransitionParcel);
		}

		public EmployeeTransition[] newArray(int size) {
			return new EmployeeTransition[size];
		}
	};

	public EmployeeTransition() {
		this.count = -1;
		this.id = new UUID(0, 0);
		this.firstname = "";
		this.lastname = "";
		this.password = "";
		this.createdOn = new Date();
		this.lookupCode = StringUtils.EMPTY;
	}

	public EmployeeTransition(Employee employee) {
		this.id = employee.getId();
		this.firstname = employee.firstname;
		this.lastname = employee.lastname;
		this.password = employee.password;
		this.count = employee.getCount();
		this.createdOn = employee.getCreatedOn();
		this.lookupCode = employee.getLookupCode();
	}
	//dont understand this 
	private EmployeeTransition(Parcel employeeTransitionParcel) {
		this.id = (new ByteToUUIDConverterCommand()).setValueToConvert(employeeTransitionParcel.createByteArray()).execute();
		this.lookupCode = employeeTransitionParcel.readString();
		this.count = employeeTransitionParcel.readInt();

		this.createdOn = new Date();
		this.createdOn.setTime(employeeTransitionParcel.readLong());
	}
}
