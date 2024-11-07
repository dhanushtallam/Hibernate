package hiber06;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Entity
@Data
public class Trainer {
	@Id
	private String trainerName;
	private String subject;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Student> st;

}
