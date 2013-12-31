package ar.com.masch.exercise.learning.entity.base;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

import ar.com.masch.exercise.learning.entity.book.ChapterBookEntity;

@Table(name = "exercise_level_base")
@Entity(name = "exercise_level_base")
public class ExerciseLevelBaseEntity extends BaseEntity {

	@Column(name = "VELOCITY", nullable = true)
	private Long velocity;
	
	@ManyToOne(/*fetch = FetchType.LAZY*/)
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private LevelBaseEntity levelBaseEntity;
	
	@ManyToOne()
	@JoinColumn(name = "EXERCISE_BASE_ID", nullable = false)
	private ExerciseBaseEntity exerciseBaseEntity;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "exerc_lev_chap_book", 
	           joinColumns = { @JoinColumn(name = "EXERCISE_LEVEL_BASE_ID", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "CHAPTER_BOOK_ID") })
	private ChapterBookEntity chapterBookEntity;

	public ExerciseLevelBaseEntity() {
		super();
	}
	
	public ExerciseLevelBaseEntity(Long id, LevelBaseEntity levelBaseEntity, ExerciseBaseEntity exerciseBaseEntity, Long velocity) {
		super(id);
		this.velocity = velocity;
		this.levelBaseEntity = levelBaseEntity;
		this.exerciseBaseEntity = exerciseBaseEntity;
	}
	
	public Long getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Long velocity) {
		this.velocity = velocity;
	}
	
	public LevelBaseEntity getLevelBaseEntity() {
		return levelBaseEntity;
	}

	public void setLevelBaseEntity(LevelBaseEntity levelBaseEntity) {
		this.levelBaseEntity = levelBaseEntity;
	}
	
	public ExerciseBaseEntity getExerciseBaseEntity() {
		return exerciseBaseEntity;
	}
	
	public void setExerciseBaseEntity(ExerciseBaseEntity exerciseBaseEntity) {
		this.exerciseBaseEntity = exerciseBaseEntity;
	}

	public ChapterBookEntity getChapterBookEntity() {
		return chapterBookEntity;
	}
	
	public void setChapterBookEntity(ChapterBookEntity chapterBookEntity) {
		this.chapterBookEntity = chapterBookEntity;
	}
	
	@Override
	public String toString() {
		String result = super.toString() + 
		        		"\nVelocity: " + this.velocity.toString() + 
				        "\nLevelBase: " + this.levelBaseEntity.toString() +
				        "\nExerciseBase: " + this.exerciseBaseEntity.toString() +
						"\nChapterBook:" + this.chapterBookEntity.toString();
		return result;
	}	
}
