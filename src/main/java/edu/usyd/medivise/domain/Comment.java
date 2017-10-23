package edu.usyd.medivise.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "question")
    private Question question;

	@Column(name = "content", nullable = false)
	private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable=false)
	private Date created;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

	public Comment() { }
	
	public Comment(Question question, String content, User user) {
		this.question = question;
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
	
	public User getUser() {
		return user;
	}

}
