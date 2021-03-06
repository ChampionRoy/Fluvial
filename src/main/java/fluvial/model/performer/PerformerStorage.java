package fluvial.model.performer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fluvial.model.job.JobStorage;
import fluvial.model.storage.Store;

import javax.persistence.*;
import java.util.List;

/**
 * Created by superttmm on 31/05/2017.
 */
@Entity
public abstract class PerformerStorage implements Store {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String performerType;

    @Column(name = "performer", columnDefinition = "json")
    @Convert(converter = PerformerJsonConverter.class)
    private Performer performer;

    @Enumerated(EnumType.STRING)
    private PerformerStatus status;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "performer")
    private List<JobStorage> jobs;

    public Long getId(){return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public List<JobStorage> getJobs() {return jobs;}

    public void setJobs(List<JobStorage> jobs) { this.jobs = jobs; }

    public PerformerStatus getStatus(){ return status;}

    public void setStatus(PerformerStatus status) {this.status = status;}

    public Performer getPerformer() {return performer;}

    public void setPerformer(Performer performer) {this.performer = performer;}

    public String getPerformerType() {return performerType;}

    public void setPerformerType(String performerType) {this.performerType = performerType;}
}
