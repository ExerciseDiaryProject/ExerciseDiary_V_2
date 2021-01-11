package exerciseDiary.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
//@ToString
 
@Entity
@SequenceGenerator(name="diary_no", sequenceName="seq_diary", allocationSize=1)
public class Diary {
	
	public Diary() {
		super();
	}

	@Id
	@Column(name="diary_no")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="diary_no")
	private int diaryNo;
	
	@Column(name="diary_title", length=50, nullable= false)
	private String diaryTitle;
	
	@Column(name="diary_content",length=200, nullable= false)
	private String diaryContent;
	
	
	@Column(name="write_date",length=200, nullable= false)
	@Temporal(TemporalType.DATE)
	private Date writeDate;
	
	@Column(name="today_weight",length=20, nullable= false)
	private String todayWeight;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable= false)
	private Users userId;
	
	@ManyToOne
	@JoinColumn(name="purpose", nullable=false)
	private Purpose purpose;
	
	@ManyToOne
	@JoinColumn(name="program_no", nullable= false)
	private Video programNo;

	@Builder
	public Diary(String diaryTitle, String diaryContent, Date writeDate, String todayWeight, Users userId,
			Purpose purpose, Video programNo) {
		super();
		this.diaryTitle = diaryTitle;
		this.diaryContent = diaryContent;
		this.writeDate = writeDate;
		this.todayWeight = todayWeight;
		this.userId = userId;
		this.purpose = purpose;
		this.programNo = programNo;
	}
}
