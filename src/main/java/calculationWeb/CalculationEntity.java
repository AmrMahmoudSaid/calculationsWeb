package calculationWeb;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Stateless
@Entity
public class CalculationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int number1;
	private int number2;
	private String operation;
	public void setNumber1(int number1) {
		this.number1=number1;
	}
	public void setNumber2(int number2) {
		this.number2=number2;
	}
	public void setOperation(String operation) {
		this.operation=operation;
	}
	public int getNumber1() {
		return this.number1;
	}
	public int getNumber2() {
		return this.number2;
	}
	public String getOperation() {
		return this.operation;
	}

}
