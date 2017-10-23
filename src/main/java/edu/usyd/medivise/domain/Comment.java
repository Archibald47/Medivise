package edu.usyd.medivise.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "questionId", nullable = false)
	private long questionId;

	@Column(name = "content", nullable = false)
	private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable=false)
	private Date created;
    
    @Column(name = "user", nullable = false)
    private User user;

	public Comment() { }
	
	public Comment(long questionId, String content, User user) {
		this.questionId = questionId;
		this.content = content;
		this.user = user;
		created = new Date();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuestionId() {
		return this.questionId;
	}

	public void setTitle(long questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreated() {
		return this.created;
	}

}
